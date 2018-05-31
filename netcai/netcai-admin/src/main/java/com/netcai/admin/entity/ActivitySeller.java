package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动卖家实体类
 * @author administrator
 */
public class ActivitySeller implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int activitySellerId;
	/**
	 * 活动ID
	 */
	private int activityId;
	/**
	 * 卖家ID
	 */
	private Long sellerId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public int getActivitySellerId() {
		return activitySellerId;
	}
	public void setActivitySellerId(int activitySellerId) {
		this.activitySellerId = activitySellerId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
