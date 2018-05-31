package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品上下架监控
 * @author administrator
 */
public class GoodsRevise implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long grId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 状态(1上架 -1下架)
	 */
	private Short status;
	/**
	 * 操作人
	 */
	private Long reviseId;
	/**
	 * 状态(1为商家，2平台)
	 */
	private Short reviseForm;
	/**
	 * 调整时间
	 */
	private Date reviceTime;
	
	public Long getGrId() {
		return grId;
	}
	public void setGrId(Long grId) {
		this.grId = grId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public Short getStatus() {
		return status;
	}
	public void setStatus(Short status) {
		this.status = status;
	}
	public Long getReviseId() {
		return reviseId;
	}
	public void setReviseId(Long reviseId) {
		this.reviseId = reviseId;
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
}
