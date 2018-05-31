package com.netcai.buyer.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.constants.BuyerStatus;
import com.netcai.buyer.constants.OrderStatus;
import com.netcai.buyer.constants.PayStatus;
import com.netcai.buyer.constants.SellerStatus;
import com.netcai.buyer.dao.AreaDao;
import com.netcai.buyer.dao.BuyerDao;
import com.netcai.buyer.dao.CouponDao;
import com.netcai.buyer.dao.CouponLogsDao;
import com.netcai.buyer.dao.CouponReceiveDao;
import com.netcai.buyer.dao.GoodsCartDao;
import com.netcai.buyer.dao.GoodsFormatDao;
import com.netcai.buyer.dao.MessageDao;
import com.netcai.buyer.dao.OrderCancelLogsDao;
import com.netcai.buyer.dao.OrderInfoDao;
import com.netcai.buyer.dao.OrderItemDao;
import com.netcai.buyer.dao.PayLogsDao;
import com.netcai.buyer.entity.Buyer;
import com.netcai.buyer.entity.Coupon;
import com.netcai.buyer.entity.CouponLogs;
import com.netcai.buyer.entity.CouponReceive;
import com.netcai.buyer.entity.GoodsFormat;
import com.netcai.buyer.entity.Message;
import com.netcai.buyer.entity.OrderCancelLogs;
import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.entity.PayLogs;
import com.netcai.buyer.service.OrderInfoService;
import com.netcai.buyer.vo.GoodsDetailsVo;
import com.netcai.buyer.vo.TransactionDetails;

