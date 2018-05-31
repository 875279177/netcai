package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 商品vo类(选择商品时使用)
 * @author administrator
 */
public class GoodsVo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 活动ID
	 */
	private Integer activityId;

	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 规格ID
	 */
	private Long formatId;
	/**
	 * 规格名称
	 */
	private String formatName;
	/**
	 * 价格
	 */
	private Double formatPrice;
	/**
	 * 单位
	 */
	private String unitName;
	/**
	 * 商家IDS
	 */
	private String userIds;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
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
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
}
