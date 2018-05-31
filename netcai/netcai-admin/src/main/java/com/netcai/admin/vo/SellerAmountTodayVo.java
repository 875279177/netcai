package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 卖家今日金额统计
 * 
 * @author administrator
 *
 */
public class SellerAmountTodayVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 卖家店铺
	 */
	private String sellerName;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 卖家手机号
	 */
	private String account;
	/**
	 * 订单数量
	 */
	private Integer orderNum;
	/**
	 * 今日收益
	 */
	private BigDecimal totayIncome;
	/**
	 * 卖家余额
	 */
	private BigDecimal balanceMoney;
	/**
	 * 可提现金额
	 */
	private BigDecimal withdrawalAmount;

	/**
	 * 可选日期时间
	 */
	private String time;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public BigDecimal getTotayIncome() {
		return totayIncome;
	}

	public void setTotayIncome(BigDecimal totayIncome) {
		this.totayIncome = totayIncome;
	}

	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public BigDecimal getWithdrawalAmount() {
		return withdrawalAmount;
	}

	public void setWithdrawalAmount(BigDecimal withdrawalAmount) {
		this.withdrawalAmount = withdrawalAmount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * 已提现金额
	 */
	private BigDecimal withdrawaledAmount;

	public BigDecimal getWithdrawaledAmount() {
		return withdrawaledAmount;
	}
	public void setWithdrawaledAmount(BigDecimal withdrawaledAmount) {
		this.withdrawaledAmount = withdrawaledAmount;
	}
	/**
	 * 已结算
	 */
	private BigDecimal alreadySettled;
	/**
	 * 待结算
	 */
	private BigDecimal waitSettled;

	public BigDecimal getAlreadySettled() {
		return alreadySettled;
	}

	public void setAlreadySettled(BigDecimal alreadySettled) {
		this.alreadySettled = alreadySettled;
	}

	public BigDecimal getWaitSettled() {
		return waitSettled;
	}

	public void setWaitSettled(BigDecimal waitSettled) {
		this.waitSettled = waitSettled;
	}
	
	/**所属区
     */
    private Long areaId;
    
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**所属区
     */
    private String areaName;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}
