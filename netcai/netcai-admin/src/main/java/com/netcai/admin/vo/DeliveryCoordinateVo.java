package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 配送人员坐标信息
 * @author administrator
 */
public class DeliveryCoordinateVo implements Serializable {

	private static final long serialVersionUID = 1L;
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
