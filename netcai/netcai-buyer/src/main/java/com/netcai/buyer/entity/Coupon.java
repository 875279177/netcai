package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 优惠券基础配置表
 */
public class Coupon implements Serializable {

	private static final long serialVersionUID = -6509314252219950400L;

	private Long id;
	/**
	 * 所属区域
	 */
	private Long regionId;
	/**
	 * 所属类型,1为满减
	 */
	private Integer type;
	/**
	 * 优惠券名称
	 */
	private String name;
	/**
	 * 图片的URL地址
	 */
	private String img;
	/**
	 * 优惠券开始时间
	 */
	private Date startTime;
	/**
	 * 优惠券结束时间
	 */
	private Date endTime;
	/**
	 * 优惠券金额，用整数，固定值目前。
	 */
	private BigDecimal money;
	/**
	 * 状态，0表示未开始，1表示进行中，-1表示结束
	 */
	private Integer status;
	/**
	 * 优惠券的说明
	 */
	private String remarks;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 金额满
	 */
	private BigDecimal fullMoney;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getFullMoney() {
		return fullMoney;
	}

	public void setFullMoney(BigDecimal fullMoney) {
		this.fullMoney = fullMoney;
	}

}