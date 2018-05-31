package com.netcai.buyer.vo;

import java.util.List;

import com.netcai.buyer.entity.OrderInfo;

public class OrderInfoDetailVo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6431573871096054711L;

	private List<OrderItemDetailVo> orderItemDetailVo;
	
	private OrderInfo orderInfo;

	public List<OrderItemDetailVo> getOrderItemDetailVo() {
		return orderItemDetailVo;
	}

	public void setOrderItemDetailVo(List<OrderItemDetailVo> orderItemDetailVo) {
		this.orderItemDetailVo = orderItemDetailVo;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	
}
