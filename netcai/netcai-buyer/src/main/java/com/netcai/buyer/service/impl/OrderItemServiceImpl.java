package com.netcai.buyer.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.constants.PayStatus;
import com.netcai.buyer.dao.BuyerDao;
import com.netcai.buyer.dao.MessageDao;
import com.netcai.buyer.dao.OrderCancelLogsDao;
import com.netcai.buyer.dao.OrderInfoDao;
import com.netcai.buyer.dao.OrderItemDao;
import com.netcai.buyer.entity.Buyer;
import com.netcai.buyer.entity.Message;
import com.netcai.buyer.entity.OrderCancelLogs;
import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.service.OrderItemService;
import com.netcai.buyer.vo.GoodsCartVo;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	//订单退款通知
	private static final String MESSAGE="订单退款通知";
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private BuyerDao buyerDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private OrderCancelLogsDao orderCancelLogsDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Override
	public void cacelOrderItemById(Long itemId) {
		orderItemDao.cancelOrderItemById(itemId);
	}

	@Override
	public List<OrderItem> getAllOrderItemByOrderId(Long orderId) {
		return orderItemDao.getAllOrderItemByOrderId(orderId);
	}

	@Override
	public List<GoodsCartVo> getOrderItemByOrderId(Long orderId) {
		return orderItemDao.getOrderItemByOrderId(orderId);
	}
	
	@Override
	public OrderItem getOrderItemByItemId(Long itemId) {
		return orderItemDao.getOrderItemByItemId(itemId);
	}

	@Override
	public void deleteOrderItemById(Long buyerId,Long itemId) {
		// TODO Auto-generated method stub
		//1.去掉订单明细，把orderStatus变成取消订单.
		//2.获取金额，返还给买家的余额
		//3.记录操作日志，方便问题追踪。
		//4.发送message到买家消息里面
		
		OrderItem orderItem=this.orderItemDao.getOrderItemByItemId(itemId);
		
		//获取某一个单项的金额
		BigDecimal goodsAmount=orderItem.getGoodsAmount();
		
		//获取订单ID
		Long orderId=orderItem.getOrderId();
		
		//取消订单
		orderItemDao.cancelOrderItemById(itemId);
		
		OrderInfo orderInfo=this.orderInfoDao.getOrderInfoByOrderId(orderId);
		
		//买家对象
		Buyer buyer=buyerDao.getBuyerById(buyerId);
		
		//最终金额
		BigDecimal finalBalanceMoney=goodsAmount.add(buyer.getBalanceMoney());
		
		//线下付款
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
}