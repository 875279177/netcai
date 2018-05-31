package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.OrderStatus;
import com.netcai.admin.constants.PayStatus;
import com.netcai.admin.dao.BillDao;
import com.netcai.admin.dao.BuyerDao;
import com.netcai.admin.dao.MessageDao;
import com.netcai.admin.dao.OrderCancelLogsDao;
import com.netcai.admin.dao.OrderInfoDao;
import com.netcai.admin.dao.OrderItemDao;
import com.netcai.admin.dao.OrderItemLogsDao;
import com.netcai.admin.dao.OrderPercentageDao;
import com.netcai.admin.dao.OrderRefundDao;
import com.netcai.admin.dao.OrderTimelineDao;
import com.netcai.admin.dao.SellerDao;
import com.netcai.admin.entity.Message;
import com.netcai.admin.entity.OrderCancelLogs;
import com.netcai.admin.entity.OrderInfo;
import com.netcai.admin.entity.OrderItem;
import com.netcai.admin.entity.OrderItemLogs;
import com.netcai.admin.entity.OrderTimeline;
import com.netcai.admin.entity.Seller;
import com.netcai.admin.service.OrderItemService;
import com.netcai.admin.utils.ArrayListUtil;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillVo;
import com.netcai.admin.vo.BuyerVo;
import com.netcai.admin.vo.OrderItemQuery;
import com.netcai.admin.vo.OrderItemVo;
import com.netcai.admin.vo.PresentOrderDetailVo;
import com.netcai.admin.vo.SellerOrderVo;
import com.netcai.admin.vo.SellerTransactionDetail;

