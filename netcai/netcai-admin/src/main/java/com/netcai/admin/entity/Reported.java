package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 报备表
 */
public class Reported implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8155820673761404040L;
	
	private Long rId;
	/**
	 * 订单ID
	 */
    private Long rOrderId;
    /**
	 * 订单明细ID
	 */
    private Long rItemId;
    /**
	 * 报备类型(1缺货 2补货 3退货 4换货)
	 */
    private Integer rType;
    /**
	 * 报备内容
	 */
    private String rContent;
    /**
	 * 报备时间
	 */
    private Date rTime;
    /**
	 * 报备来源(1配送端 2销售端 3后台)
	 */
    private Integer rFrom;
    /**
	 * 报备人ID
	 */
    private Long rUserId;
    /**
	 * 阅读状态(1未读 2已读)
	 */
    private Integer rReadStatus;
    /**
	 * 阅读时间
	 */
    private Date rReadTime;
    /**
	 * 解决状态(1未解决 2已解决)
	 */
    private Integer rSolveStatus;
    /**
	 * 解决时间
	 */
    private Date rSolveTime;

    /**
	 * 报备人员;
	 */
    private String name;

	/**
	 * 唯一订单号
	 */
	private String orderNumber;

	/**
	 * 时间查询;
	 */
	private String queryTime;

	/**
	 * 真实姓名
	 */
	private String realName;
	/**
	 * 配送人员姓名
	 */
	private String deliveryName;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品单价
	 */
	private BigDecimal goodsPrice;
	/**
	 * 商品金额
	 */
	private BigDecimal goodsAmount;
	/**
	 * 子项数量
	 */
	private Double goodsNumber;
	/**
	 * 名称
	 */
	private String formatName;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 订单送货时间
	 */
	private Date bestTime;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 支付状态
	 */
	private Integer payStatus;
	public Long getrId() {
		return rId;
	}
	public void setrId(Long rId) {
		this.rId = rId;
	}
	public Long getrOrderId() {
		return rOrderId;
	}
	public void setrOrderId(Long rOrderId) {
		this.rOrderId = rOrderId;
	}
	public Long getrItemId() {
		return rItemId;
	}
	public void setrItemId(Long rItemId) {
		this.rItemId = rItemId;
	}
	public Integer getrType() {
		return rType;
	}
	public void setrType(Integer rType) {
		this.rType = rType;
	}
	public String getrContent() {
		return rContent;
	}
	public void setrContent(String rContent) {
		this.rContent = rContent;
	}
	public Date getrTime() {
		return rTime;
	}
	public void setrTime(Date rTime) {
		this.rTime = rTime;
	}
	public Integer getrFrom() {
		return rFrom;
	}
	public void setrFrom(Integer rFrom) {
		this.rFrom = rFrom;
	}
	public Long getrUserId() {
		return rUserId;
	}
	public void setrUserId(Long rUserId) {
		this.rUserId = rUserId;
	}
	public Integer getrReadStatus() {
		return rReadStatus;
	}
	public void setrReadStatus(Integer rReadStatus) {
		this.rReadStatus = rReadStatus;
	}
	public Date getrReadTime() {
		return rReadTime;
	}
	public void setrReadTime(Date rReadTime) {
		this.rReadTime = rReadTime;
	}
	public Integer getrSolveStatus() {
		return rSolveStatus;
	}
	public void setrSolveStatus(Integer rSolveStatus) {
		this.rSolveStatus = rSolveStatus;
	}
	public Date getrSolveTime() {
		return rSolveTime;
	}
	public void setrSolveTime(Date rSolveTime) {
		this.rSolveTime = rSolveTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}
	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}
	public Double getGoodsNumber() {
		return goodsNumber;
	}
	public void setGoodsNumber(Double goodsNumber) {
		this.goodsNumber = goodsNumber;
	}
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getBestTime() {
		return bestTime;
	}
	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public Integer getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**销售人员Id
     */
    private Long saleId;


	public Long getSaleId() {
		return saleId;
	}
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
	/**
	 * 配送人员ID
	 */
    private Long deliveryId;
    
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
    
	/**
	 * 1缺货 2补货 3退货 4换货
	 */
	private String rTypes;
	public String getrTypes() {
		return rTypes;
	}
	public void setrTypes(String rTypes) {
		this.rTypes = rTypes;
	}
	
	
	/**所属区
     */
    private Long areaId;
    
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**所属区
     */
    private String areaName;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}