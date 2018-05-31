package com.netcai.buyer.service;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.buyer.entity.Coupon;
import com.netcai.buyer.entity.CouponReceive;

/**
 * 优惠券领取记录表service
 * @author administrator
 *
 */
public interface CouponReceiveService {
	
	/**
	 * 根据买家查询其所有优惠券
	 * @return
	 */
	public List<CouponReceive> selectAllByBuyerId(Long buyerId);
	
	/**
	 * 买家是否可以领取优惠券
	 * @return
	 */
	public List<Coupon> selectByBuyerId(Long buyerId);
	
	/**
	 * 新增数据
	 * @param buyerId
	 * @param couponId
	 * @return
	 */
	public int insert(Long buyerId,Long couponId);
	
	/**
	 * 抵扣优惠券
	 * @param couponReceiveId
	 * @param orderNumber
	 * @param originalPayAmount
	 */
	public BigDecimal deductionCouponMoney(Long couponReceiveId,String orderNumber,BigDecimal originalPayAmount);
	
	/**
	 * 更新优惠券状态为已用
	 * @param orderNum
	 * @return
	 */
	public int updateStatus(String orderNum);
	
}
