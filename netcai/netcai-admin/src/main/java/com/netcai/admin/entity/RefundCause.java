package com.netcai.admin.entity;

import java.util.Date;

public class RefundCause {

	private Long id;
	/**
	 * 退换货原因
	 */
	private String name;
	/**
	 * 排序
	 */
	private Integer sequence;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 类型；1为卖家买家原因，2为平台原因
	 */
	private Integer type;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
