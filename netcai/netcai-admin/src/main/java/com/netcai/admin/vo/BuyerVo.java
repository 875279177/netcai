package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商家信息
 * 
 * @author mengj
 *
 */
public class BuyerVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 销售人员id
	 */
	private Long saleId;
	/**
	 * 销售人员姓名
	 */
	private String salesName;
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
	 * 省名称
	 */
	private String provinceName;
	/**
	 * 所属市
	 */
	private Long cityId;
	/**
	 * 市名称
	 */
	private String cityName;
	/**
	 * 所属区
	 */
	private Long regionId;
	/**
	 * 区名称
	 */
	private String regionName;
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
	 * 客户级别，1为A类客户,2为B类客户,3为C类客户
	 */
	private Integer buyerLevel;
	/**
	 * 餐馆的类型，1为火锅店，2为小餐馆，3为中餐馆，4,为烧烤
	 */
	private Integer buyerType;
	/**
	 * 买家logo图片
	 */
	private String buyerLogo;
	/**
	 * 方便配送人员容易找到位置，所拍摄的多张图片
	 */
	private String buyerImages;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 早上开门时间
	 */
	private String openTime;
	/**
	 * 晚上关门时间
	 */
	private String endTime;
	/**
	 * 最晚送达时间
	 */
	private String deliveryTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 配送区域id
	 */
	private Long deliveryAreaId;
	/**
	 * 配送区域名称
	 */
	private String deliveryAreaName;

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
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

	public Integer getBuyerLevel() {
		return buyerLevel;
	}

	public void setBuyerLevel(Integer buyerLevel) {
		this.buyerLevel = buyerLevel;
	}

	public Integer getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(Integer buyerType) {
		this.buyerType = buyerType;
	}

	public String getBuyerLogo() {
		return buyerLogo;
	}

	public void setBuyerLogo(String buyerLogo) {
		this.buyerLogo = buyerLogo;
	}

	public String getBuyerImages() {
		return buyerImages;
	}

	public void setBuyerImages(String buyerImages) {
		this.buyerImages = buyerImages;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getDeliveryAreaId() {
		return deliveryAreaId;
	}

	public void setDeliveryAreaId(Long deliveryAreaId) {
		this.deliveryAreaId = deliveryAreaId;
	}

	public String getDeliveryAreaName() {
		return deliveryAreaName;
	}

	public void setDeliveryAreaName(String deliveryAreaName) {
		this.deliveryAreaName = deliveryAreaName;
	}

	/**
	 * 配送人员;
	 */
	private String deliveryName;
	
	/**
	 * 订单总金额;
	 */
	private Long deliveryId;
	
	/**
	 * 订单总金额;
	 */
	private BigDecimal orderCount;

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public BigDecimal getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(BigDecimal orderCount) {
		this.orderCount = orderCount;
	}

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
}
