package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单项交易类型
 * @author administrator
 *
 */
public class OrderItemLogs implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 569466381333606429L;
    private Long id;

    private Long orderItemId;

    private Long sellerId;

    private Long buyerId;

    private Integer tradeType;

    private BigDecimal goodsUnitPrice;

    private Double goodsFinalNumber;

    private BigDecimal goodsFinalPrice;

    private BigDecimal tradeMoney;

    private String remark;

    private Date createTime;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}
	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getTradeType() {
		return tradeType;
	}
	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}
	public BigDecimal getGoodsUnitPrice() {
		return goodsUnitPrice;
	}
	public void setGoodsUnitPrice(BigDecimal goodsUnitPrice) {
		this.goodsUnitPrice = goodsUnitPrice;
	}
	public Double getGoodsFinalNumber() {
		return goodsFinalNumber;
	}
	public void setGoodsFinalNumber(Double goodsFinalNumber) {
		this.goodsFinalNumber = goodsFinalNumber;
	}
	public BigDecimal getGoodsFinalPrice() {
		return goodsFinalPrice;
	}
	public void setGoodsFinalPrice(BigDecimal goodsFinalPrice) {
		this.goodsFinalPrice = goodsFinalPrice;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
