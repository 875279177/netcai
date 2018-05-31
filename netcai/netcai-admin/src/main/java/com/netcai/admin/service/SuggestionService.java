package com.netcai.admin.service;

import com.netcai.admin.entity.Suggestion;
import com.netcai.admin.utils.PageUtil;

/**
 * 用户建议service
 * @author administrator
 *
 */
public interface SuggestionService {
	
	/**
	 * 分页查询买家信息
	 * 
	 * @param suggestion
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(Suggestion suggestion,int pageNum,int pageSize);

}
