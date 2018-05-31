package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.OrderReturnDao;
import com.netcai.admin.entity.OrderReturn;
import com.netcai.admin.service.OrderReturnService;
import com.netcai.admin.utils.PageUtil;

/**
 * @author administrator
 */

@Service
public class OrderReturnServiceImpl implements OrderReturnService {

	@Autowired
	private OrderReturnDao orderReturnDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public OrderReturn getOrderReturnById(Long id) {
		return orderReturnDao.getOrderReturnById(id);
	}


	/**
	 * 通过条件查询 
	 */
	@Override
	public PageUtil getPageResult(OrderReturn orderReturn, int currentPageNum, int currentPageSize) {
		
		int size = orderReturnDao.getPageCount(orderReturn);

		int offset = currentPageNum > 1 ? (currentPageNum - 1) * currentPageSize : 0;
		
		List<OrderReturn> result = orderReturnDao.getOrderReturn(orderReturn, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}

}