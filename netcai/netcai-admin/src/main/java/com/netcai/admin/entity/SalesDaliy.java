package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售人员日报
 * @author administrator
 */
public class SalesDaliy implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
     * 日报ID
     */
	private Long sdId;
    /**
     * 日期
     */
	private String sdDate;
	/**
     * 销售人员ID
     */
	private Long saleId;
	/**
     * 销售人员姓名
     */
	private String saleName;
	/**
	 * 销售任务
	 */
	private BigDecimal task1;
	/**
	 * 实际完成
	 */
	private BigDecimal taskReal1;
	/**
	 * 拜访量
	 */
	private BigDecimal task2;
	/**
	 * 实际完成
	 */
	private BigDecimal taskReal2;
    /**
     * 拜访街道
     */
	private String sdStreet;
    /**
     * 今日总结
     */
	private String sdSummary;
    /**
     * 提交时间
     */
	private Date sdTime;
	/**
     * 查阅状态(0未读 1已读)
     */
	private Integer lookStatus;
	/**
     * 查阅时间
     */
	private Date lookTime;
	/**
     * 查阅人
     */
	private String lookName;
	/**
     * 查阅回复
     */
	private String lookReply;
	
	public Long getSdId() {
		return sdId;
	}
	public void setSdId(Long sdId) {
		this.sdId = sdId;
	}
	public String getSdDate() {
		return sdDate;
	}
	public void setSdDate(String sdDate) {
		this.sdDate = sdDate;
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
	public BigDecimal getTask1() {
		return task1;
	}
	public void setTask1(BigDecimal task1) {
		this.task1 = task1;
	}
	public BigDecimal getTaskReal1() {
		return taskReal1;
	}
	public void setTaskReal1(BigDecimal taskReal1) {
		this.taskReal1 = taskReal1;
	}
	public BigDecimal getTask2() {
		return task2;
	}
	public void setTask2(BigDecimal task2) {
		this.task2 = task2;
	}
	public BigDecimal getTaskReal2() {
		return taskReal2;
	}
	public void setTaskReal2(BigDecimal taskReal2) {
		this.taskReal2 = taskReal2;
	}
	public String getSdStreet() {
		return sdStreet;
	}
	public void setSdStreet(String sdStreet) {
		this.sdStreet = sdStreet;
	}
	public String getSdSummary() {
		return sdSummary;
	}
	public void setSdSummary(String sdSummary) {
		this.sdSummary = sdSummary;
	}
	public Date getSdTime() {
		return sdTime;
	}
	public void setSdTime(Date sdTime) {
		this.sdTime = sdTime;
	}
	public Integer getLookStatus() {
		return lookStatus;
	}
	public void setLookStatus(Integer lookStatus) {
		this.lookStatus = lookStatus;
	}
	public Date getLookTime() {
		return lookTime;
	}
	public void setLookTime(Date lookTime) {
		this.lookTime = lookTime;
	}
	public String getLookName() {
		return lookName;
	}
	public void setLookName(String lookName) {
		this.lookName = lookName;
	}
	public String getLookReply() {
		return lookReply;
	}
	public void setLookReply(String lookReply) {
		this.lookReply = lookReply;
	}
}
