package com.netcai.admin.service;

import com.netcai.admin.entity.OrderReview;
import com.netcai.admin.utils.PageUtil;

public interface OrderReviewService {
	
	
	/**
	 * 通过Id查询单个
	 */
	public OrderReview getOrderReviewById(Long id);
	
	/**
	 * 修改review_status
	 */
	public int updateStatus(OrderReview orderReview);

	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(OrderReview orderReview, int currentPageNum, int currentPageSize);
	
}
