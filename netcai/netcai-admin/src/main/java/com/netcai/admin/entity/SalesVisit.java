package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售人员拜访记录
 * @author administrator
 */
public class SalesVisit implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 记录ID
     */
	private Long svId;
	/**
     * 销售人员ID
     */
	private Long saleId;
	/**
     * 销售人员姓名
     */
	private String saleName;
	/**
     * 买家ID
     */
	private Long buyerId;
	/**
     * 店铺名称
     */
	private String buyerName;
	/**
     * 老板姓名
     */
	private String bossName;
	/**
     * 老板电话
     */
	private String bossTel;
    /**
     * 店铺门头
     */
	private String svLogo;
	/**
	 * 拜访方式(1预约 2其他)
	 */
	private Short svWay;
	/**
	 * 拜访类型(1上门 2电话)
	 */
	private Short svType;
    /**
     * 拜访地址
     */
	private String svAddress;
	/**
	 * 拜访状态(0未 1已拜访)
	 */
	private Short svStatus;
    /**
     * 拜访时间
     */
	private Date svTime;
    /**
     * 拜访感想
     */
	private String svRemark;
	public Long getSvId() {
		return svId;
	}
	public void setSvId(Long svId) {
		this.svId = svId;
	}
	public Long getSaleId() {
		return saleId;
	}
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
	public String getSaleName() {
		return saleName;
	}
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBossName() {
		return bossName;
	}
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	public String getBossTel() {
		return bossTel;
	}
	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}
	public String getSvLogo() {
		return svLogo;
	}
	public void setSvLogo(String svLogo) {
		this.svLogo = svLogo;
	}
	public Short getSvWay() {
		return svWay;
	}
	public void setSvWay(Short svWay) {
		this.svWay = svWay;
	}
	public Short getSvType() {
		return svType;
	}
	public void setSvType(Short svType) {
		this.svType = svType;
	}
	public String getSvAddress() {
		return svAddress;
	}
	public void setSvAddress(String svAddress) {
		this.svAddress = svAddress;
	}
	public Short getSvStatus() {
		return svStatus;
	}
	public void setSvStatus(Short svStatus) {
		this.svStatus = svStatus;
	}
	public Date getSvTime() {
		return svTime;
	}
	public void setSvTime(Date svTime) {
		this.svTime = svTime;
	}
	public String getSvRemark() {
		return svRemark;
	}
	public void setSvRemark(String svRemark) {
		this.svRemark = svRemark;
	}

}
