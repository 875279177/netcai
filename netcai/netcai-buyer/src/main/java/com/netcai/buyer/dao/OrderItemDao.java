package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.vo.GoodsCartVo;

public interface OrderItemDao {

	/**
	 * 取消全部订单
	 * @param id
	 */
	public void cancelOrderItem(Long orderId);
	
	/**
	 * 取消全部订单
	 * @param id
	 */
	public void cancelAllOrderItem(Long orderId);
	
	/**	
	 * 取消全部订单
	 * @param id
	 */
	public int cancelOrderItemById(Long itemId);

	/**
	 * 根据订单状态更新
	 * @param orderNumber
	 */
	public void updateOrderItemByOrderNumber(String orderNumber);
	
	/**
	 * 获取所有的订单项
	 * @param orderId
	 * @return
	 */
	public List<GoodsCartVo> getOrderItemByOrderId(Long orderId);

	/**
	 * 获取所有的订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getAllOrderItemByOrderId(Long orderId);
	
	/**
	 * 获取单个的订单项对象
	 * @param itemId
	 * @return
	 */
	public OrderItem getOrderItemByItemId(Long itemId);
	
	/**
	 * 批量新增订单项;
	 * @param OrderItem
	 */
	public int insertOrderItemByBatch(@Param("list")List<OrderItem> list);
	
	/**
	 * 批量新增订单项;
	 * @param OrderItem
	 */
	public int insertOrderItem(OrderInfo orderInfo);
}
