package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 卖家当天订单总额;
 */
public class SellerOrderVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 今天销售额;
	 */
	private BigDecimal amount;
	/**
	 * 来源于users的ID
	 */
	private Long sellerId;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 账号,目前用手机号码作为账号
	 */
	private String sellerAccount;
	/**
	 * 店铺评分
	 */
	private Double sellerGrade;
	/**
	 * 店铺评级,默认为0
	 */
	private Integer sellerRank;
	/**
	 * 店铺地址
	 */
	private String sellerAddress;
	/**
	 * 余额
	 */
	private BigDecimal balanceMoney;
	/**
	 * 所属市场
	 */
	private String areaName;
	/**
	 * 所属市场Id
	 */
	private Long areaId;
	
	
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
	public String getSellerAccount() {
		return sellerAccount;
	}
	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}
	public Double getSellerGrade() {
		return sellerGrade;
	}
	public void setSellerGrade(Double sellerGrade) {
		this.sellerGrade = sellerGrade;
	}
	public Integer getSellerRank() {
		return sellerRank;
	}
	public void setSellerRank(Integer sellerRank) {
		this.sellerRank = sellerRank;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}
	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * 查询时间;
	 */
	private String createTime;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
