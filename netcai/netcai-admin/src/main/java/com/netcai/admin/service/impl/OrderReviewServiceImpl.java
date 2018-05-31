package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.OrderReviewDao;
import com.netcai.admin.entity.OrderReview;
import com.netcai.admin.service.OrderReviewService;
import com.netcai.admin.utils.PageUtil;

/**
 * @author administrator
 */
@Service
public class OrderReviewServiceImpl implements OrderReviewService {

	@Autowired
	private OrderReviewDao orderReviewDao;
	

	/**
	 * 通过Id查询单个
	 */
	@Override
	public OrderReview getOrderReviewById(Long id) {
		return orderReviewDao.getOrderReviewById(id);
	}


	/**
	 * 通过条件查询 
	 */
	@Override
	public PageUtil getPageResult(OrderReview orderReview, int currentPageNum, int currentPageSize) {
		
		
		int size = orderReviewDao.getPageCount(orderReview);

		int offset = currentPageNum > 1 ? (currentPageNum - 1) * currentPageSize : 0;
		
		List<OrderReview> result = orderReviewDao.getOrderReview(orderReview, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}


	/**
	 * 修改review_status
	 * @param OrderReview
	 */
	@Override
	public int updateStatus(OrderReview orderReview) {
		return orderReviewDao.updateStatus(orderReview);
	}


	
}