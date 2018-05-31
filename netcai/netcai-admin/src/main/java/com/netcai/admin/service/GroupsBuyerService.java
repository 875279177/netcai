package com.netcai.admin.service;

import com.netcai.admin.entity.GroupsBuyer;
import com.netcai.admin.utils.PageUtil;
/**
 */
public interface GroupsBuyerService {
	
	/**
	 *查询列表; 
	 */
	public PageUtil getPageResult(GroupsBuyer groupsBuyer, Integer PageNum, Integer PageSize);
	
	/**
	 *团购定时器
	 */
	public void schedulingGroups();
}
