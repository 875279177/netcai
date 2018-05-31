package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 商品规格显示类
 * @author administrator
 */
public class GoodsFormatVo implements Serializable {
	
    private static final long serialVersionUID = 1L;
	
	private Long formatId;
	/**
	 * 计量单位ID
	 */
	private Integer unitId;
	/**
	 * 计量单位名称
	 */
	private String unitName;
	/**
	 * 名称
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
	 * 顺序号
	 */
	private Integer formatSeq;
	/**
	 * 状态
	 */
	private Short formatStatus;
	
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
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
}
