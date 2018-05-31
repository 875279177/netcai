package com.netcai.buyer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.OrderReview;

/**
 * 订单评论Dao
 * @author administrator
 */
public interface OrderReviewDao {

	/*
	 * 查找订单评论
	 */
	public List<OrderReview> getAllOrderlReview(@Param("orderItemId") Long orderItemId);
	
	/*
	 * 添加订单评论
	 */
	public long insertOrderReview(OrderReview orderReview);
}
