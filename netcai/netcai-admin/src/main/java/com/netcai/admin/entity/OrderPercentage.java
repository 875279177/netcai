package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 卖家抽点实体类
 * 
 * @author administrator
 *
 */
public class OrderPercentage implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	/**
	 * 关联订单明细id
	 */
	private Long orderItemId;

	/**
	 * 订单号
	 */
	private String orderNumber;

	/**
	 * 所属卖家ID
	 */
	private Long sellerId;

	/**
	 * 卖家店铺名称
	 */
	private String sellerName;

	/**
	 * 订单金额
	 */
	private BigDecimal originalAmount;

	/**
	 * 抽点比率
	 */
	private BigDecimal percentage;

	/**
	 * 抽点金额
	 */
	private BigDecimal percentageAmount;

	/**
	 * 订单实际金额(订单金额减去抽点金额)
	 */
	private BigDecimal realAmount;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public BigDecimal getPercentage() {
		return percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public BigDecimal getPercentageAmount() {
		return percentageAmount;
	}

	public void setPercentageAmount(BigDecimal percentageAmount) {
		this.percentageAmount = percentageAmount;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
