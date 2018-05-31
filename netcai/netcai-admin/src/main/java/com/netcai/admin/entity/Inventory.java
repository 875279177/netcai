package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class Inventory implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 区域id
	 */
	private Long regionId;
	/**
	 * 餐馆类型id
	 */
	private Long buyerTypeId;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 排序
	 */
	private Integer sequence;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Long getBuyerTypeId() {
		return buyerTypeId;
	}

	public void setBuyerTypeId(Long buyerTypeId) {
		this.buyerTypeId = buyerTypeId;
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

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
