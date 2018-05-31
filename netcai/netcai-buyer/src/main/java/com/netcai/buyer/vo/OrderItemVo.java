package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.netcai.buyer.entity.OrderItem;
/**
 * 接收传来的购物车信息，生成订单;
 * @author administrator
 *
 */
public class OrderItemVo implements Serializable{

	private static final long serialVersionUID = 3416003870467304498L;

	/**
	 * 新增订单项
	 */
	private List<OrderItem> orderItems;
	/**
	 * 生成订单后	需要删除的购物车项;
	 */
	private List<Long> cartIds;
	/**
	 * 买家要求的送到时间;
	 */
	private Date bestTime;
	
	/**
	 * 传过来的时间;
	 */
	private String time;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public List<Long> getCartIds() {
		return cartIds;
	}

	public void setCartIds(List<Long> cartIds) {
		this.cartIds = cartIds;
	}

	public Date getBestTime() {
		return bestTime;
	}

	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
