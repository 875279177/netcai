package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class BillSellerConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 账单周期
	 */
	private Integer period;
	/**
	 * 账单状态，1为可用，-1为不可用
	 */
	private Integer status;
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

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getPeriod() {
		return period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
