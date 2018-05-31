package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单项交易类型
 * @author administrator
 */
public class OrderItemLogs implements Serializable {

	private static final long serialVersionUID = 569466381333606429L;

	private Long id;
	/**
	 * 订单明细Id
	 */
	private Long itemId;
	/**
	 * 买家用户ID
	 */
	private Long buyerId;
	/**
	 * 卖家用户ID
	 */
	private Long seller;
	/**
	 * 交易类型,1,卖家给买家钱，2,买家给卖家钱。
	 */
	private int tradeType;
	/**
	 * 交易金额
	 */
	private BigDecimal tradeMoney;
	/**
	 * 交易余额
	 */
	private BigDecimal balance;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date cteateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSeller() {
		return seller;
	}

	public void setSeller(Long seller) {
		this.seller = seller;
	}

	public int getTradeType() {
		return tradeType;
	}

	public void setTradeType(int tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCteateTime() {
		return cteateTime;
	}

	public void setCteateTime(Date cteateTime) {
		this.cteateTime = cteateTime;
	}
}