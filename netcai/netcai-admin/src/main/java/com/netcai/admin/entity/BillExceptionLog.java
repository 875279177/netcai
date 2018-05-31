package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 卖家账单异常日志
 * 
 * @author administrator
 *
 */
public class BillExceptionLog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 卖家店铺名称
	 */
	private String sellerName;
	/**
	 * 卖家余额
	 */
	private BigDecimal sellerBalance;
	/**
	 * 可提现余额
	 */
	private BigDecimal availableAmount;
	/**
	 * 账单总金额
	 */
	private BigDecimal billAmount;
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

	public BigDecimal getSellerBalance() {
		return sellerBalance;
	}

	public void setSellerBalance(BigDecimal sellerBalance) {
		this.sellerBalance = sellerBalance;
	}

	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