/**
 * 订单明细serviceImpl
 * @author administrator
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderItemServiceImpl.class);

	//订单退款通知
	private static final String MESSAGE="订单退款通知";
	
	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private OrderItemLogsDao orderItemLogsDao;

	@Autowired
	private BuyerDao buyerDao;

	@Autowired
	private SellerDao sellerDao;

	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private OrderPercentageDao orderPercentageDao;
	
	@Autowired
	private OrderRefundDao orderRefundDao;
	
	@Autowired
	private OrderCancelLogsDao orderCancelLogsDao;
	
	@Autowired
	private BillDao billDao;
	
	@Autowired
	private OrderTimelineDao orderTimelineDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public OrderItem getOrderItemById(Long id) {
		return orderItemDao.getOrderItemById(id);
	}

	/**
	 * 通过条件查询
	 */
	@Override
	public PageUtil getPageResult(OrderItem orderItem, Integer currentPageNum, Integer currentPageSize) {

		int size = orderItemDao.getPageCount(orderItem);

		int offset = 0;

		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}

		if (size < offset) {
			offset = 0;
		}

		List<OrderItem> result = orderItemDao.getAll(orderItem, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	/**
	 * 通过条件查询
	 */
	@Override
	public List<OrderItem> getResult(OrderItem OrderItem) {
		List<OrderItem> result = orderItemDao.getOrderItem(OrderItem);
		return result;
	}

	@Override
	public int insertOrderItem(OrderItem orderItem) {

		orderItem.setCreateTime(new Date());

		return orderItemDao.insertOrderItem(orderItem);

	}

	/**
	 * 查询一周内收入前十的卖家
	 * 
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getTonTenIncomes() {
		List<Map<String, Object>> list = orderItemDao.getTonTenIncomes();
		return ArrayListUtil.getArrayListByArray(list, ArrayListUtil.TONTEN_INCOMES);
	}

	/**
	 * 查询一周内收入前十的卖家
	 * 
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getTopTenGoods() {
		List<Map<String, Object>> list = orderItemDao.getTopTenGoods();
		return ArrayListUtil.getArrayListByArray(list, ArrayListUtil.TOPTEN_GOODS);
	}

	@Override
	public List<OrderItemVo> getOrderItemBySellerId(OrderItem orderItem) {
		List<OrderItemVo> orderItemVos = orderItemDao.getOrderItemBySellerId(orderItem);
		for (int i = 0; i < orderItemVos.size(); i++) {
			OrderItemVo orderItemVo = orderItemVos.get(i);
			List<OrderItem> orderItems = orderItemVo.getOrderItems();
			BigDecimal totalMoney = BigDecimal.ZERO;
			for (int j = 0; j < orderItems.size(); j++) {
				OrderItem orderItem1 = orderItems.get(j);
				BigDecimal goodsAmount = orderItem1.getGoodsAmount();
				totalMoney = goodsAmount.add(totalMoney);
			}
			orderItemVo.setTotalMoney(totalMoney);
		}
		return orderItemVos;
	}

	/**
	 * 修改购买数量
	 */
	public void updateOrderItemNumber(Long orderId, Long itemId, Double goodsNumber) {
		Message buyerMessage = new Message();
		OrderItem orderItem = null;
		List<OrderItem> orderItems = orderItemDao.getByOrderId(orderId);
		OrderInfo orderInfo = orderInfoDao.getOrderInfoById(orderId);
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem orderIte = orderItems.get(i);
			Long itemId1 = orderIte.getId();
			if (itemId1.intValue() == itemId.intValue()) {
				orderItem = orderItems.get(i);
				orderItems.remove(i);
			}
		}
		// 买家;
		Long buyerId = orderItem.getBuyerId();
		// 卖家;
		Long sellerId = orderItem.getSellerId();
		// 单价;
		BigDecimal goodsPrice = orderItem.getGoodsPrice();
		// 原数量;
		Double oldNumber = orderItem.getGoodsNumber();
		// 商品名称;
		String goodsName = orderItem.getGoodsName();
		// 原总价;
		BigDecimal goodsAmount = orderItem.getGoodsAmount();
		// 付款方式;
		Integer payStatus = orderInfo.getPayStatus();
		// 现总价;
		BigDecimal totalAmount = BigDecimal.valueOf(goodsNumber).multiply(goodsPrice).setScale(2);
		// 差价;当前价格-old价格;绝对值;
		BigDecimal subtract = totalAmount.subtract(goodsAmount).abs().setScale(2);
		BigDecimal buyerMoney = buyerDao.getById(buyerId);
		if (buyerMoney == null) {
			// 买家当前余额;
			buyerMoney = BigDecimal.ZERO;
		}
		// 修改当前订单项;
		orderItemDao.updateGoodsNumber(goodsNumber, totalAmount, itemId);
		// 修改主表;
		BigDecimal total = BigDecimal.ZERO;
		total = total.add(totalAmount);
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem item = orderItems.get(i);
			BigDecimal Amount = item.getGoodsAmount();
			total = total.add(Amount);
		}
		orderInfoDao.updateGoodsNumber(total, orderId);

		OrderItemLogs orderItemLogs = new OrderItemLogs();
		orderItemLogs.setOrderItemId(itemId);
		orderItemLogs.setBuyerId(buyerId);
		orderItemLogs.setSellerId(sellerId);
		orderItemLogs.setGoodsUnitPrice(goodsPrice);
		orderItemLogs.setGoodsFinalNumber(goodsNumber);
		orderItemLogs.setGoodsFinalPrice(totalAmount);
		orderItemLogs.setTradeMoney(subtract);
		orderItemLogs.setCreateTime(new Date());
		if (goodsNumber == 0) {
			orderItemLogs.setTradeType(3);
		}
		// 修改数量消息通知;
		buyerMessage.setCreateTime(new Date());
		buyerMessage.setMsgName("货物数量修改");
		buyerMessage.setMsgType(1);
		buyerMessage.setUserId(buyerId);
		buyerMessage.setStatus(1);

		// 买家付卖家钱;
		if ((goodsNumber - oldNumber) > 0) {
			buyerMessage.setMsgContent(goodsName + "数量:" + oldNumber + "改为:" + goodsNumber + ",金额:¥" + goodsAmount+ "变为:" + totalAmount + ",[本次应扣余额:" + subtract + "]");
			orderItemLogs.setTradeType(2);
			buyerMoney = buyerMoney.subtract(subtract);
			// 卖家退买家钱;
		} else {
			buyerMessage.setMsgContent(goodsName + "数量:" + oldNumber + "改为:" + goodsNumber + ",金额:¥" + goodsAmount+ "变为:" + totalAmount+ ",应增余额" + subtract + "[余额可以用来下次购物使用]");
			orderItemLogs.setTradeType(1);
			buyerMoney = buyerMoney.add(subtract);
		}
		List<Message> list = new ArrayList<>();
		if (payStatus == PayStatus.PAY_SUCCESS) {
			list.add(buyerMessage);
		}
		// 保存消息通知;
		messageDao.saveBatch(list);
		// 记录变动记录;
		orderItemLogsDao.insert(orderItemLogs);
		// 买家余额变动;
		if (payStatus == PayStatus.PAY_SUCCESS) {
		buyerDao.updateBalanceMoney(buyerId, buyerMoney);
		}
	}

	@Override
	public PageUtil getPageList(OrderItemQuery orderItemQuery, Integer currentPageNum, Integer currentPageSize) {
		int size = orderItemDao.getCount(orderItemQuery);

		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if (size < offset) {
			offset = 0;
		}

		List<OrderItemQuery> result = orderItemDao.getList(orderItemQuery, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public List<OrderItem> getResult(OrderItem orderItem, Integer currentPageNum, Integer currentPageSize) {
		return orderItemDao.getAll(orderItem, currentPageNum, currentPageSize);
	}

	@Override
	public List<OrderItemQuery> getList(OrderItemQuery orderItemQuery, Integer currentPageNum,
			Integer currentPageSize) {
		return orderItemDao.getList(orderItemQuery, currentPageNum, currentPageSize);
	}

	@Override
	public List<OrderItemQuery> getList(OrderItemQuery orderItemQuery) {
		return orderItemDao.getListAll(orderItemQuery);
	}

	@Override
	public ArrayList<SellerOrderVo> getAmountBySellerByDate(SellerOrderVo sellerOrderVo) {
		return orderItemDao.getAmountBySellerByDate(null, sellerOrderVo);
	}

	@Override
	public void updateOrderItemNumberError(Long orderId, Long itemId, Double goodsNumber) {
		OrderItem orderItem = null;
		List<OrderItem> orderItems = orderItemDao.getByOrderId(orderId);
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem orderIte = orderItems.get(i);
			Long itemId1 = orderIte.getId();
			if (itemId1.intValue() == itemId.intValue()) {
				orderItem = orderItems.get(i);
				orderItems.remove(i);
			}
		}
		if(orderItem == null){
			orderItem = orderItemDao.getOrderItemById(itemId);
		}
		// 单价;
		BigDecimal goodsPrice = orderItem.getGoodsPrice();
		// 现总价;
		BigDecimal totalAmount = BigDecimal.valueOf(goodsNumber).multiply(goodsPrice).setScale(2,BigDecimal.ROUND_HALF_UP);
		// 修改主表;
		BigDecimal total = BigDecimal.ZERO;
		total = total.add(totalAmount);
		for (int i = 0; i < orderItems.size(); i++) {
			OrderItem item = orderItems.get(i);
			BigDecimal Amount = item.getGoodsAmount();
			total = total.add(Amount);
		}
		logger.info("[修改调重错误：订单项Id——>]"+"["+itemId+"]");
		orderInfoDao.updateGoodsNumber(total, orderId);
	}

	/**
	 * 根据卖家id查询卖家今日收益详情
	 */
	@Override
	public List<SellerTransactionDetail> selectSellerTransactionDetails(Long sellerId,String time) {
		return orderItemDao.selectSellerTransactionDetails(sellerId,time);
	}

	/**
	 * 根据卖家id查询卖家今日营业金额、抽点金额、及多退少补金额
	 */
	@Override
	public Map<String, Object> selectSellerTransactionAmount(Long sellerId,String time) {
		// 订单总金额
		BigDecimal totalGoodsAmount = orderItemDao.selectSellerTransactionAmount(sellerId,time);
		//根据时间查询卖家抽点总金额
		BigDecimal totalPercentageAmount = orderPercentageDao.getTotalPercentagesAmountByDate(sellerId, time);
		//根据时间查询卖家多退少补总金额
		BigDecimal totalSellerMoney = orderRefundDao.selectTotalSellerMoney(sellerId, time);
		Map<String, Object> map = new HashMap<String, Object>();
		// 订单总金额
		if (totalGoodsAmount == null) {
			totalGoodsAmount = BigDecimal.ZERO;
		}
		map.put("totalGoodsAmount", totalGoodsAmount);
		if (totalPercentageAmount == null) {
			totalPercentageAmount = BigDecimal.ZERO;
		}
		map.put("totalPercentageAmount", totalPercentageAmount);
		if (totalSellerMoney == null) {
			totalSellerMoney = BigDecimal.ZERO;
		}
		map.put("totalSellerMoney", totalSellerMoney);
		// 计算实际收益
		BigDecimal totalIncome = totalGoodsAmount.subtract(totalPercentageAmount).add(totalSellerMoney);
		map.put("totalIncome", totalIncome);
		return map;
	}
	
	/**
	 * 根据卖家id和订单id查询订单明细
	 */
	@Override
	public List<PresentOrderDetailVo> selectPresentOrderDetails(Long orderId, Long sellerId) {
		return orderItemDao.selectPresentOrderDetails(orderId, sellerId);
	}

	@Override
	public void deleteOrderItemById(Long buyerId,Long itemId) {
		// TODO Auto-generated method stub
		//1.去掉订单明细，把orderStatus变成取消订单.
		//2.获取金额，返还给买家的余额
		//3.记录操作日志，方便问题追踪。
		//4.发送message到买家消息里面
		
		OrderItem orderItem=this.orderItemDao.getOrderItemById(itemId);
		
		//获取某一个单项的金额
		BigDecimal goodsAmount=orderItem.getGoodsAmount();
		
		//获取订单ID
		Long orderId=orderItem.getOrderId();
		
		//取消订单
		orderItemDao.cancelOrderItemById(itemId);
		
		OrderInfo orderInfo=this.orderInfoDao.getOrderInfoById(orderId);
		
		//买家对象
		 BuyerVo buyer = buyerDao.getBuyerById(buyerId);
		
		//最终金额
		BigDecimal finalBalanceMoney=goodsAmount.add(buyer.getBalanceMoney());
		
		//线上付款
		if(orderInfo.getPayStatus()==PayStatus.PAY_SUCCESS)
		{
			//更新金额
			buyerDao.updateBuyerBalance(buyerId, finalBalanceMoney);
			//发送消息
			List<Message> listMessage=new ArrayList<Message>();
			
			String content="订单被你取消，退还到你的账号余额:"+goodsAmount+"你的最终余额为：" +finalBalanceMoney;
			
			Message msg=new Message();
			msg.setMsgName(MESSAGE);
			msg.setUserId(buyerId);
			msg.setMsgContent(content);		
			msg.setMsgType(1);
			msg.setStatus(1);
			msg.setCreateTime(new Date());
			listMessage.add(msg);
			this.messageDao.saveBatch(listMessage);
		}
		
		//商品最终金额
		BigDecimal totalAmountMoney=orderInfo.getTotalAmount();
		
		BigDecimal lastAmount=totalAmountMoney.subtract(goodsAmount);
		
		//更新主订单金额
		this.orderInfoDao.updateOrderInfoTotalAmount(orderId,lastAmount);
		
		//记录日志
		OrderCancelLogs orderCancelLogs =new OrderCancelLogs();
		
		orderCancelLogs.setBuyerId(buyerId);
		orderCancelLogs.setCreateTime(new Date());
		orderCancelLogs.setOrderSn(itemId);
		orderCancelLogs.setTradeMoney(goodsAmount);
		orderCancelLogs.setCurrentMoney(buyer.getBalanceMoney());
		orderCancelLogs.setLastMoney(finalBalanceMoney);
		orderCancelLogs.setRemarks("订单明细取消");
		orderCancelLogsDao.addOrderCancelLogs(orderCancelLogs);
	}
	
	/**
	 * 分页查询缺货和退货的子订单
	 */
	@Override
	public PageUtil getRedressOrderItems(OrderItem orderItem,Integer statusCode,int currentPageNum,int currentPageSize) {
		int size = orderItemDao.getRedressOrderItemCount(orderItem, statusCode);

		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if (size < offset) {
			offset = 0;
		}

		List<OrderItem> result = orderItemDao.getRedressOrderItems(orderItem,statusCode,offset,currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}
	
	/**
	 * 确认退货（卖家点击确认退货功能）
	 */
	@Override
	public int returnOrderItem(Long itemId) {
		// 查询子订单
		OrderItem orderItem = orderItemDao.getOrderItemById(itemId);
		if(orderItem==null){
			return 0;
		}
		if (orderItem.getOrderStatus().intValue()==OrderStatus.ORDER_CANCEL)
		{
			return -1;
		}
		Long buyerId = orderItem.getBuyerId();
		BigDecimal goodsAmount = orderItem.getGoodsAmount();
		String remarks = "后台操作，退货子订单id为:" + itemId;
		
		if (goodsAmount.compareTo(BigDecimal.ZERO) != 0 && goodsAmount != null) {
			// 查询主订单
			OrderInfo orderInfo = orderInfoDao.getOrderInfoById(orderItem.getOrderId());
			Integer payStatus = orderInfo.getPayStatus();
			BigDecimal totalAmount = orderInfo.getTotalAmount();

			//查询卖家信息
			Seller seller = sellerDao.getSellerByKey(orderItem.getSellerId()).get(0);
			BigDecimal sellerBalanceMoney = seller.getBalanceMoney();
			BigDecimal subtractSellerBalanceMoney = sellerBalanceMoney.subtract(goodsAmount);
			BigDecimal billMoney = seller.getBillMoney();
			BigDecimal subtractBillMoney = billMoney.subtract(goodsAmount);

			//查询买家信息
			BuyerVo buyer = buyerDao.getBuyerById(buyerId);
			BigDecimal buyerBalanceMoney = buyer.getBalanceMoney();
			BigDecimal addBuyerBalanceMoney = buyerBalanceMoney.add(goodsAmount);

			// 查询子订单送到时间当天的卖家账单
			BillVo bill = billDao.getBillSellerIdAndByDate(DateUtil.dateToString(orderInfo.getBestTime(), DateUtil.FMT_DATE),
					orderItem.getSellerId());

			// 若账单存在则修改账单金额
			if (bill != null) {
				Long id = bill.getId();
				// 应收款
				BigDecimal realityMoney = bill.getExpectIncome();
				BigDecimal subtractRealityMoney = realityMoney.subtract(goodsAmount);
				// 实收款
				BigDecimal shouldMoney = bill.getRealIncome();
				BigDecimal subtractShouldMoney = shouldMoney.subtract(goodsAmount);
				Integer billStatus = bill.getStatus();

				BillVo b = new BillVo();
				b.setExpectIncome(subtractShouldMoney);
				b.setRealIncome(subtractRealityMoney);
				b.setId(id);
				//改变卖家账单金额
				billDao.update(b);
				remarks += "[后台操作]商品的金额为："+goodsAmount;
				logger.info("[退货]修改卖家应收款金额:[" + shouldMoney + "]——>[" + subtractShouldMoney + "]" + "实收款金额:["
						+ realityMoney + "]——>[" + subtractRealityMoney + "]");

				// 若该账单不在提现账期,直接扣除账单金额和余额即可,否则该账单已出账需要修改卖家可提现余额和余额
				if (billStatus == 0) {
					//更新卖家余额
					sellerDao.updateBalanceMoney(orderItem.getSellerId(), subtractSellerBalanceMoney);
					logger.info("[退货]修改卖家余额:[" + sellerBalanceMoney + "]——>[" + subtractSellerBalanceMoney + "]");

				} else {
					//更新卖家余额和可提现余额
					sellerDao.updateBalanceMoneyAndBillMoney(orderItem.getSellerId(), subtractSellerBalanceMoney, subtractBillMoney);
					logger.info("[退货]修改卖家余额:[" + sellerBalanceMoney + "]——>[" + subtractSellerBalanceMoney + "]"
							+ "可提现余额:[" + billMoney + "]——>[" + subtractBillMoney + "]");
				}

			}
			// 若是线上付款则
			if (payStatus == PayStatus.PAY_SUCCESS) {
				//更新买家余额
				buyerDao.updateBalanceMoney(buyerId, addBuyerBalanceMoney);
				remarks += "，订单为线上支付，商品金额退还到买家余额";
				logger.info("[退货]修改买家余额:[" + buyerBalanceMoney + "]——>[" + addBuyerBalanceMoney + "]");

			}

			//更新主订单总金额
			BigDecimal subtractTotalAmount = totalAmount.subtract(goodsAmount);
			orderInfoDao.updateGoodsNumber(subtractTotalAmount, orderItem.getOrderId());
			remarks += "，主订单总金额更新为:"+subtractTotalAmount;
			logger.info("[退货]修改订单最终金额:[" + totalAmount + "]——>[" + subtractTotalAmount + "]");
		}
		
		//更新子订单状态为退货完成
		orderItemDao.returnFinish(itemId);
		remarks += "，退货已确认";
		
		//增加时间轴
		OrderTimeline orderTimeline = new OrderTimeline();
		orderTimeline.setCreateTime(new Date());
		orderTimeline.setItemId(itemId);
		orderTimeline.setRemarks(remarks);
		return orderTimelineDao.insert(orderTimeline);
	}
	
	/**
	 * 根据主订单id查询缺货和退货订单
	 */
	@Override
	public List<OrderItem> getImproperOrderItems(Long orderId) {
		return orderItemDao.getImproperOrderItems(orderId);
	}
	
}