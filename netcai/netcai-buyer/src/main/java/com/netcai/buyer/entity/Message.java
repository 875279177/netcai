package com.netcai.buyer.entity;

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
	 * 消息类型，1，通知，2 降价，3，促销等
	 */
	private int msgType;
	
	/**
	 * 状态，1为可见，-1为不可见
	 */
	private int status;

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
}