package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class DeliveryTask implements Serializable{

	/**
	 * 配送订单信息;
	 */
	private static final long serialVersionUID = 259455644491725152L;

	/**
	 * 主键ID
	 */
	private Long taskId;
	/**
	 * 配送人员ID
	 */
	private Long deliveryId;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 订单明细ID'
	 */
	private Long orderItemId;
	/**
	 * 分配人员ID
	 */
	private Long sysUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getTaskId() {
		return taskId;
	}
	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Long getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(Long sysUserId) {
		this.sysUserId = sysUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
