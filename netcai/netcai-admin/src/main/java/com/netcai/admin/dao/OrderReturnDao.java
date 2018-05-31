package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderReturn;

/**
 * 商品退货DAO
 * @author administrator
 */
public interface OrderReturnDao {

	/**
	 * 通过Id查询单个
	 */
	public OrderReturn getOrderReturnById(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<OrderReturn> getOrderReturn( @Param("o")OrderReturn o  ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("o")OrderReturn o);
	
}