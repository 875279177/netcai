package com.netcai.buyer.entity;

import java.util.Date;

/**
 * 用户建议的回复
 * 
 * @author administrator
 */
public class SuggestionReply implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 自动增加ID
	 */
	private Long id;

	/**
	 * 用户建议id
	 */
	private Long suggestionId;

	/**
	 * 给用户建议的回复
	 */
	private String replyContent;

	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSuggestionId() {
		return suggestionId;
	}

	public void setSuggestionId(Long suggestionId) {
		this.suggestionId = suggestionId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}