package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.SuggestionReply;

/**
 * 用户对平台的建议回复
 */
public interface SuggestionReplyService {
	
	/**
	 * 查询信息
	 */
	public List<SuggestionReply> getList(Long suggestionId);
	
	/**
	 * 添加
	 */
	public int insert(SuggestionReply suggestionReply);
}
