package com.netcai.admin.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 价格调整记录
 * 
 * @author administrator
 *
 */
public class PriceReviseVo {
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 规格名称
	 */
	private String formatName;
	/**
	 * 单位
	 */
	private String unitName;
	/**
	 * 卖家真实姓名
	 */
	private String trueName;
	/**
	 * 卖家手机号
	 */
	private String account;
	/**
	 * 原价
	 */
	private BigDecimal oldPrice;
	/**
	 * 来源(1平台 2商家)
	 */
	private Short reviseFrom;
	/**
	 * 调整后价格
	 */
	private BigDecimal revisePrice;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 开始时间字符串
	 */
	private String startTimeStr;
	/**
	 * 结束时间字符串
	 */
	private String endTimeStr;

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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public BigDecimal getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}

	public Short getReviseFrom() {
		return reviseFrom;
	}

	public void setReviseFrom(Short reviseFrom) {
		this.reviseFrom = reviseFrom;
	}

	public BigDecimal getRevisePrice() {
		return revisePrice;
	}

	public void setRevisePrice(BigDecimal revisePrice) {
		this.revisePrice = revisePrice;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
}
