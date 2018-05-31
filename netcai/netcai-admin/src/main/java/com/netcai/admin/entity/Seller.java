package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;

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
	 * 店铺评级,默认为0
	 */
	private Integer sellerRank;
	
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
	 * 手机号码
	 */
	private String sellerTel;
	
	/**
	 * 余额
	 */
	private BigDecimal balanceMoney;
	
	/**
	 * 账单金额,用于提现的计算
	 */
	private BigDecimal billMoney;
	/**
	 * 营业执照
	 */
	private String sellerLicence;
	
	/**
	 * 个人信息
	 */
	private Users users;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 区域
	 */
	private String regions;
	
	/**
	 * 是否选中
	 */
	private int select;
	
	/**
	 * 卖家类型
	 */
	private int sellerType;
	
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

	public String getSellerKeyword() {
		return sellerKeyword;
	}

	public void setSellerKeyword(String sellerKeyword) {
		this.sellerKeyword = sellerKeyword;
	}

	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public BigDecimal getBillMoney() {
		return billMoney;
	}

	public void setBillMoney(BigDecimal billMoney) {
		this.billMoney = billMoney;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getSellerTel() {
		return sellerTel;
	}

	public void setSellerTel(String sellerTel) {
		this.sellerTel = sellerTel;
	}

	public String getSellerLicence() {
		return sellerLicence;
	}

	public void setSellerLicence(String sellerLicence) {
		this.sellerLicence = sellerLicence;
	}

	public Double getSellerGrade() {
		return sellerGrade;
	}

	public void setSellerGrade(Double sellerGrade) {
		this.sellerGrade = sellerGrade;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

/*****************************************************query**********************************************************************/
	
	/**
	 * 所属区域Id;
	 */
	private Long areaId;

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	
	/**
	 * 所属区域;
	 */
	private String areaName;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getRegions() {
		return regions;
	}

	public void setRegions(String regions) {
		this.regions = regions;
	}

	public int getSellerType() {
		return sellerType;
	}

	public void setSellerType(int sellerType) {
		this.sellerType = sellerType;
	}
}
