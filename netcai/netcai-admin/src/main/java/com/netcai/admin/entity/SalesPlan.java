package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售计划
 * @author administrator
 */
public class SalesPlan implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 计划ID
     */
	private Long spId;
    /**
     * 类型(1区域 2销售)
     */
	private Short spType;
	/**
     * 月份
     */
	private String spFmon;
	/**
     * 销售人员ID
     */
	private Long saleId;
	/**
     * 销售姓名
     */
	private String saleName;
	/**
     * 区域ID
     */
	private Long areaId;
	/**
     * 区域名称
     */
	private String areaName;
	/**
	 * 销售任务
	 */
	private BigDecimal goalAmt;
	/**
	 * 线上支付
	 */
	private BigDecimal onlineAmt;
	/**
	 * 蔬菜销售
	 */
	private BigDecimal greenAmt;
	/**
	 * 新开商户
	 */
	private Integer registerNum;
	/**
	 * 创建人
	 */
	private Integer createUserId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getSpId() {
		return spId;
	}
	public void setSpId(Long spId) {
		this.spId = spId;
	}
	public Short getSpType() {
		return spType;
	}
	public void setSpType(Short spType) {
		this.spType = spType;
	}
	public String getSpFmon() {
		return spFmon;
	}
	public void setSpFmon(String spFmon) {
		this.spFmon = spFmon;
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
	public BigDecimal getGoalAmt() {
		return goalAmt;
	}
	public void setGoalAmt(BigDecimal goalAmt) {
		this.goalAmt = goalAmt;
	}
	public BigDecimal getOnlineAmt() {
		return onlineAmt;
	}
	public void setOnlineAmt(BigDecimal onlineAmt) {
		this.onlineAmt = onlineAmt;
	}
	public BigDecimal getGreenAmt() {
		return greenAmt;
	}
	public void setGreenAmt(BigDecimal greenAmt) {
		this.greenAmt = greenAmt;
	}
	public Integer getRegisterNum() {
		return registerNum;
	}
	public void setRegisterNum(Integer registerNum) {
		this.registerNum = registerNum;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
