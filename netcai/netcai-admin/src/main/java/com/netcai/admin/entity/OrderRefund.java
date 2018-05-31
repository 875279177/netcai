package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderRefund implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 交易金额
	 */
	private BigDecimal sellerMoney;
	/**
	 * 交易金额
	 */
	private BigDecimal buyerMoney;
	/**
	 * 退换原因id(多个拼接)
	 */
	private String refundCauseIds;
	/**
	 * 退换原因
	 */
	private String reason;
	/**
	 * 备注说明
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 1为显示;0为不显示
	 */
	private int isShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public BigDecimal getSellerMoney() {
		return sellerMoney;
	}

	public void setSellerMoney(BigDecimal sellerMoney) {
		this.sellerMoney = sellerMoney;
	}

	public BigDecimal getBuyerMoney() {
		return buyerMoney;
	}

	public void setBuyerMoney(BigDecimal buyerMoney) {
		this.buyerMoney = buyerMoney;
	}

	public String getRefundCauseIds() {
		return refundCauseIds;
	}

	public void setRefundCauseIds(String refundCauseIds) {
		this.refundCauseIds = refundCauseIds;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

}
