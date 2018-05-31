package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动商品实体类
 * @author administrator
 */
public class ActivityGoods implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int activityGoodsId;
	/**
	 * 活动ID
	 */
	private int activityId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品规格ID
	 */
	private Long goodsFormartId;
	/**
	 * 活动价
	 */
	private Double activityPrice;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public int getActivityGoodsId() {
		return activityGoodsId;
	}
	public void setActivityGoodsId(int activityGoodsId) {
		this.activityGoodsId = activityGoodsId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getGoodsFormartId() {
		return goodsFormartId;
	}
	public void setGoodsFormartId(Long goodsFormartId) {
		this.goodsFormartId = goodsFormartId;
	}
	public Double getActivityPrice() {
		return activityPrice;
	}
	public void setActivityPrice(Double activityPrice) {
		this.activityPrice = activityPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
