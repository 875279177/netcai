package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 活动商品显示类
 * @author administrator
 */
public class ActivityGoodsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int activityGoodsId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品规格ID
	 */
	private Long goodsFormartId;
	/**
	 * 规格名称
	 */
	private String formatName;
	/**
	 * 商品原价格
	 */
	private Double formatPrice;
	/**
	 * 单位
	 */
	private String unitName;
	/**
	 * 所属商家
	 */
	private String goodsSellerName;
	/**
	 * 活动价
	 */
	private Double activityPrice;
	
	public int getActivityGoodsId() {
		return activityGoodsId;
	}
	public void setActivityGoodsId(int activityGoodsId) {
		this.activityGoodsId = activityGoodsId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Long getGoodsFormartId() {
		return goodsFormartId;
	}
	public void setGoodsFormartId(Long goodsFormartId) {
		this.goodsFormartId = goodsFormartId;
	}
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public Double getFormatPrice() {
		return formatPrice;
	}
	public void setFormatPrice(Double formatPrice) {
		this.formatPrice = formatPrice;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getGoodsSellerName() {
		return goodsSellerName;
	}
	public void setGoodsSellerName(String goodsSellerName) {
		this.goodsSellerName = goodsSellerName;
	}
	public Double getActivityPrice() {
		return activityPrice;
	}
	public void setActivityPrice(Double activityPrice) {
		this.activityPrice = activityPrice;
	}
}
