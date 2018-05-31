package com.netcai.admin.service;

import com.netcai.admin.entity.OrderReturn;
import com.netcai.admin.utils.PageUtil;

public interface OrderReturnService {
	
	/**
	 * 通过Id查询单个
	 */
	public OrderReturn getOrderReturnById(Long id);
	

	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(OrderReturn orderReturn, int currentPageNum, int currentPageSize);
}
