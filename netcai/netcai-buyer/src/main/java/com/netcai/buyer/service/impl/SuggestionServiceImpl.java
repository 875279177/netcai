package com.netcai.buyer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.SuggestionDao;
import com.netcai.buyer.entity.Suggestion;
import com.netcai.buyer.service.SuggestionService;

@Service
public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	private SuggestionDao suggestionDao;
	
	/**
	 * 查询买家全部建议及建议回复
	 */
	@Override
	public List<Suggestion> selectAllByUserId(Long userId) {
		return suggestionDao.selectAllByUserId(userId);
	}

	/**
	 * 新增买家建议
	 */
	@Override
	public int saveSuggestion(Suggestion suggestion) {
		return suggestionDao.saveSuggestion(suggestion);
	}

}