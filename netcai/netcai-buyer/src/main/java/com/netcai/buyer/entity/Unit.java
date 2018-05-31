package com.netcai.buyer.entity;

import java.io.Serializable;

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
}
