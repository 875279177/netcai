package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 团购活动
 * @author administrator
 */
public class GroupsItemVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long itemId;
	/**
	 * 卖家ID
	 */
	private Long sellerId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品别名
	 */
	private String goodsAs;
	/**
	 * 商品标签
	 */
	private String goodsLabel;
	/**
	 * 商品品牌
	 */
	private String goodsBrand;
	/**
	 * 商品图片
	 */
	private String picUrl;
	/**
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 计量单位名称
	 */
	private String unitName;
	/**
	 * 规格名称
	 */
	private String formatName;
	/**
	 * 价格
	 */
	private Double formatPrice;
	/**
	 * 数量
	 */
	private Integer formatNum;
	/**
	 * 团购价格(拼团成功的交易价格)
	 */
	private BigDecimal groupPrice;
	/**
	 * 团购数量
	 */
	private Integer groupNum;
	
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
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
	public String getGoodsAs() {
		return goodsAs;
	}
	public void setGoodsAs(String goodsAs) {
		this.goodsAs = goodsAs;
	}
	public String getGoodsLabel() {
		return goodsLabel;
	}
	public void setGoodsLabel(String goodsLabel) {
		this.goodsLabel = goodsLabel;
	}
	public String getGoodsBrand() {
		return goodsBrand;
	}
	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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
	public Integer getFormatNum() {
		return formatNum;
	}
	public void setFormatNum(Integer formatNum) {
		this.formatNum = formatNum;
	}
	public BigDecimal getGroupPrice() {
		return groupPrice;
	}
	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}
	public Integer getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(Integer groupNum) {
		this.groupNum = groupNum;
	}
}
