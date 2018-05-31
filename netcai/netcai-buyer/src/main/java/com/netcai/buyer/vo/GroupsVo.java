package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 团购活动
 * @author administrator
 */
public class GroupsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long groupId;
	/**
	 * 团购活动编号
	 */
	private String groupNo;
	/**
	 * 团购活动标题
	 */
	private String groupTitle;
	/**
	 * 团购活动图片
	 */
	private String groupLogo;
	/**
	 * 开始时间
	 */
	private String beginTime;
	/**
	 * 结束时间
	 */
	private String endTime;
	/**
	 * 最大买家数量
	 */
	private Integer maxNum;
	/**
	 * 起团金额(买家参团的最低消费金额)
	 */
	private BigDecimal buyerAmt;
	/**
	 * 开团金额(团购活动的总金额)
	 */
	private BigDecimal minAmt;
	/**
	 * 有效状态(1团成 -1未团成)
	 */
	private Integer status;
	/**
	 * 已参团买家数
	 */
	private Integer joinNum;
	/**
	 * 剩余金额
	 */
	private BigDecimal laveAmt;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 团购商品
	 */
	private List<GroupsItemVo> itemList;
	
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	public String getGroupTitle() {
		return groupTitle;
	}
	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}
	public String getGroupLogo() {
		return groupLogo;
	}
	public void setGroupLogo(String groupLogo) {
		this.groupLogo = groupLogo;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	public BigDecimal getBuyerAmt() {
		return buyerAmt;
	}
	public void setBuyerAmt(BigDecimal buyerAmt) {
		this.buyerAmt = buyerAmt;
	}
	public BigDecimal getMinAmt() {
		return minAmt;
	}
	public void setMinAmt(BigDecimal minAmt) {
		this.minAmt = minAmt;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getJoinNum() {
		return joinNum;
	}
	public void setJoinNum(Integer joinNum) {
		this.joinNum = joinNum;
	}
	public BigDecimal getLaveAmt() {
		return laveAmt;
	}
	public void setLaveAmt(BigDecimal laveAmt) {
		this.laveAmt = laveAmt;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<GroupsItemVo> getItemList() {
		return itemList;
	}
	public void setItemList(List<GroupsItemVo> itemList) {
		this.itemList = itemList;
	}
}
