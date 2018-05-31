package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 消息
 * @author administrator
 */
public class MessageVo implements Serializable{

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
	 * 创建时间
	 */
	private String createTime;

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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}