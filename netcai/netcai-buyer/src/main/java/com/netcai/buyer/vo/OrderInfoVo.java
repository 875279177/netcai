package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单VO
 * @author administrator
 */
public class OrderInfoVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单主表id,order_info表的order_id
	 */
	private Long orderId;
	/**
	 * 订单类型(0普通订单 1团购订单)
	 */
	private Short orderType;
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 交易状态。0为进行中, 1,已完成，2为取消交易
	 */
	private int tradeStatus;
	/**
	 * 支付状态；1，未付款；2，已付款
	 */
	private int payStatus;
	/**
	 * 收货人的最佳送货时间
	 */
	private String bestTime;
	/**
	 * 商品最终金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 订单创建时间
	 */
	private String createTime;
	/**
	 * 订单支付时间
	 */
	private String payTime;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Short getOrderType() {
		return orderType;
	}

	public void setOrderType(Short orderType) {
		this.orderType = orderType;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public int getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(int tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}


	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getBestTime() {
		return bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}
	
}