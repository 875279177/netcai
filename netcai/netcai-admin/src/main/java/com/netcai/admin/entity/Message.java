package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息
 * @author administrator
 */
public class Message implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private Long msgId;

	/**
	 * 所属用户
	 */
	private Long userId;
	
	/**
	 * 消息标题
	 */
	private String msgName;
	
	/**
	 * 消息内容
	 */
	private String msgContent;
	
	/**
	 * 状态，1为可见，-1为不可见
	 */
	private int status;
	
	/**
	 * 消息类型，1，通知，2 降价，3，促销等
	 */
	private int msgType;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMsgName() {
		return msgName;
	}

	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public int getMsgType() {
		return msgType;
	}

	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	/*******************************************query************************************************************/
	
	/**
	 * 时间开始;
	 */
	private String createTimeStart;
	
	/**
	 * 时间结束;
	 */
	private String createTimeStop;

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStop() {
		return createTimeStop;
	}

	public void setCreateTimeStop(String createTimeStop) {
		this.createTimeStop = createTimeStop;
	}
	
	/**
	 * 账号
	 */
	private String account;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	/**
	 * 用户类型;
	 */
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 店铺名称
	 */
	private String  shopName;

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
}