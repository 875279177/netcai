package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券领取记录表
 */
public class CouponReceive implements Serializable {

	private static final long serialVersionUID = 1144560831602601473L;

	private Long id;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 优惠券编号
	 */
	private Long couponId;
	/**
	 * 优惠券金额
	 */
	private BigDecimal couponMoney;
	/**
	 * 领取时间
	 */
	private Date createTime;
	/**
	 * 满减金额
	 */
	private BigDecimal fullMoney;
	/**
	 * 状态，1为已使用，0为已领取未使用
	 */
	private Integer status;
	/**
	 * 所属类型,1为满减
	 */
	private Integer type;
	/**
	 * 优惠券开始时间
	 */
	private Date startTime;
	/**
	 * 优惠券结束时间
	 */
	private Date endTime;
	/**
	 * 优惠券的说明
	 */
	private String remarks;

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

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public BigDecimal getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(BigDecimal couponMoney) {
		this.couponMoney = couponMoney;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getFullMoney() {
		return fullMoney;
	}

	public void setFullMoney(BigDecimal fullMoney) {
		this.fullMoney = fullMoney;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}