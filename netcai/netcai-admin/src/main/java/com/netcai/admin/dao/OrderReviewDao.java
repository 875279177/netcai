package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderReview;

/**
 * 订单评论DAO
 * @author administrator
 */
public interface OrderReviewDao {

	/**
	 * 通过Id查询单个
	 */
	public OrderReview getOrderReviewById(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<OrderReview> getOrderReview( @Param("o")OrderReview o  ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("o")OrderReview o);
	
	/**
	 * 修改review_status
	 */
	public int updateStatus(@Param("o")OrderReview o);
}