package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.Date;

public class DeliveryAreaVo implements Serializable {

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
	 * 配送人员id
	 */
	private Long deliveryId;
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
	/**
	 * 是否选中(1为选中，-1为未选中)
	 */
	private Integer checked;

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

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
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

	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	
}
