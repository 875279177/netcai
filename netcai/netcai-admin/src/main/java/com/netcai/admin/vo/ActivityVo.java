package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动显示类
 * @author administrator
 */
public class ActivityVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer activityId;
	/**
	 * 活动主题
	 */
	private String activityTitle;
	/**
	 * 活动logo
	 */
	private String activityLogo;
	/**
	 * 活动开始时间
	 */
	private String activityBeginTime;
	/**
	 * 活动结束时间
	 */
	private String activityEndTime;
	/**
	 * 活动渠道(1.平台活动 2商家自建)
	 */
	private Short activityChannel;
	/**
	 * 活动类型(1满减活动 2满赠活动 3特价商品)
	 */
	private Short activityType;
	/**
	 * 同享规则(1同享 2不同享)
	 */
	private Short activityShare;
	/**
	 * 活动力度(特价商品活动时需要填写)
	 */
	private Double activityVigor;
	/**
	 * 状态(1为在用，-1为停用)
	 */
	private Short activityStatus;
	/**
	 * 活动描述
	 */
	private String activityDesc;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 活动规则
	 */
	public List<ActivityFormatVo> activityFormatVoList;
	/**
	 * 参与活动卖家
	 */
	public List<ActivitySellerVo> activitySellerVoList;
	/**
	 * 参与活动的商品
	 */
	public List<ActivityGoodsVo> activityGoodsVoList;
	
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityTitle() {
		return activityTitle;
	}
	public void setActivityTitle(String activityTitle) {
		this.activityTitle = activityTitle;
	}
	public String getActivityLogo() {
		return activityLogo;
	}
	public void setActivityLogo(String activityLogo) {
		this.activityLogo = activityLogo;
	}
	public String getActivityBeginTime() {
		return activityBeginTime;
	}
	public void setActivityBeginTime(String activityBeginTime) {
		this.activityBeginTime = activityBeginTime;
	}
	public String getActivityEndTime() {
		return activityEndTime;
	}
	public void setActivityEndTime(String activityEndTime) {
		this.activityEndTime = activityEndTime;
	}
	public Short getActivityChannel() {
		return activityChannel;
	}
	public void setActivityChannel(Short activityChannel) {
		this.activityChannel = activityChannel;
	}
	public Short getActivityType() {
		return activityType;
	}
	public void setActivityType(Short activityType) {
		this.activityType = activityType;
	}
	public Short getActivityShare() {
		return activityShare;
	}
	public void setActivityShare(Short activityShare) {
		this.activityShare = activityShare;
	}
	public Double getActivityVigor() {
		return activityVigor;
	}
	public void setActivityVigor(Double activityVigor) {
		this.activityVigor = activityVigor;
	}
	public Short getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(Short activityStatus) {
		this.activityStatus = activityStatus;
	}
	public String getActivityDesc() {
		return activityDesc;
	}
	public void setActivityDesc(String activityDesc) {
		this.activityDesc = activityDesc;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<ActivityFormatVo> getActivityFormatVoList() {
		return activityFormatVoList;
	}
	public void setActivityFormatVoList(List<ActivityFormatVo> activityFormatVoList) {
		this.activityFormatVoList = activityFormatVoList;
	}
	public List<ActivitySellerVo> getActivitySellerVoList() {
		return activitySellerVoList;
	}
	public void setActivitySellerVoList(List<ActivitySellerVo> activitySellerVoList) {
		this.activitySellerVoList = activitySellerVoList;
	}
	public List<ActivityGoodsVo> getActivityGoodsVoList() {
		return activityGoodsVoList;
	}
	public void setActivityGoodsVoList(List<ActivityGoodsVo> activityGoodsVoList) {
		this.activityGoodsVoList = activityGoodsVoList;
	}
}
