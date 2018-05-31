package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动规则实体类
 * @author administrator
 */
public class ActivityFormat implements Serializable {

	private static final long serialVersionUID = 1L;

	private int activityFormatId;
	/**
	 * 活动主题
	 */
	private int activityId;
	/**
	 * 规则标题
	 */
	private String formatTitle;
	/**
	 * 金额满
	 */
	private Double formatFullRmb;
	/**
	 * 扣减/赠送金额
	 */
	private Double formatMinusRmb;
	/**
	 * 状态(1在用 -1停用)
	 */
	private Short formatStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public int getActivityFormatId() {
		return activityFormatId;
	}
	public void setActivityFormatId(int activityFormatId) {
		this.activityFormatId = activityFormatId;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getFormatTitle() {
		return formatTitle;
	}
	public void setFormatTitle(String formatTitle) {
		this.formatTitle = formatTitle;
	}
	public Double getFormatFullRmb() {
		return formatFullRmb;
	}
	public void setFormatFullRmb(Double formatFullRmb) {
		this.formatFullRmb = formatFullRmb;
	}
	public Double getFormatMinusRmb() {
		return formatMinusRmb;
	}
	public void setFormatMinusRmb(Double formatMinusRmb) {
		this.formatMinusRmb = formatMinusRmb;
	}
	public Short getFormatStatus() {
		return formatStatus;
	}
	public void setFormatStatus(Short formatStatus) {
		this.formatStatus = formatStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
