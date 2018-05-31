package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.Suggestion;

public interface SuggestionService {
	
	/**
	 * 查询买家的全部建议及建议回复
	 * @param userId
	 * @return
	 */
	public List<Suggestion> selectAllByUserId(Long userId);
	
	public int saveSuggestion(Suggestion suggestion);
	
}
