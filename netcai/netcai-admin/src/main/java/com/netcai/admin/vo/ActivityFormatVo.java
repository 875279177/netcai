package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 活动规则显示类
 * @author administrator
 */
public class ActivityFormatVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private int activityFormatId;
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
	
	public int getActivityFormatId() {
		return activityFormatId;
	}
	public void setActivityFormatId(int activityFormatId) {
		this.activityFormatId = activityFormatId;
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
}
