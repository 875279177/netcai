package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SuggestionReplyDao;
import com.netcai.admin.entity.SuggestionReply;
import com.netcai.admin.service.SuggestionReplyService;

@Service
public class SuggestionReplyServiceImpl implements SuggestionReplyService {

	@Autowired
	private SuggestionReplyDao suggestionReplyDao;
	
	@Override
	public List<SuggestionReply> getList(Long suggestionId) {
		return suggestionReplyDao.getList(suggestionId);
	}

	@Override
	public int insert(SuggestionReply suggestionReply) {
		return suggestionReplyDao.insert(suggestionReply);
	}

}