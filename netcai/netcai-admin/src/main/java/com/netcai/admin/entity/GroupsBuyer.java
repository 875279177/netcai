package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 团购买家表
 */
public class GroupsBuyer implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -736251552603489977L;

	/**
	 * 主键ID
	 */
	private Long gbId;
	/**
	 * 买家ID
	 */
    private Long buyerId;
    /**
	 * 团购明细ID
	 */
    private Long itemId;
    /**
	 * 订单ID
	 */
    private Long orderId;
    /**
     * 团购ID
     */
    private Long groupId;
    /**
	 * 团购数量
	 */
    private Integer gbNum;
    /**
	 * 团购价格
	 */
    private BigDecimal gbPrice;
    /**
	 * 团购金额
	 */
    private BigDecimal gbAmt;
    /**
	 * 状态(1完成 -1取消)
	 */
    private Byte gbStatus;
    /**
	 * 团购时间
	 */
    private Date gbTime;
    /**
	 * 买家
	 */
    private Buyer buyer;
    /**
	 * 商品
	 */
    private Goods goods;
    /**
	 * 团购活动配置表
	 */
    private Groups groups;    
    /**
	 * 订单
	 */
    private OrderInfo orderInfo; 

	public Long getGbId() {
		return gbId;
	}

	public void setGbId(Long gbId) {
		this.gbId = gbId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getGbNum() {
		return gbNum;
	}

	public void setGbNum(Integer gbNum) {
		this.gbNum = gbNum;
	}

	public BigDecimal getGbPrice() {
		return gbPrice;
	}

	public void setGbPrice(BigDecimal gbPrice) {
		this.gbPrice = gbPrice;
	}

	public BigDecimal getGbAmt() {
		return gbAmt;
	}

	public void setGbAmt(BigDecimal gbAmt) {
		this.gbAmt = gbAmt;
	}

	public Byte getGbStatus() {
		return gbStatus;
	}

	public void setGbStatus(Byte gbStatus) {
		this.gbStatus = gbStatus;
	}

	public Date getGbTime() {
		return gbTime;
	}

	public void setGbTime(Date gbTime) {
		this.gbTime = gbTime;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	/*******************************************************query****************************************************************************/
	
	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}

	/**
	 * 所属区域;
	 */
	private String areaName;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}