package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单评论图片实体类
 * @author administrator
 */
public class ReviewPicture implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long rpId;
	/**
	 * 评论ID
	 */
	private Long reviewId;
	/**
	 * 图片地址
	 */
	private String reviewPicUrl;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getRpId() {
		return rpId;
	}
	public void setRpId(Long rpId) {
		this.rpId = rpId;
	}
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewPicUrl() {
		return reviewPicUrl;
	}
	public void setReviewPicUrl(String reviewPicUrl) {
		this.reviewPicUrl = reviewPicUrl;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
