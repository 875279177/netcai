package com.netcai.buyer.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 买家VO
 * 
 * @author administrator
 */
public class BuyerVo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String account;

	private String password;

	private String trueName;

	private int status;

	private Date createTime;

	private int type;

	private String buyerName;

	private String buyerAddress;

	private String lng;

	private String lat;

	private Long provinceId;

	private Long cityId;

	private Long regionId;

	private String regionName;

	private String bossName;

	private String bossTel;

	private BigDecimal balanceMoney;

	private int buyerType;

	private String remark;

	// 区域起送价
	private BigDecimal sendingAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getBossTel() {
		return bossTel;
	}

	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}

	public BigDecimal getBalanceMoney() {
		return balanceMoney;
	}

	public void setBalanceMoney(BigDecimal balanceMoney) {
		this.balanceMoney = balanceMoney;
	}

	public int getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(int buyerType) {
		this.buyerType = buyerType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public BigDecimal getSendingAmount() {
		return sendingAmount;
	}

	public void setSendingAmount(BigDecimal sendingAmount) {
		this.sendingAmount = sendingAmount;
	}

}