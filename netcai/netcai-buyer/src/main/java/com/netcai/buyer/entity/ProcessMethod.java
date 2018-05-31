package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 加工方式实体类
 * @author administrator
 */
public class ProcessMethod implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private Integer methodId;
	/**
	 * 单位名称
	 */
	private String methodName;
	/**
	 * 状态(1为可用，-1为不可用)
	 */
	private Short methodStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Integer getMethodId() {
		return methodId;
	}
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Short getMethodStatus() {
		return methodStatus;
	}
	public void setMethodStatus(Short methodStatus) {
		this.methodStatus = methodStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
