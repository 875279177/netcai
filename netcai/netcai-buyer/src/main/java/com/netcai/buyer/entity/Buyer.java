package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 * 买家信息
 * @author mengj
 */
public class Buyer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 销售人员id
	 */
	private Long saleId;
	/**
	 * 关联user表中的id
	 */
	private Long buyerId;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	/**
	 * 餐馆地址
	 */
	private String buyerAddress;
	/**
	 * 经度
	 */
	private String lng;
	/**
	 * 纬度
	 */
	private String lat;
	/**
	 * 所属省
	 */
	private Long provinceId;
	/**
	 * 所属市
	 */
	private Long cityId;
	/**
	 * 所属区
	 */
	private Long regionId;
	/**
	 * 老板名称(买家姓名)
	 */
	private String bossName;
	/**
	 * 老板电话号码
	 */
	private String bossTel;
	/**
	 * 账号余额
	 */
	private BigDecimal balanceMoney;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * Users对象
	 */
	private Users users;
	
	/**
	 * 买家级别
	 */
	private int buyerLevel;
	
	/**
	 * 买家类型
	 */
	private int buyerType;
	
	
	public Buyer() {
		super();
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

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

	public int getBuyerLevel() {
		return buyerLevel;
	}

	public void setBuyerLevel(int buyerLevel) {
		this.buyerLevel = buyerLevel;
	}

	public int getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(int buyerType) {
		this.buyerType = buyerType;
	}
}