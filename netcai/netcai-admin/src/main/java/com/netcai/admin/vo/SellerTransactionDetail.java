package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SellerTransactionDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商品品牌
	 */
	private String goodsBrand;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品标签
	 */
	private String goodsLabel;
	/**
	 * 单位
	 */
	private String unitName;
	/**
	 * 商品数量
	 */
	private BigDecimal goodsNumber;
	/**
	 * 商品总金额
	 */
	private BigDecimal goodsAmount;
	/**
	 * 商品单价
	 */
	private BigDecimal goodsPrice;
	/**
	 * 抽点的商品总金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 商品抽点率
	 */
	private BigDecimal orderPercentage;
	/**
	 * 抽点金额
	 */
	private BigDecimal percentageAmount;
	/**
	 * 卖家是收益
	 */
	private BigDecimal realityMoney;

	public String getGoodsBrand() {
		return goodsBrand;
	}

	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsLabel() {
		return goodsLabel;
	}

	public void setGoodsLabel(String goodsLabel) {
		this.goodsLabel = goodsLabel;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public BigDecimal getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(BigDecimal goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getOrderPercentage() {
		return orderPercentage;
	}

	public void setOrderPercentage(BigDecimal orderPercentage) {
		this.orderPercentage = orderPercentage;
	}

	public BigDecimal getPercentageAmount() {
		return percentageAmount;
	}

	public void setPercentageAmount(BigDecimal percentageAmount) {
		this.percentageAmount = percentageAmount;
	}

	public BigDecimal getRealityMoney() {
		return realityMoney;
	}

	public void setRealityMoney(BigDecimal realityMoney) {
		this.realityMoney = realityMoney;
	}

}
