package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BillDao;
import com.netcai.admin.dao.BuyerDao;
import com.netcai.admin.dao.MessageDao;
import com.netcai.admin.dao.OrderRefundDao;
import com.netcai.admin.dao.RefundCauseDao;
import com.netcai.admin.dao.SellerDao;
import com.netcai.admin.entity.Message;
import com.netcai.admin.entity.RefundCause;
import com.netcai.admin.service.OrderRefundService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillVo;
import com.netcai.admin.vo.OrderRefundVo;

/**
 * 补差价信息service
 * 
 * @author administrator
 *
 */
@Service
public class OrderRefundServiceImpl implements OrderRefundService {

	@Autowired
	private OrderRefundDao orderRefundDao;
	@Autowired
	private SellerDao sellerDao;
	@Autowired
	private BuyerDao buyerDao;
	@Autowired
	private BillDao billDao;
	@Autowired
	private RefundCauseDao refundCauseDao;
	@Autowired
	private MessageDao messageDao;

	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAll(OrderRefundVo orderRefund, int pageNum, int pageSize) {
		int size = orderRefundDao.getPageCount(orderRefund);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<OrderRefundVo> result = orderRefundDao.getAll(orderRefund, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 多退少补信息新增
	 */
	@Override
	public int insert(OrderRefundVo orderRefund) {
		Long buyerId = orderRefund.getBuyerId();
		Long sellerId = orderRefund.getSellerId();
		// 查询买家余额
		BigDecimal buyer_balanceMoney = buyerDao.getById(buyerId);
		if (buyer_balanceMoney == null) {
			buyer_balanceMoney = BigDecimal.ZERO;
		}
		// 查询卖家余额
		BigDecimal seller_balanceMoney = sellerDao.getById(sellerId);
		if (seller_balanceMoney == null) {
			seller_balanceMoney = BigDecimal.ZERO;
		}
		// 买家卖家余额加上其差价金额
		seller_balanceMoney = seller_balanceMoney.add(orderRefund.getSellerMoney());
		buyer_balanceMoney = buyer_balanceMoney.add(orderRefund.getBuyerMoney());

		// 更新相应日期账单中的扣款和实际金额
		Map<String, Object> time = DateUtil.getOneDayTime(orderRefund.getCreateTime());
		time.put("sellerId", sellerId);
		List<BillVo> bills = billDao.getBillsBySellerId(time);
		// 查询多退少补日期当天的账单只能有一条记录
		if (CollectionUtils.isEmpty(bills) || bills.size() != 1) {
			return -1;
		}
		BillVo bill = bills.get(0);
		// 更新扣款
		BigDecimal deductMoney = bill.getDeductMoney();
		if (deductMoney == null) {
			deductMoney = BigDecimal.ZERO;
		}
		deductMoney = deductMoney.add(orderRefund.getSellerMoney());
		bill.setDeductMoney(deductMoney);
		// 更新实际金额
		BigDecimal realIncome = bill.getRealIncome();
		if (realIncome == null) {
			realIncome = BigDecimal.ZERO;
		}
		realIncome = realIncome.add(orderRefund.getSellerMoney());
		bill.setRealIncome(realIncome);
		// 更新账单的扣款和实际金额
		billDao.update(bill);
		// 更新卖家余额
		sellerDao.updateBalanceMoney(sellerId, seller_balanceMoney);
		// 更新买家余额
		buyerDao.updateBalanceMoney(buyerId, buyer_balanceMoney);

		// 查询选择多退少补的原因
		if (StringUtils.isNotBlank(orderRefund.getRefundCauseIds())) {
			String causeId = orderRefund.getRefundCauseIds();
			List<Long> ids = new ArrayList<Long>();
			if (causeId.indexOf(",") != -1) {
				String[] causeIds = causeId.split(",");
				if (causeIds.length == 1) {
					if (StringUtils.isNotBlank(causeIds[0].trim())) {
						ids.add(Long.parseLong(causeIds[0]));
					}
				}
				if (causeIds.length == 2) {
					if (StringUtils.isNotBlank(causeIds[0].trim())) {
						ids.add(Long.parseLong(causeIds[0]));
					}
					if (StringUtils.isNotBlank(causeIds[1].trim())) {
						ids.add(Long.parseLong(causeIds[1]));
					}
				}
			} else {
				ids.add(Long.parseLong(causeId));
			}
			List<RefundCause> reasons = null;
			// 根据多个id查询原因
			if (CollectionUtils.isNotEmpty(ids)) {
				reasons = refundCauseDao.getByIds(ids);
			}
			// 将原因拼接
			String reason = "";
			if (CollectionUtils.isNotEmpty(reasons)) {
				for (RefundCause entity : reasons) {
					reason += entity.getName() + ",";
				}
				reason = reason.substring(0, reason.lastIndexOf(","));
				orderRefund.setReason(reason);
			}
		}

		orderRefund.setIsShow(0);
		// 消息通知;
		Message sellerMessage = new Message();
		Message buyerMessage = new Message();
		String remark = orderRefund.getRemark();
		if (StringUtils.isNotBlank(remark)) {
			String[] split = remark.split("/");
			if (split.length == 2) {
				if (!split[0].equals("；") && !split[0].equals(";") && split[0] != null && split[0] != "") {
					buyerMessage.setCreateTime(new Date());
					buyerMessage.setMsgName("多退少补");
					buyerMessage.setMsgType(1);
					buyerMessage.setUserId(buyerId);
					buyerMessage.setStatus(1);
					buyerMessage.setMsgContent(split[0]);
				}
				if (!split[1].equals("；") && !split[1].equals(";") && split[1] != null && split[1] != "") {
					sellerMessage.setCreateTime(new Date());
					sellerMessage.setMsgName("多退少补");
					sellerMessage.setMsgType(1);
					sellerMessage.setUserId(sellerId);
					sellerMessage.setStatus(1);
					sellerMessage.setMsgContent(split[1]);

					// 当且仅当对卖家进行操时;卖家端显示多退少补;
					orderRefund.setIsShow(1);
					orderRefund.setRemark(split[1]);
				}
			}
		}
		List<Message> list = new ArrayList<>();
		if (StringUtils.isNotBlank(buyerMessage.getMsgContent())) {
			list.add(buyerMessage);
		}
		if (StringUtils.isNotBlank(sellerMessage.getMsgContent())) {
			list.add(sellerMessage);
		}
		// 保存消息通知;
		messageDao.saveBatch(list);
		return orderRefundDao.insert(orderRefund);
	}

	/**
	 * 根据卖家id查询订单多退少补信息
	 */
	@Override
	public List<OrderRefundVo> selectBySellerId(Long sellerId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("sellerId", sellerId);
		List<OrderRefundVo> list = orderRefundDao.selectByMap(map);
		if (CollectionUtils.isEmpty(list)) {
			list = new ArrayList<OrderRefundVo>();
		}
		return list;
	}

	/**
	 * 根据卖家id查询某天的多退少补信息
	 */
	@Override
	public List<OrderRefundVo> selectBysellerId(Long sellerId, Date createTime) {
		return orderRefundDao.selectBysellerId(sellerId, createTime);
	}

	/**
	 * 获取多退少补原因
	 */
	@Override
	public List<RefundCause> getAllReasons() {
		return refundCauseDao.getAll();
	}

}