/**
 * 订单实现类
 * 
 * @author administrator
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	// 订单退款通知
	private static final String MESSAGE = "订单退款通知";

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private GoodsFormatDao goodsFormatDao;

	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private GoodsCartDao goodsCartDao;

	@Autowired
	private BuyerDao buyerDao;

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private PayLogsDao payLogsDao;

	@Autowired
	private OrderCancelLogsDao orderCancelLogsDao;

	@Autowired
	private CouponDao couponDao;

	@Autowired
	private CouponReceiveDao couponReceiveDao;

	@Autowired
	private CouponLogsDao couponLogsDao;

	@Autowired
	private MessageDao messageDao;

	@Override
	public List<OrderInfo> getAllOrderInfo(Long buyerId, int orderStatus) {
		return orderInfoDao.getAllOrderInfo(buyerId, orderStatus);
	}

	/**
	 * 订单超时取消订单
	 */
	@Override
	public void cancelOrderInfo(Long orderId) {
		// 取消订单
		orderInfoDao.cancelOrderInfo(orderId);
		// 取消订单项
		orderItemDao.cancelOrderItem(orderId);
	}

	@Override
	public OrderInfo addOrderInfo(OrderInfo orderInfo, List<OrderItem> orderItems, List<Long> cartIds) {

		// totalAmount订单总金额：
		BigDecimal totalAmount = BigDecimal.ZERO;

		// 查询订单项中的上架商品规格ID和单价;
		List<GoodsFormat> goodsFormats = goodsFormatDao.getFormatIdByIdAndFormatStatus(orderItems);
		Map<Long, GoodsFormat> gfMap = new HashMap<Long, GoodsFormat>();
		for (int i = 0; i < goodsFormats.size(); i++) {
			GoodsFormat goodsFormat = goodsFormats.get(i);
			gfMap.put(goodsFormat.getFormatId(), goodsFormat);
		}
		// 统计总金额 设置订单项状态属性;
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem orderItem = orderItems.get(i);
			Long formatId = orderItem.getFormatId();

			if (gfMap.containsKey(formatId)) {
				GoodsFormat goodsFormat = gfMap.get(formatId);
				BigDecimal formatPrice = goodsFormat.getFormatPrice();
				BigDecimal goodsNumber = orderItem.getGoodsNumber();
				BigDecimal goodsAmount = formatPrice.multiply(goodsNumber);

				orderItem.setGoodsNumberOld(orderItem.getGoodsNumber());
				orderItem.setSellerStatus(SellerStatus.SELLER_PLAN);
				orderItem.setOrderStatus(OrderStatus.ORDER_SUBMIT);
				orderItem.setBuyerStatus(BuyerStatus.BUYER_WAIT_TAKE);
				orderItem.setCreateTime(new Date());

				// 设置商品项总金额;
				orderItem.setGoodsAmount(goodsAmount);
				// 设置商品单价;
				orderItem.setGoodsPrice(formatPrice);
				totalAmount = goodsAmount.add(totalAmount);
			} else {
				// 移除订单项中的下架商品;
				orderItems.remove(i);
			}
		}
		// 判断主订单总金额是否大于起送价，若大于则才可以创建订单
		Long buyerId = orderInfo.getBuyerId();
		BigDecimal sendingAmount = areaDao.getSendingPrice(buyerId);
		int result = orderInfoDao.getCountByBuyerIdAndCreateTime(buyerId, new Date());
		if(result < 1){
			if (sendingAmount != null && sendingAmount.compareTo(totalAmount) == 1) {
				return null;
			}
		}

		// 设置订单最终总额;
		orderInfo.setTotalAmount(totalAmount);
		// 设置订单计算总额;
		orderInfo.setOrderAmount(totalAmount);
		// 增加主表
		orderInfoDao.addOrderInfo(orderInfo);

		// 增加List<OrderItem>表
		// 设置值;
		orderInfo.setOrderItem(orderItems);
		orderItemDao.insertOrderItem(orderInfo);

		// 删除购物车
		goodsCartDao.deleteGoodsCartBatch(cartIds);

		// 返回订单总表信息;
		return orderInfo;
	}

	@Override
	public void payReturn(OrderInfo orderInfo, PayLogs payLogs) {
		orderInfoDao.payReturn(orderInfo);
		orderItemDao.updateOrderItemByOrderNumber(orderInfo.getOrderNumber());
		buyerDao.updateBuyerBalanceToZero(orderInfo.getBuyerId());
		payLogsDao.updatePayLogs(payLogs);
	}

	@Override
	public OrderInfo getOrderInfoByOrderNumber(String orderNumber) {
		return orderInfoDao.getOrderInfoByOrderNumber(orderNumber);
	}

	@Override
	public OrderInfo getOrderInfoByOrderId(Long orderId) {
		return orderInfoDao.getOrderInfoByOrderId(orderId);
	}

	@Override
	public void mypayReturn(OrderInfo orderInfo, PayLogs payLogs, BigDecimal balanceMoney) {
		orderInfoDao.payReturn(orderInfo);
		orderItemDao.updateOrderItemByOrderNumber(orderInfo.getOrderNumber());
		buyerDao.updateBuyerBalance(orderInfo.getBuyerId(), balanceMoney);
		payLogsDao.updatePayLogs(payLogs);
	}

	/**
	 * 添加买家常用清单
	 */
	public int insertBuyerCommon(Long orderId) {
		return orderInfoDao.insertBuyerCommon(orderId);
	}

	/**
	 * 判断买家订单金额是否达到指定金额并获取相应的优惠券
	 */
	@Override
	public Map<String, Object> costExceedFullMoney(List<OrderItem> orderItems, Long buyerId) {
		Map<String, Long> queryMap = new HashMap<String, Long>();
		Map<String, Object> transactionDetailsMap = new HashMap<String, Object>();
		Set<Long> sellerIds = new HashSet<Long>();
		List<GoodsDetailsVo> goodsDetailsVos = null;
		for (OrderItem orderItem : orderItems) {
			if (orderItem != null && orderItem.getFormatId() != null) {
				queryMap.put("formatId", orderItem.getFormatId());
				if (orderItem.getMethodId() != null && orderItem.getMethodId().longValue() != 0) {
					queryMap.put("methodId", orderItem.getMethodId());
				}
			}
			// 根据子订单中的商品规格id和加工方式id查询上架商品详细信息
			TransactionDetails transactionDetails = goodsFormatDao.getGoodsDetailsByFormateIds(queryMap);
			if (transactionDetails != null && transactionDetails.getSellerId() != null) {
				// 获取卖家店铺中的详细信息集合
				goodsDetailsVos = transactionDetails.getGoodsDetailList();
				if (CollectionUtils.isNotEmpty(goodsDetailsVos)) {
					// 将购买数量存入商品信息集合中
					goodsDetailsVos.get(0).setGoodsNumber(orderItem.getGoodsNumber());
				}
				Long sellerId = transactionDetails.getSellerId();
				// 根据卖家id判断是否是同一个卖家的蔬菜
				if (sellerIds.contains(sellerId)) {
					TransactionDetails entity = (TransactionDetails) transactionDetailsMap.get(sellerId.toString());
					// 将同一卖家的所有商品合并到一个集合中
					entity.getGoodsDetailList().addAll(transactionDetails.getGoodsDetailList());
					transactionDetailsMap.put(sellerId.toString(), entity);
				} else {
					transactionDetailsMap.put(sellerId.toString(), transactionDetails);
				}
				sellerIds.add(sellerId);
				queryMap.clear();
			}
		}
		// 目前默认是一级节点是蔬菜，以后从配置中获取
		int categoryId = 1;
		// 查询一级节点下的所有商品规格id
		List<Long> formateIds = goodsFormatDao.getFormatIdsByLevelOne(categoryId);
		BigDecimal total_amount = BigDecimal.ZERO;
		List<TransactionDetails> transactionDetailsList = new ArrayList<TransactionDetails>();
		for (Object value : transactionDetailsMap.values()) {
			TransactionDetails transactionDetailsValue = (TransactionDetails) value;
			// 获取卖家店铺中的详细信息集合
			goodsDetailsVos = transactionDetailsValue.getGoodsDetailList();
			// 统计商品详细信息中获取蔬菜的总金额
			for (GoodsDetailsVo goodsDetails : goodsDetailsVos) {
				if (goodsDetails == null) {
					continue;
				}
				// 判断子订单的规格是否是属于蔬菜，若是则累加相应子订单金额
				if (formateIds.contains(goodsDetails.getFormatId())) {
					BigDecimal goodsNum = goodsDetails.getGoodsNumber();
					// 判断购买数量是否正常
					if (goodsNum == null || goodsNum.compareTo(BigDecimal.ZERO) != 1) {
						continue;
					}
					BigDecimal price = goodsDetails.getFormatPrice();
					if (price == null || price.compareTo(BigDecimal.ZERO) != 1) {
						continue;
					}
					BigDecimal goodsAmount = goodsNum.multiply(price);
					total_amount = total_amount.add(goodsAmount);
				}
			}
			transactionDetailsList.add((TransactionDetails) transactionDetailsValue);
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("transactionDetailsList", transactionDetailsList);
		List<CouponReceive> couponReceives = new ArrayList<CouponReceive>();
		// 如果计算的总金额为0，则一定不满足满减金额，可以不必查询优惠券
		if (total_amount.compareTo(BigDecimal.ZERO) == 0) {
			result.put("couponReceives", couponReceives);
			return result;
		}
		// 根据买家查询优惠券配置
		List<Coupon> coupons = couponDao.selectCoupon(buyerId);
		if (CollectionUtils.isEmpty(coupons)) {
			result.put("couponReceives", couponReceives);
			return result;
		}
		for (Coupon coupon : coupons) {
			if (coupon == null || coupon.getId() == null || coupon.getFullMoney() == null) {
				continue;
			}
			// 蔬菜的下单金额是不小于优惠券的配置满额，则可以使用优惠券
			if (total_amount.compareTo(coupon.getFullMoney()) != -1) {
				CouponReceive entity = couponReceiveDao.getAvailableByBuyerId(buyerId, coupon.getId());
				if (entity != null) {
					couponReceives.add(entity);
				}

			}
		}
		// 将优惠券数据返回
		result.put("couponReceives", couponReceives);
		return result;
	}

	@Override
	public void deleteOrderInfo(Long buyerId, Long orderId) {

		OrderInfo orderInfo = this.orderInfoDao.getOrderInfoByOrderId(orderId);

		// 买家对象
		Buyer buyer = buyerDao.getBuyerById(buyerId);

		// 总金额
		BigDecimal totalAmount = orderInfo.getTotalAmount();
		// 最终金额
		totalAmount = totalAmount.add(buyer.getBalanceMoney());

		// 若是线上付款
		if (orderInfo.getPayStatus() == PayStatus.PAY_SUCCESS) {
			// 查询是否使用过优惠券
			CouponLogs couponLogs = couponLogsDao.getLogByOrderNum(orderInfo.getOrderNumber());
			if (couponLogs != null) {
				BigDecimal couponAmount = couponLogs.getCouponAmount();
				if (couponAmount != null && couponAmount != BigDecimal.ZERO) {
					// 使用过优惠券退款时，要扣除掉优惠券金额
					totalAmount = totalAmount.subtract(couponAmount);
				}
			}
			// 更新金额
			buyerDao.updateBuyerBalance(buyerId, totalAmount);

			// 发送消息
			List<Message> listMessage = new ArrayList<Message>();

			String content = "订单被你取消，退还到你的账号余额:" + totalAmount + "你的最终余额为：" + totalAmount;

			Message msg = new Message();
			msg.setMsgName(MESSAGE);
			msg.setUserId(buyerId);
			msg.setMsgContent(content);
			msg.setMsgType(1);
			msg.setStatus(1);
			msg.setCreateTime(new Date());
			listMessage.add(msg);
			this.messageDao.saveBatch(listMessage);
		}

		// 记录日志
		OrderCancelLogs orderCancelLogs = new OrderCancelLogs();
		orderCancelLogs.setBuyerId(buyerId);
		orderCancelLogs.setCreateTime(new Date());
		orderCancelLogs.setOrderSn(orderId);
		orderCancelLogs.setTradeMoney(totalAmount);
		orderCancelLogs.setCurrentMoney(buyer.getBalanceMoney());
		orderCancelLogs.setLastMoney(totalAmount);
		orderCancelLogs.setRemarks("整个订单取消");
		orderCancelLogsDao.addOrderCancelLogs(orderCancelLogs);

		orderItemDao.cancelAllOrderItem(orderId);

		orderInfoDao.cancelAllOrderInfo(orderId);

	}

	/**
	 * 货到付款;
	 */
	@Override
	public int updatePayStatus(Long orderId, int payStatus) {
		return orderInfoDao.updatePayStatus(orderId, payStatus);
	}

	@Override
	public int getCountByBuyerIdAndCreateTime(Long buyerId, Date createTime) {
		return orderInfoDao.getCountByBuyerIdAndCreateTime(buyerId, createTime);
	}
}