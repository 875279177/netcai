package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告信息实体类
 * 
 * @author administrator
 *
 */
public class Banner implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 省id
	 */
	private Long provinceId;
	/**
	 * 市id
	 */
	private Long cityId;
	/**
	 * 区id
	 */
	private Long regionId;
	/**
	 * 省名称
	 */
	private String province;
	/**
	 * 市名称
	 */
	private String city;
	/**
	 * 区名称
	 */
	private String region;
	/**
	 * 主题
	 */
	private String title;
	/**
	 * 广告图片地址
	 */
	private String url;
	/**
	 * 顺序号
	 */
	private Integer bannerSeq;
	/**
	 * 状态(1在用 -1停用)
	 */
	private Integer status;
	/**
	 * 链接地址IDS(关联卖家)
	 */
	private String bannerIds;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getBannerSeq() {
		return bannerSeq;
	}

	public void setBannerSeq(Integer bannerSeq) {
		this.bannerSeq = bannerSeq;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBannerIds() {
		return bannerIds;
	}

	public void setBannerIds(String bannerIds) {
		this.bannerIds = bannerIds;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
