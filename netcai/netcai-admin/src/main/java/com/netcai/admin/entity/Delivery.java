package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 配送人员基本信息
 * 
 * @author mengjie
 *
 */
public class Delivery implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 区域id
	 */
	private Long areaId;
	/**
	 * 省市区
	 */
	private String areaName;
	/**
	 * 手机号码,作为账号登陆
	 */
	private String deliveryPhone;
	/**
	 * 密码
	 */
	private String deliveryPassword;
	/**
	 * 配送人员姓名
	 */
	private String deliveryName;
	/**
	 * 配送人员身份证号码
	 */
	private String deliveryIdCard;
	/**
	 * 配送人员性别(1为男，2为女)
	 */
	private Integer deliverySex;
	/**
	 * 配送人员年龄
	 */
	private Integer deliveryAge;
	/**
	 * 配送人员类型(1为自营，2为加盟)
	 */
	private Integer deliveryType;
	/**
	 * 排序使用
	 */
	private Integer sequence;
	/**
	 * 备注信息
	 */
	private String remark;
	/**
	 * 状态(1为可用，-1为不可用)
	 */
	private Integer status;
	/**
	 * 操作权限
	 */
	private Integer permissionType;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 最后更新时间
	 */
	private Date lastUpdateTime;

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

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDeliveryPhone() {
		return deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public String getDeliveryPassword() {
		return deliveryPassword;
	}

	public void setDeliveryPassword(String deliveryPassword) {
		this.deliveryPassword = deliveryPassword;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryIdCard() {
		return deliveryIdCard;
	}

	public void setDeliveryIdCard(String deliveryIdCard) {
		this.deliveryIdCard = deliveryIdCard;
	}

	public Integer getDeliverySex() {
		return deliverySex;
	}

	public void setDeliverySex(Integer deliverySex) {
		this.deliverySex = deliverySex;
	}

	public Integer getDeliveryAge() {
		return deliveryAge;
	}

	public void setDeliveryAge(Integer deliveryAge) {
		this.deliveryAge = deliveryAge;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPermissionType() {
		return permissionType;
	}

	public void setPermissionType(Integer permissionType) {
		this.permissionType = permissionType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
