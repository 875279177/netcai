package com.netcai.buyer.dao;

import java.util.List;

import com.netcai.buyer.entity.Suggestion;

public interface SuggestionDao {
	
	/**
	 * 查询买家全部建议及建议回复
	 * @param userId
	 * @return
	 */
	public List<Suggestion> selectAllByUserId(Long userId);
	
	/**
	 * 新增建议
	 * @param suggestion
	 * @return
	 */
	public int saveSuggestion(Suggestion suggestion);
	
}
