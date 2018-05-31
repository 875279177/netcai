package com.netcai.buyer.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.OrderInfo;

public interface OrderInfoDao {

	public List<OrderInfo> getAllOrderInfo(@Param("buyerId") Long buyerId,@Param("orderStatus") int orderStatus);
	
	/**
	 * 取消单个订单,则把所有对应的订单项都取消
	 * @return
	 */
	public void cancelOrderInfo(@Param("orderId") Long orderId);
	
	/**
	 * 取消单个订单,则把所有对应的订单项都取消
	 * @return
	 */
	public void cancelAllOrderInfo(@Param("orderId") Long orderId);
	
	/**
	 * 更新订单的总金额
	 * @param orderId
	 */
	public void updateOrderInfoTotalAmount(@Param("orderId") Long orderId,@Param("totalAmount") BigDecimal totalAmount);
	
	/**
	 * 保存订单信息
	 * @param orderInfo 订单信息
	 * @return
	 */
	public Long addOrderInfo(OrderInfo orderInfo);

	/**
	 * 根据订单编号获取订单信息
	 * @param orderId 订单编号
	 * @return
	 */
	public OrderInfo getOrderInfoByOrderId(Long orderId);
	
	/**
	 * 根据订单号获取订单基本信息
	 * @param orderNumber 订单号
	 * @return
	 */
	public OrderInfo getOrderInfoByOrderNumber(String orderNumber);
	
	/**
	 * 付款返回
	 * @param orderInfo 订单信息表
	 * @return
	 */
	public int payReturn(OrderInfo orderInfo);
	
	/**
     * 添加买家常用清单
     */
    public int insertBuyerCommon(@Param("orderId") Long orderId);
    
    /**
   	 * 线下付款;
   	 */
   	public int updatePayStatus(@Param("orderId")Long orderId,@Param("payStatus")int payStatus);
   	
   	/**
   	 * 获取买家当天下单的有效订单数
   	 */
   	public int getCountByBuyerIdAndCreateTime(@Param("buyerId")Long buyerId,@Param("createTime")Date createTime);
}