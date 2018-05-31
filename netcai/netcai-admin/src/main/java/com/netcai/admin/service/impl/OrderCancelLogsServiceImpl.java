package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.OrderCancelLogsDao;
import com.netcai.admin.entity.OrderCancelLogs;
import com.netcai.admin.service.OrderCancelLogsService;
import com.netcai.admin.utils.PageUtil;

/**
 * service实现
 */
@Service
public class OrderCancelLogsServiceImpl implements OrderCancelLogsService{
	
	@Autowired 
	private OrderCancelLogsDao orderCancelLogsDao;

	@Override
	public PageUtil getAll(OrderCancelLogs orderCancelLogs, Integer pageNum, Integer pageSize) {
		
		int size = orderCancelLogsDao.getCount(orderCancelLogs);
		
		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		if (size < offset) {
			offset = 0;
		}
		List<OrderCancelLogs> result = orderCancelLogsDao.getList(orderCancelLogs, offset, pageSize);
		
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

}
