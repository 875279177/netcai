package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 销售人员周报
 * 
 * @author administrator
 */
public class SalesWeekly implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 周报ID
	 */
	private Long swId;
	/**
	 * 月份
	 */
	private String swFmon;
	/**
	 * 范围
	 */
	private String swRange;
	/**
	 * 销售人员ID
	 */
	private Long saleId;

	/**
	 * 查看人
	 */
	private Long lookSaleId;

	/**
	 * 销售人员
	 */
	private String saleName;
	/**
	 * 本周总结
	 */
	private String swSummary;
	/**
	 * 下周计划
	 */
	private String swPlan;
	/**
	 * 需求帮助
	 */
	private String needHelp;
	/**
	 * 提交时间
	 */
	private Date swTime;
	/**
	 * 查阅状态(0未读 1已读)
	 */
	private Integer lookStatus;
	/**
	 * 查阅人
	 */
	private String lookName;
	/**
	 * 查阅时间
	 */
	private Date lookTime;
	/**
	 * 查阅回复
	 */
	private String lookReply;

	public Long getSwId() {
		return swId;
	}

	public void setSwId(Long swId) {
		this.swId = swId;
	}

	public String getSwFmon() {
		return swFmon;
	}

	public void setSwFmon(String swFmon) {
		this.swFmon = swFmon;
	}

	public String getSwRange() {
		return swRange;
	}

	public void setSwRange(String swRange) {
		this.swRange = swRange;
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

	public String getSwSummary() {
		return swSummary;
	}

	public void setSwSummary(String swSummary) {
		this.swSummary = swSummary;
	}

	public String getSwPlan() {
		return swPlan;
	}

	public void setSwPlan(String swPlan) {
		this.swPlan = swPlan;
	}

	public String getNeedHelp() {
		return needHelp;
	}

	public void setNeedHelp(String needHelp) {
		this.needHelp = needHelp;
	}

	public Date getSwTime() {
		return swTime;
	}

	public void setSwTime(Date swTime) {
		this.swTime = swTime;
	}

	public Integer getLookStatus() {
		return lookStatus;
	}

	public void setLookStatus(Integer lookStatus) {
		this.lookStatus = lookStatus;
	}

	public String getLookName() {
		return lookName;
	}

	public void setLookName(String lookName) {
		this.lookName = lookName;
	}

	public Date getLookTime() {
		return lookTime;
	}

	public void setLookTime(Date lookTime) {
		this.lookTime = lookTime;
	}

	public String getLookReply() {
		return lookReply;
	}

	public void setLookReply(String lookReply) {
		this.lookReply = lookReply;
	}

	public Long getLookSaleId() {
		return lookSaleId;
	}

	public void setLookSaleId(Long lookSaleId) {
		this.lookSaleId = lookSaleId;
	}

}
