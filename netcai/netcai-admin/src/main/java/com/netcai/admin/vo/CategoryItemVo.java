package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class CategoryItemVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sendDate;
	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 买家名称
	 */
	private String buyerName;
	/**
	 * 买家数量
	 */
    private Integer buyerNum;
	/**
	 * 明细金额
	 */
	private BigDecimal goodsAmount;
	/**
	 * 一级分类ID
	 */
	private Long oneCategoryId;
	/**
	 * 二级分类ID
	 */
	private Long twoCategoryId;
	
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public Integer getBuyerNum() {
		return buyerNum;
	}
	public void setBuyerNum(Integer buyerNum) {
		this.buyerNum = buyerNum;
	}
	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public Long getOneCategoryId() {
		return oneCategoryId;
	}
	public void setOneCategoryId(Long oneCategoryId) {
		this.oneCategoryId = oneCategoryId;
	}
	public Long getTwoCategoryId() {
		return twoCategoryId;
	}
	public void setTwoCategoryId(Long twoCategoryId) {
		this.twoCategoryId = twoCategoryId;
	}
}
