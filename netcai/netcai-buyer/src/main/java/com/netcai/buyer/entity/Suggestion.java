package com.netcai.buyer.entity;

import java.util.Date;
import java.util.List;

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
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 建议回复
	 */
	private List<SuggestionReply> suggestionReplies;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SuggestionReply> getSuggestionReplies() {
		return suggestionReplies;
	}

	public void setSuggestionReplies(List<SuggestionReply> suggestionReplies) {
		this.suggestionReplies = suggestionReplies;
	}

}