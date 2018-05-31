package com.netcai.admin.service;

import com.netcai.admin.entity.OrderCancelLogs;
import com.netcai.admin.utils.PageUtil;

public interface OrderCancelLogsService {
	
	/**
	 * 分页查询
	 */
	public PageUtil getAll(OrderCancelLogs orderCancelLogs, Integer pageNum, Integer pageSize);
	
}
