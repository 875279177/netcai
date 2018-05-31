package com.netcai.admin.entity;

import java.util.Date;

/**
 * 用户对平台的建议回复
 */
public class SuggestionReply implements java.io.Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -417786064536288215L;

	private Long id;

	/**
	 * 建议ID
	 */
    private Long suggestionId;
    /**
	 * 回复的内容
	 */
    private String content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}