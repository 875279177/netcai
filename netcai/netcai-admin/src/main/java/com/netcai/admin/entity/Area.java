package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域实体类
 * @author administrator
 */
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 排序
	 */
	private Integer sequence;
	/**
	 * 父类ID,0表示第一级
	 */
	private Long parentId;
	/**
	 * 层级
	 */
	private Integer level;
	/**
	 * 状态(1为可用，-1为不可用)
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Area() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
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