package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * 买家类型
 */
public class BuyerType implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	public int id;

	/**
	 * 类型名称
	 */
	private String typeName;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}