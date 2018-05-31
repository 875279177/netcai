package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 卖家vo类(选择卖家时使用)
 * @author administrator
 */
public class SellerVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 来源于users的ID
	 */
	private Long sellerId;
	/**
	 * 活动ID
	 */
	private Integer activityId;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 手机号
	 */
	private String sellerTel;
	/**
	 * 所属区域
	 */
	private Long areaId;
	
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerTel() {
		return sellerTel;
	}
	public void setSellerTel(String sellerTel) {
		this.sellerTel = sellerTel;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	
}
