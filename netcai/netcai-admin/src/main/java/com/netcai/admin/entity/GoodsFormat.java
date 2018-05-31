package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品规格实体类
 * @author administrator
 */
public class GoodsFormat implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long formatId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 计量单位ID
	 */
	private Integer unitId;
	/**
	 * 名称
	 */
	private String formatName;
	/**
	 * 原价格
	 */
	private BigDecimal oldPrice;
	/**
	 * 价格
	 */
	private BigDecimal formatPrice;
	/**
	 * 数量
	 */
	private Integer formatNum;
	/**
	 * 顺序号
	 */
	private Integer formatSeq;
	/**
	 * 状态
	 */
	private Short formatStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public BigDecimal getFormatPrice() {
		return formatPrice;
	}
	public void setFormatPrice(BigDecimal formatPrice) {
		this.formatPrice = formatPrice;
	}
	public Integer getFormatNum() {
		return formatNum;
	}
	public void setFormatNum(Integer formatNum) {
		this.formatNum = formatNum;
	}
	public Integer getFormatSeq() {
		return formatSeq;
	}
	public void setFormatSeq(Integer formatSeq) {
		this.formatSeq = formatSeq;
	}
	public Short getFormatStatus() {
		return formatStatus;
	}
	public void setFormatStatus(Short formatStatus) {
		this.formatStatus = formatStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**************************************************query*******************************************************/
	
	/**
	 * 单位名称
	 */
	private String unitName;

	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	
}
