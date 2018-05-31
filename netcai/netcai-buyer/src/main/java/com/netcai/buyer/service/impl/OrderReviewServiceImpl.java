package com.netcai.buyer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.OrderReviewDao;
import com.netcai.buyer.entity.OrderReview;
import com.netcai.buyer.service.OrderReviewService;

/**
 * 商品信息serviceimpl
 * @author administrator
 */
@Service
public class OrderReviewServiceImpl implements OrderReviewService{

	@Autowired
	private OrderReviewDao orderReviewDao;
	
	/*
	 * 查找订单评论
	 */
	public List<OrderReview> getAllOrderlReview(Long orderItemId){
		return orderReviewDao.getAllOrderlReview(orderItemId);
	}
	
	/*
	 * 添加订单评论
	 */
	public long insertOrderReview(OrderReview orderReview){
		return orderReviewDao.insertOrderReview(orderReview);
	}
}
