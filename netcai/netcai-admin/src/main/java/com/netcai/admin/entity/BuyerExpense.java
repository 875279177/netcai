package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 买家消费信息
 * @author administrator
 *
 */
public class BuyerExpense implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long BuyerId;
	/**
	 * 买家商铺
	 */
	private String buyerName;
	/**
	 * 买家手机号
	 */
	private String buyerPhone;
	/**
	 * 买家消费金额
	 */
	private BigDecimal expense;
	
	public Long getBuyerId() {
		return BuyerId;
	}
	public void setBuyerId(Long buyerId) {
		BuyerId = buyerId;
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
	public BigDecimal getExpense() {
		return expense;
	}
	public void setExpense(BigDecimal expense) {
		this.expense = expense;
	}
	
	
	
}
