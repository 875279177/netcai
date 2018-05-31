package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 计量单位实体类
 * @author administrator
 */
public class Unit implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private Integer unitId;
	/**
	 * 单位编码
	 */
	private String unitCode;
	/**
	 * 单位名称
	 */
	private String unitName;
	/**
	 * 单位顺序
	 */
	private Integer unitSeq;
	/**
	 * 状态(1为可用，-1为不可用)
	 */
	private Short unitStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitCode() {
		return unitCode;
	}
	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getUnitSeq() {
		return unitSeq;
	}
	public void setUnitSeq(Integer unitSeq) {
		this.unitSeq = unitSeq;
	}
	public Short getUnitStatus() {
		return unitStatus;
	}
	public void setUnitStatus(Short unitStatus) {
		this.unitStatus = unitStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
