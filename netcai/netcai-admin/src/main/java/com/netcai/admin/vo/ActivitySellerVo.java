package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 活动商家显示类
 * @author administrator
 */
public class ActivitySellerVo  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int activitySellerId;
	/**
	 * 卖家ID
	 */
	private Long sellerId;
	/**
	 * 商家名称
	 */
	private String sellerName;
	/**
	 * 商家手机
	 */
	private String sellerTel;
	
	public int getActivitySellerId() {
		return activitySellerId;
	}
	public void setActivitySellerId(int activitySellerId) {
		this.activitySellerId = activitySellerId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
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
}
