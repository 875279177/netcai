package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class PresentOrderDetailVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 麦加餐厅名称
	 */
	private String buyerName;
	/**
	 * 卖家手机号
	 */
	private String buyerPhone;
	/**
	 * 卖家餐厅地址
	 */
	private String address;
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
	 * 商品单价
	 */
	private BigDecimal goodsPrice;

	/**
	 * 订单金额
	 */
	private BigDecimal orderAmount;

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerPhone() {
		return buyerPhone;
	}

	public void setBuyerPhone(String buyerPhone) {
		this.buyerPhone = buyerPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

}
