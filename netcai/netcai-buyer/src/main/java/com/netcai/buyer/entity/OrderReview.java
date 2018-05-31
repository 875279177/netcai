package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单评论实体类
 * @author administrator
 */
public class OrderReview implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long reviewId;
	/**
	 * 订单明细ID
	 */
	private Long orderItemId;
	/**
	 * 卖家ID
	 */
	private Long reviewSellerId;
	/**
	 * 商品ID
	 */
	private Long reviewGoodsId;
	/**
	 * 规格ID
	 */
	private Long formatId;
	/**
	 * 评论等级(1差评 2到3 中评 4到5好评)
	 */
	private Short reviewGrade;
	/**
	 * 评论内容
	 */
	private String reviewDesc;
	/**
	 * 评论人ID
	 */
	private Long reviewUserId;
	/**
	 * 评论内容
	 */
	private Date reviewTime;
	/**
	 * 评论状态1显示 -1不显示
	 */
	private Short reviewStatus;
	
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getReviewSellerId() {
		return reviewSellerId;
	}
	public void setReviewSellerId(Long reviewSellerId) {
		this.reviewSellerId = reviewSellerId;
	}
	public Long getReviewGoodsId() {
		return reviewGoodsId;
	}
	public void setReviewGoodsId(Long reviewGoodsId) {
		this.reviewGoodsId = reviewGoodsId;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public Short getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(Short reviewGrade) {
		this.reviewGrade = reviewGrade;
	}
	public String getReviewDesc() {
		return reviewDesc;
	}
	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}
	public Long getReviewUserId() {
		return reviewUserId;
	}
	public void setReviewUserId(Long reviewUserId) {
		this.reviewUserId = reviewUserId;
	}
	public Date getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	public Short getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Short reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
}
