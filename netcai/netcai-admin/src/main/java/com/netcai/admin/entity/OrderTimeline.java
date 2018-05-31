package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 退换货时间轴
 */
public class OrderTimeline implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 订单项id
	 */
	private Long itemId;
	/**
	 * 备注
	 */
	private String remarks;
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
	public Long getItemId() {
		return itemId;
	}
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
