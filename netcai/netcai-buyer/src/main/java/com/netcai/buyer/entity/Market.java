package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 农贸市场信息
 * @author mengjie
 *
 */
public class Market implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 市场名称
	 */
	private String marketName;
	/**
	 * 市场具体地址
	 */
	private String marketAddress;
	/**
	 * 所属省份id
	 */
	private Long provinceId;
	/**
	 * 所属省份名称
	 */
	private String provinceName;
	/**
	 * 所属城市id
	 */
	private Long cityId;
	/**
	 * 所属城市名称
	 */
	private String cityName;
	/**
	 * 所属区域id
	 */
	private Long regionId;
	/**
	 * 所属区域名称
	 */
	private String regionName;
	/**
	 * 区域的经度
	 */
	private String lng;
	/**
	 * 区域的纬度
	 */
	private String lat;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Market() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketAddress() {
		return marketAddress;
	}

	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}

	public Long getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Long provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
