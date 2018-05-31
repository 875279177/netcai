package com.netcai.admin.entity;

import java.io.Serializable;
/**
 * 买家类型实体类
 * @author administrator
 *
 */
import java.util.Date;

public class BuyerType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 类型名称
	 */
	private String name;
	/**
	 * 状态
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
