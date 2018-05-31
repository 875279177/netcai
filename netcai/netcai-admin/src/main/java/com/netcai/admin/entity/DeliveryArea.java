package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 配送区域实体类
 * 
 * @author administrator
 *
 */
public class DeliveryArea implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 关联area区对应的id
	 */
	private Long areaId;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 登录的用户id
	 */
	private Long userId;
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

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
