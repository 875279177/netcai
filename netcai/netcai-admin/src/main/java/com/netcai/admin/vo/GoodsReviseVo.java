package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GoodsReviseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 规格名称
	 */
	private String formatName;
	/**
	 * 修改人
	 */
	private String trueName;
	/**
	 * 状态
	 */
	private Short status;
	/**
	 * 来源(1商家 2平台)
	 */
	private Short reviseForm;
	/**
	 * 调整时间
	 */
	private Date reviceTime;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 商品标签
	 */
	private String goodsLabel;
	/**
	 * 商品品牌
	 */
	private String goodsBrand;
	/**
	 * 价格
	 */
	private BigDecimal formatPrice;
	
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Short getReviseForm() {
		return reviseForm;
	}
	public void setReviseForm(Short reviseForm) {
		this.reviseForm = reviseForm;
	}
	public Date getReviceTime() {
		return reviceTime;
	}
	public void setReviceTime(Date reviceTime) {
		this.reviceTime = reviceTime;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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
	public BigDecimal getFormatPrice() {
		return formatPrice;
	}
	public void setFormatPrice(BigDecimal formatPrice) {
		this.formatPrice = formatPrice;
	}
	
}
