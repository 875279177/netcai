package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 配送区域关联配送人员实体类
 * 
 * @author administrator
 *
 */
public class DeliveryRelatedArea implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5618353864385077833L;
	private Long id;
	/**
	 * 配送人员id
	 */
	private Long deliveryId;
	/**
	 * 配送区域id
	 */
	private Long deliveryAreaId;
	/**
	 * 创建人id
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

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Long getDeliveryAreaId() {
		return deliveryAreaId;
	}

	public void setDeliveryAreaId(Long deliveryAreaId) {
		this.deliveryAreaId = deliveryAreaId;
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
