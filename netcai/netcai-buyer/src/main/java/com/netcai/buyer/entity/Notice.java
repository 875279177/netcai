package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知
 * @author administrator
 */
public class Notice implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Long id;
	
	/**
	 * 买家ID
	 */
	public Long buyerId;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 状态，0为未读，1为已读
	 */
	private int status;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 读取时间
	 */
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}