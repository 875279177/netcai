package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 退换货原因类别
 * 
 * @author administrator
 */
public class OrderReturnCause implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 自增id
	 */
	private Long id;

	/**
	 * 退换货原因
	 */
	private String causeName;

	/**
	 * 父级id
	 */
	private Long parentId;

	/**
	 * 排序
	 */
	private Integer sequence;

	/**
	 * 是否显示,1为显示，-1为不显示
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

	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName == null ? null : causeName.trim();
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}