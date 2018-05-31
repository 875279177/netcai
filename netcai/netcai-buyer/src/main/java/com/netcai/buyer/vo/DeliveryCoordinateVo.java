package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 配送人员坐标信息
 * @author administrator
 */
public class DeliveryCoordinateVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 配送人员id
	 */
	private Long deliveryId;
	/**
	 * 配送人员名字
	 */
	private String deliveryName;
	/**
	 * 配送人员电话
	 */
	private String deliveryPhone;
	/**
	 * 经度
	 */
	private String lng;
	/**
	 * 维度
	 */
	private String lat;
	/**
	 * 坐标地址
	 */
	private String address;
	/**
	 * 定位时间
	 */
	private String createTime;
	
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getDeliveryPhone() {
		return deliveryPhone;
	}
	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
