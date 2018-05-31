package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 精选TOP10 商家
 * @author administrator
 */
public class SellerVo implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
	 * 店铺评级,默认为0
	 */
	private int sellerRank;
	
	/**
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
	 * 备注
	 */
	private String remark;

	/**
	 * 所属市场
	 */
	private String marketName;

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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public Double getSellerGrade() {
		return sellerGrade;
	}

	public void setSellerGrade(Double sellerGrade) {
		this.sellerGrade = sellerGrade;
	}
}