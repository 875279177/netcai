package com.netcai.admin.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 卖家配送费实体
 * @author administrator
 *
 */
public class SellerOrderDelivery {

	private Long id;
	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 配送费
	 */
	private BigDecimal deliveryMoney;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getDeliveryMoney() {
		return deliveryMoney;
	}

	public void setDeliveryMoney(BigDecimal deliveryMoney) {
		this.deliveryMoney = deliveryMoney;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
