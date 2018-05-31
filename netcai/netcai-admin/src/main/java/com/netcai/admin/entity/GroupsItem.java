package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 团购明细实体类
 * 
 * @author administrator
 *
 */
public class GroupsItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 团购活动id
	 */
	private Long groupId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 商品规格名称
	 */
	private String formatName;
	/**
	 * 商品规格原价
	 */
	private BigDecimal formatPrice;
	/**
	 * 商品规格原价
	 */
	private Integer formatNum;
	/**
	 * 单位名称
	 */
	private String unitName;
	/**
	 * 团购价格(拼团成功的交易价格)
	 */
	private BigDecimal price;
	/**
	 * 团购数量
	 */
	private Integer count;
	/**
	 * 状态(1在用 -1停用)
	 */
	private Integer status;
	/**
	 * 团购活动id
	 */
	private Long createUserId;
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

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
