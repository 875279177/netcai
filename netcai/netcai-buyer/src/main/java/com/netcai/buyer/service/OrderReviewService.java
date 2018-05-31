package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.OrderReview;

/**
 * 订单评论service
 * @author administrator
 */
public interface OrderReviewService {

	/*
	 * 查找订单评论
	 */
	public List<OrderReview> getAllOrderlReview(Long orderItemId);
	
	/*
	 * 添加订单评论
	 */
	public long insertOrderReview(OrderReview orderReview);
}
