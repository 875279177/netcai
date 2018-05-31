package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动日志实体类
 * @author administrator
 */
public class ActivityLog implements Serializable {

	private static final long serialVersionUID = 1L;

	private int activityLogId;
	/**
	 * 活动ID
	 */
	private int activityId;
	/**
	 * 活动规则ID
	 */
	private int activityFormatId;
	/**
	 * 卖家ID
	 */
	private Long sellerId;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 订单明细ID
	 */
	private Long orderItemId;
	/**
	 * 商品规格ID
	 */
	private Long goodsFormatId;
	/**
	 * 订单金额
	 */
	private Double orderRmb;
	/**
	 * 优惠/满减金额
	 */
	private Double offerRmb;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public int getActivityLogId() {
		return activityLogId;
	}
	public void setActivityLogId(int activityLogId) {
		this.activityLogId = activityLogId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getActivityFormatId() {
		return activityFormatId;
	}
	public void setActivityFormatId(int activityFormatId) {
		this.activityFormatId = activityFormatId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getGoodsFormatId() {
		return goodsFormatId;
	}
	public void setGoodsFormatId(Long goodsFormatId) {
		this.goodsFormatId = goodsFormatId;
	}
	public Double getOrderRmb() {
		return orderRmb;
	}
	public void setOrderRmb(Double orderRmb) {
		this.orderRmb = orderRmb;
	}
	public Double getOfferRmb() {
		return offerRmb;
	}
	public void setOfferRmb(Double offerRmb) {
		this.offerRmb = offerRmb;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
