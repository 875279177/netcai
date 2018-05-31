package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 买家团购记录
 * @author administrator
 */
public class GroupBuyer implements Serializable {

	private static final long serialVersionUID = 8058734556895568614L;
    /**
     * 买家ID
     */
	private Long buyerId;
	/**
     * 团购ID
     */
	private Long groupId;
	/**
     * 团购明细ID
     */
	private Long itemId;
    /**
     * 订单ID
     */
	private Long orderId;
	/**
	 * 团购数量
	 */
	private BigDecimal gbNum;
	/**
	 * 团购价格
	 */
	private BigDecimal gbPrice;
	/**
	 * 团购金额
	 */
	private BigDecimal gbAmt;
	
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public BigDecimal getGbNum() {
		return gbNum;
	}
	public void setGbNum(BigDecimal gbNum) {
		this.gbNum = gbNum;
	}
	public BigDecimal getGbPrice() {
		return gbPrice;
	}
	public void setGbPrice(BigDecimal gbPrice) {
		this.gbPrice = gbPrice;
	}
	public BigDecimal getGbAmt() {
		return gbAmt;
	}
	public void setGbAmt(BigDecimal gbAmt) {
		this.gbAmt = gbAmt;
	}
	
}
