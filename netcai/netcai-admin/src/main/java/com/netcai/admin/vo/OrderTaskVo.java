package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderTaskVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2227814038095136499L;

	/**
	 * 订单主表id,order_info表的order_id
	 */
	private Long orderId;
	
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	
	/**
	 * 收货人的最佳送货时间
	 */
	private Date bestTime;
	
	/**
	 * 应付款金额
	 */
	private BigDecimal orderAmount;
	
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	
	/**
	 * 餐馆地址
	 */
	private String buyerAddress;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getBestTime() {
		return bestTime;
	}

	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	
}
