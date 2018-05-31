package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 团购订单主表
 * @author administrator
 */
public class GroupOrder implements Serializable {

	private static final long serialVersionUID = 8058734556895568614L;
    /**
     * 团购ID
     */
	private Long groupId;
    /**
     * 买家ID
     */
	private Long buyerId;
	/**
	 * 买家要求送达时间
	 */
	private String bestTime;
	/**
	 * 购买明细
	 */
	private List<GroupOrderItem> itemList;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBestTime() {
		return bestTime;
	}
	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}
	public List<GroupOrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<GroupOrderItem> itemList) {
		this.itemList = itemList;
	}
}
