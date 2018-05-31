package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.Unit;

/**
 * 商品规格实体类
 * @author administrator
 */
public class GoodsFormatVo implements Serializable{

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
	/**
	 * 计量单位
	 */
	private Unit unit;
	/**
	 * 商品
	 */
	private Goods goods;
	
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
	public Unit getUnit() {
		return unit;
	}
	public void setUnit(Unit unit) {
		this.unit = unit;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
}
