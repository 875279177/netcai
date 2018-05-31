package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

public class TradeTimeConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 区域id
	 */
	private Long regionId;
	/**
	 * 交易开始时间
	 */
	private String tradeStartTime;
	/**
	 * 交易结束时间
	 */
	private String tradeEndTime;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

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

	public String getTradeStartTime() {
		return tradeStartTime;
	}

	public void setTradeStartTime(String tradeStartTime) {
		this.tradeStartTime = tradeStartTime;
	}

	public String getTradeEndTime() {
		return tradeEndTime;
	}

	public void setTradeEndTime(String tradeEndTime) {
		this.tradeEndTime = tradeEndTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
