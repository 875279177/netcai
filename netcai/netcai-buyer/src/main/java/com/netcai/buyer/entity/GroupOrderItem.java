package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 团购订单明细主表
 * @author administrator
 */
public class GroupOrderItem implements Serializable {

	private static final long serialVersionUID = 8058734556895568614L;
    /**
     * 卖家ID
     */
	private Long sellerId;
	/**
	 * 团购明细ID
	 */
	private Long itemId;
	/**
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 购买数量
	 */
	private BigDecimal groupNum;
	/**
	 * 购买单价
	 */
	private BigDecimal groupPrice;
	
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public BigDecimal getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(BigDecimal groupNum) {
		this.groupNum = groupNum;
	}
	public BigDecimal getGroupPrice() {
		return groupPrice;
	}
	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}
}
