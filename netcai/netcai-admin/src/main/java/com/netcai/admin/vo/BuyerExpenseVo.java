package com.netcai.admin.vo;

import java.math.BigDecimal;

/**
 * 买家消费额
 * 
 * @author administrator
 *
 */
public class BuyerExpenseVo {

	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 买家商铺
	 */
	private String buyerName;
	/**
	 * 买家手机号
	 */
	private String buyerPhone;
	/**
	 * 买家今日消费
	 */
	private BigDecimal totayExpense;
	/**
	 * 买家昨日消费
	 */
	private BigDecimal yesterdayExpense;
	/**
	 * 买家三天前的消费
	 */
	private BigDecimal foreExpense;

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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

	public BigDecimal getTotayExpense() {
		return totayExpense;
	}

	public void setTotayExpense(BigDecimal totayExpense) {
		this.totayExpense = totayExpense;
	}

	public BigDecimal getYesterdayExpense() {
		return yesterdayExpense;
	}

	public void setYesterdayExpense(BigDecimal yesterdayExpense) {
		this.yesterdayExpense = yesterdayExpense;
	}

	public BigDecimal getForeExpense() {
		return foreExpense;
	}

	public void setForeExpense(BigDecimal foreExpense) {
		this.foreExpense = foreExpense;
	}

}
