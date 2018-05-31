package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PresentOrderVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 麦加餐厅名称
	 */
	private String buyerName;
	/**
	 * 卖家手机号
	 */
	private String buyerPhone;
	/**
	 * 下单时间
	 */
	private Date createTime;
	/**
	 * 送达时间
	 */
	private Date bestTime;
	/**
	 * 订单金额
	 */
	private BigDecimal orderAmount;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

}
