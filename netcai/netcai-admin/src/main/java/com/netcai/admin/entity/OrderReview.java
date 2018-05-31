package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 订单评论表
 * @author administrator
 *
 */
public class OrderReview implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8058734556895568614L;

	private Long id;
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
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 评论等级(1差评 2到3 中评 4到5好评)
	 */
	private int reviewGrade;
	/**
	 * 评论内容
	 */
	private String reviewDesc;
	/**
	 * 评论人
	 */
	private Long reviewUserId;
	/**
	 * 评论时间
	 */
	private Date reviewTime;
	/**
	 * 状态（1显示 -1不显示）
	 */
	private Long reviewStatus;
	/**
	 * 订单明细
	 */
	private OrderItem orderItem;
	/**
	 * 卖家
	 */
	private Seller seller;
	/**
	 * 商品
	 */
	private Goods goods;
	/**
	 * 商品规格
	 */
	private GoodsFormat goodsformat;
	/**
	 * 买家  评论人
	 */
	private Buyer buyer;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getReviewGrade() {
		return reviewGrade;
	}
	public void setReviewGrade(int reviewGrade) {
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
	public Long getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(Long reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public OrderItem getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public GoodsFormat getGoodsformat() {
		return goodsformat;
	}
	public void setGoodsformat(GoodsFormat goodsformat) {
		this.goodsformat = goodsformat;
	}
	public Buyer getBuyer() {
		return buyer;
	}
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
}
