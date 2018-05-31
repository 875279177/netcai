package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SuggestionDao;
import com.netcai.admin.entity.Suggestion;
import com.netcai.admin.service.SuggestionService;
import com.netcai.admin.utils.PageUtil;


/**
 * 用户建议serviceImpl
 * @author administrator
 */
@Service
public class SuggestionServiceImpl implements SuggestionService {

	@Autowired
	private SuggestionDao suggestionDao;
	
	/**
	 * 分页查询建议信息
	 */
	@Override
	public PageUtil getAll(Suggestion suggestion, int pageNum, int pageSize) {
		int size = suggestionDao.getPageCount(suggestion);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<Suggestion> result = suggestionDao.getAll(suggestion, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

}