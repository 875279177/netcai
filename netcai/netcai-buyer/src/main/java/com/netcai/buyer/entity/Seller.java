package com.netcai.buyer.entity;

import java.io.Serializable;

/**
 * 用户基本信息
 * @author administrator
 *
 */
public class Seller implements Serializable{
	
	
	private static final long serialVersionUID = -2869034349247740496L;
	
	/**
	 * 来源于users的ID
	 */
	private Long sellerId;
	/**
	 * 账号,目前用手机号码作为账号
	 */
	private String sellerAccount;

	/**
	 * 店铺名称
	 */
	private String sellerName;
	
	/**
	 * 店铺别名,可以理解为简称
	 */
	private String sellerAlias;
	
	/**
	 * 店铺logo
	 */
	private String sellerLogo;
	
	/**
	 * 营业执照
	 */
	private String sellerLicence;
	
	/**
	 * 店铺评级,默认为0
	 */
	private int sellerRank;
	
	/*
	 * 店铺评分
	 */
	private Double sellerGrade;
	
	/**
	 * 店铺地址
	 */
	private String sellerAddress;
	
	/**
	 * 关键字
	 */
	private String sellerKeyword;
	
	/**
	 * 余额
	 */
	private int balanceMoney;
	
	/**
	 * 账单金额,用于提现的计算
	 */
	private int billMoney;
	
	/**
	 * 所属市场
	 */
	private Long marketId;
	
	/**
	 * 所属市场
	 */
	private Market market;
	
	/**
	 * 个人信息
	 */
	private Users users;
	
	/**
	 * 备注
	 */
	private String remark;

	
	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerAccount() {
		return sellerAccount;
	}

	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerAlias() {
		return sellerAlias;
	}

	public void setSellerAlias(String sellerAlias) {
		this.sellerAlias = sellerAlias;
	}

	public String getSellerLogo() {
		return sellerLogo;
	}

	public void setSellerLogo(String sellerLogo) {
		this.sellerLogo = sellerLogo;
	}

	public int getSellerRank() {
		return sellerRank;
	}

	public void setSellerRank(int sellerRank) {
		this.sellerRank = sellerRank;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public String getSellerKeyword() {
		return sellerKeyword;
	}

	public void setSellerKeyword(String sellerKeyword) {
		this.sellerKeyword = sellerKeyword;
	}

	public int getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(int balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public int getBillMoney() {
		return billMoney;
	}

	public void setBillMoney(int billMoney) {
		this.billMoney = billMoney;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Market getMarket() {
		return market;
	}

	public void setMarket(Market market) {
		this.market = market;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Seller() {
		super();
	}

	public Double getSellerGrade() {
		return sellerGrade;
	}

	public void setSellerGrade(Double sellerGrade) {
		this.sellerGrade = sellerGrade;
	}

	public String getSellerLicence() {
		return sellerLicence;
	}

	public void setSellerLicence(String sellerLicence) {
		this.sellerLicence = sellerLicence;
	}
}