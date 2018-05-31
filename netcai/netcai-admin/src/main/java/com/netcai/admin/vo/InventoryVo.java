package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统清单实体类
 * 
 * @author administrator
 *
 */
public class InventoryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 餐馆类型id
	 */
	private Long buyerTypeId;
	/**
	 * 餐馆类型名称
	 */
	private String buyerTypeName;
	/**
	 * 餐馆类型多个id拼接
	 */
	private String buyerTypeIds;
	/**
	 * 商品和卖家id拼接
	 */
	private String goodsIds;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 卖家店铺
	 */
	private String sellerName;
	/**
	 * 商品id
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 区id
	 */
	private Long regionId;
	/**
	 * 区名称
	 */
	private String regionName;

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

	public Long getBuyerTypeId() {
		return buyerTypeId;
	}

	public void setBuyerTypeId(Long buyerTypeId) {
		this.buyerTypeId = buyerTypeId;
	}

	public String getBuyerTypeName() {
		return buyerTypeName;
	}

	public void setBuyerTypeName(String buyerTypeName) {
		this.buyerTypeName = buyerTypeName;
	}

	public String getBuyerTypeIds() {
		return buyerTypeIds;
	}

	public void setBuyerTypeIds(String buyerTypeIds) {
		this.buyerTypeIds = buyerTypeIds;
	}

	public String getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
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
