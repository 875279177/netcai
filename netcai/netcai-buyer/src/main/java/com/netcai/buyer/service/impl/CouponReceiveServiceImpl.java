package com.netcai.buyer.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.constants.CouponReceiveStatus;
import com.netcai.buyer.dao.CouponDao;
import com.netcai.buyer.dao.CouponLogsDao;
import com.netcai.buyer.dao.CouponReceiveDao;
import com.netcai.buyer.entity.Coupon;
import com.netcai.buyer.entity.CouponLogs;
import com.netcai.buyer.entity.CouponReceive;
import com.netcai.buyer.service.CouponReceiveService;

@Service
public class CouponReceiveServiceImpl implements CouponReceiveService {

	@Autowired
	private CouponReceiveDao couponReceiveDao;
	@Autowired
	private CouponDao couponDao;
	@Autowired
	private CouponLogsDao couponLogsDao;

	/**
	 * 根据买家查询其所有优惠券
	 */
	@Override
	public List<CouponReceive> selectAllByBuyerId(Long buyerId) {
		return couponReceiveDao.selectAllByBuyerId(buyerId);
	}

	/**
	 * 买家是否有优惠券可以领取
	 */
	@Override
	public List<Coupon> selectByBuyerId(Long buyerId) {
		// 查询买家可以参与的有活动
		List<Coupon> coupons = couponDao.selectCoupon(buyerId);
		if (CollectionUtils.isEmpty(coupons)) {
			return null;
		}
		Iterator<Coupon> iterator = coupons.iterator();
		while (iterator.hasNext()) {
			Coupon coupon = iterator.next();
			if (coupon == null || coupon.getId() == null) {
				continue;
			}
			// 查询买家是否领过优惠券
			CouponReceive couponReceive = couponReceiveDao.selectByBuyerId(buyerId, coupon.getId());
			// 已经领取过优惠券不可以再次领取
			if (couponReceive != null) {
				iterator.remove();
			}
		}
		// 将未领取过的优惠券返回
		return coupons;
	}

	/**
	 * 新增数据
	 */
	@Override
	public int insert(Long buyerId, Long couponId) {
		// 判断领取的优惠券数据是否存在,若存在则不能再领取优惠券
		CouponReceive receive = couponReceiveDao.selectByBuerIdAndCouponId(buyerId, couponId);
		if (receive != null) {
			return -1;
		}
		// 查询买家领取优惠券的配置
		Coupon coupon = couponDao.selectCouponById(couponId);
		if (coupon == null) {
			return 0;
		}
		// 优惠配置的金额为空则跳过
		if (coupon.getMoney() == null) {
			return 0;
		}

		CouponReceive couponReceive = new CouponReceive();
		couponReceive.setBuyerId(buyerId);
		couponReceive.setCouponId(coupon.getId());
		couponReceive.setCouponMoney(coupon.getMoney());
		couponReceive.setFullMoney(coupon.getFullMoney());
		// 设置状态为未使用
		couponReceive.setStatus(CouponReceiveStatus.UN_USED);
		couponReceive.setCreateTime(new Date());
		// 新增优惠券
		return couponReceiveDao.insert(couponReceive);
	}

	/**
	 * 抵扣优惠券
	 */
	public BigDecimal deductionCouponMoney(Long couponReceiveId, String orderNumber, BigDecimal originalPayAmount) {
		// 根据优惠券id查询优惠券金额
		CouponReceive couponReceive = couponReceiveDao.selectById(couponReceiveId);
		if (couponReceive != null && couponReceive.getCouponMoney() != null) {
			// 若优惠券金额不为空，则订单的支付金额减去优惠券金额
			BigDecimal finalPayAmount = originalPayAmount.subtract(couponReceive.getCouponMoney());
			// 将变动金额记录到日志
			CouponLogs couponLog = new CouponLogs();
			couponLog.setBuyerId(couponReceive.getBuyerId());
			couponLog.setCouponReceiveId(couponReceive.getId());
			couponLog.setCouponAmount(couponReceive.getCouponMoney());
			couponLog.setOrderNumber(orderNumber);
			couponLog.setOriginalOrderAmount(originalPayAmount);
			couponLog.setFinalOrderAmount(finalPayAmount);
			couponLog.setCreateTime(new Date());
			int result = couponLogsDao.insert(couponLog);
			// 先将金额变动保存到日志再返回数据
			if (result > 0) {
				return finalPayAmount;
			}
		}
		return originalPayAmount;
	}

	/**
	 * 更新优惠券状态为已用
	 */
	@Override
	public int updateStatus(String orderNum) {
		//根据订单号查询优惠券id
		Long id = couponLogsDao.getCouponIdByOrderNum(orderNum);
		if (id == null) {
			return 0;
		}
		//更新日志状态
		couponLogsDao.updateStatus(orderNum);
		return couponReceiveDao.update(id);
	}

}
