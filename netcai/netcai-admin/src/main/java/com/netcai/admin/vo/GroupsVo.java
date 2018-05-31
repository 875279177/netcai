package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class GroupsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 明细id
	 */
	private Long itemId;
	/**
	 * 团购活动编号
	 */
	private String groupNumber;
	/**
	 * 团购活动标题
	 */
	private String title;
	/**
	 * 团购活动图片
	 */
	private String logo;
	/**
	 * 团购区域(多个区域id拼接)
	 */
	private String regionIds;
	/**
	 * 团购区域名称
	 */
	private String regionNames;
	/**
	 * 开始时间
	 */
	private Date beginTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 开始时间
	 */
	private String beginTimeStr;
	/**
	 * 结束时间
	 */
	private String endTimeStr;
	/**
	 * 最大买家数量
	 */
	private Integer maxNumber;
	/**
	 * 起团金额(买家参团的最低消费金额)
	 */
	private BigDecimal minGroupsAmount;
	/**
	 * 开团金额(团购活动的总金额)
	 */
	private BigDecimal groupsAmount;
	/**
	 * 状态((1发布 -1未发布 2团成 3未团成))
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 创建人
	 */
	private Long createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品规格ids
	 */
	private String formatIds;
	/**
	 * 商品规格名称
	 */
	private String formatName;
	/**
	 * 团购价格(拼团成功的交易价格)
	 */
	private BigDecimal groupPrice;
	/**
	 * 原价
	 */
	private BigDecimal formatPrice;
	/**
	 * 团购数量
	 */
	private Integer count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRegionIds() {
		return regionIds;
	}

	public void setRegionIds(String regionIds) {
		this.regionIds = regionIds;
	}

	public String getRegionNames() {
		return regionNames;
	}

	public void setRegionNames(String regionNames) {
		this.regionNames = regionNames;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getBeginTimeStr() {
		return beginTimeStr;
	}

	public void setBeginTimeStr(String beginTimeStr) {
		this.beginTimeStr = beginTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public Integer getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(Integer maxNumber) {
		this.maxNumber = maxNumber;
	}

	public BigDecimal getMinGroupsAmount() {
		return minGroupsAmount;
	}

	public void setMinGroupsAmount(BigDecimal minGroupsAmount) {
		this.minGroupsAmount = minGroupsAmount;
	}

	public BigDecimal getGroupsAmount() {
		return groupsAmount;
	}

	public void setGroupsAmount(BigDecimal groupsAmount) {
		this.groupsAmount = groupsAmount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getFormatIds() {
		return formatIds;
	}

	public void setFormatIds(String formatIds) {
		this.formatIds = formatIds;
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public BigDecimal getFormatPrice() {
		return formatPrice;
	}

	public void setFormatPrice(BigDecimal formatPrice) {
		this.formatPrice = formatPrice;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
