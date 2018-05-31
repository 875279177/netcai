package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.vo.GoodsCartVo;

public interface OrderItemService {

	/**
	 * 订单项
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getAllOrderItemByOrderId(Long orderId);
	
	/**
	 * 单个订单项
	 * @param orderId
	 * @return
	 */
	public OrderItem getOrderItemByItemId(Long itemId);
	
	/**
	 * 订单项
	 * @param orderId
	 * @return
	 */
	public List<GoodsCartVo> getOrderItemByOrderId(Long orderId);
	
	
	/**
	 * 取消订单
	 * @param id
	 */
	public void cacelOrderItemById(Long itemId);
	
	
	/**
	 * 删除订单
	 * @param id
	 */
	public void deleteOrderItemById(Long buyerId,Long itemId);
	
}