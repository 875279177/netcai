package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderReturnCause;

/**
 * 商品退货DAO
 * @author administrator
 */
public interface OrderReturnCauseDao {

	/**
	 * 通过Id查询单个
	 */
	public OrderReturnCause getOrderReturnCauseById(Long id);
	
	/**
	 * 根据parentId
	 */
	public List<OrderReturnCause>  getOrderReturnCauseByParentId(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<OrderReturnCause> getOrderReturnCause( @Param("o")OrderReturnCause o);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("o")OrderReturnCause o);
	
	/**
	 * 添加
	 */
	public int insertOrderReturnCause(OrderReturnCause orderReturnCause);
	
	/**
	 * 逻辑删除
	 */
	public int updateStatus(Long id);
	
	/**
	 * 修改
	 */
	public int updateById(@Param("o")OrderReturnCause o);
	
	/**
	 * 查询所有
	 */
	public List<OrderReturnCause>  getAll();
}