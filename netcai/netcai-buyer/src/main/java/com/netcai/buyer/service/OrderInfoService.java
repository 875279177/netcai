package com.netcai.buyer.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.entity.PayLogs;

public interface OrderInfoService {

	public List<OrderInfo> getAllOrderInfo(Long buyerId,int orderStatus);
	
	/**
	 * 取消订单,则把所有对应的订单项都取消(订单超时取消订单)
	 * @return
	 */
	public void cancelOrderInfo(Long orderId);
	
	/**
	 * 删除单个订单,则把所有对应的订单项都取消
	 * @return
	 */
	public void deleteOrderInfo(Long buyerId,Long orderId);
	/**
	 *
	 * 根据订单编号获取订单信息
	 * @param orderId 订单编号
	 * @return
	 * 
	 */
	public OrderInfo getOrderInfoByOrderId(Long orderId);
	
	/**
	 * 根据订单号获取订单信息
	 * @param orderNumber  订单号
 	 * @return
	 */
	public OrderInfo getOrderInfoByOrderNumber(String orderNumber);
	
	/**
	 * 创建订单
	 * @param orderInfo
	 * @param orderItems
	 * @param cartIds
	 * @return
	 */
	public OrderInfo addOrderInfo(OrderInfo orderInfo,List<OrderItem> orderItems,List<Long> cartIds);
	
	/**
	 * 支付返回
	 * @return orderInfo 订单信息
	 */
	public void payReturn(OrderInfo orderInfo,PayLogs payLogs);
	
	/**
	 * 余额支付返回;
	 */
	public void mypayReturn(OrderInfo orderInfo,PayLogs payLogs,BigDecimal balanceMoney);
	
	/**
     * 添加买家常用清单
     */
    public int insertBuyerCommon(Long orderId);
    
    /**
     * 判断买家订单金额是否达到指定金额并获取相应的优惠券
     */
    public Map<String, Object> costExceedFullMoney(List<OrderItem> orderItems,Long buyerId);
    
    /**
   	 * 线下付款;
   	 */
   	public int updatePayStatus(Long orderId,int payStatus);
   	
   	/**
   	 * 获取买家当天下单的有效订单数
   	 */
   	public int getCountByBuyerIdAndCreateTime(Long buyerId,Date createTime);
}