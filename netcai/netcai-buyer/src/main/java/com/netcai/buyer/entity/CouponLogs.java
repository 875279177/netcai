package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券消费记录表
 */
public class CouponLogs implements Serializable {

	private static final long serialVersionUID = 787725471111513239L;

	private Long id;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 优惠券编号
	 */
	private Long couponReceiveId;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 原订单金额
	 */
	private BigDecimal originalOrderAmount;
	/**
	 * 优惠券的金额
	 */
	private BigDecimal couponAmount;
	/**
	 * 抵扣优惠券之后的订单金额
	 */
	private BigDecimal finalOrderAmount;
	/**
	 * 领取时间
	 */
	private Date createTime;

	/**
	 * 日志状态 :默认为0，支付回调成功后为1
	 */
	private Integer status;

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

	public Long getCouponReceiveId() {
		return couponReceiveId;
	}

	public void setCouponReceiveId(Long couponReceiveId) {
		this.couponReceiveId = couponReceiveId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getOriginalOrderAmount() {
		return originalOrderAmount;
	}

	public void setOriginalOrderAmount(BigDecimal originalOrderAmount) {
		this.originalOrderAmount = originalOrderAmount;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}

	public BigDecimal getFinalOrderAmount() {
		return finalOrderAmount;
	}

	public void setFinalOrderAmount(BigDecimal finalOrderAmount) {
		this.finalOrderAmount = finalOrderAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}