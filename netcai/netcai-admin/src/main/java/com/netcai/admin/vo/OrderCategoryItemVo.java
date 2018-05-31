package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderCategoryItemVo implements Serializable {

	private static final long serialVersionUID = 1L;

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
