package com.netcai.admin.entity;

import java.util.Date;

/**
 * 用户对平台的建议
 * 
 * @author administrator
 */
public class Suggestion implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	private Long id;

	/**
	 * 建议的内容
	 */
	private String suggestionContent;

	/**
	 * 建议的图片
	 */
	private String suggestionImgs;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户账号
	 */
	private String account;
	/**
	 * 用户类型
	 */
	private Integer type;

	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 开始时间
	 */
	private Date startTime;
	/**
	 * 结束时间
	 */
	private Date endTime;
	/**
	 * 店铺名称
	 */
	private String  shopName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSuggestionContent() {
		return suggestionContent;
	}

	public void setSuggestionContent(String suggestionContent) {
		this.suggestionContent = suggestionContent;
	}

	public String getSuggestionImgs() {
		return suggestionImgs;
	}

	public void setSuggestionImgs(String suggestionImgs) {
		this.suggestionImgs = suggestionImgs;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

}