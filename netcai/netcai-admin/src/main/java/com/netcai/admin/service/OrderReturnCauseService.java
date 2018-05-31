package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.OrderReturnCause;

public interface OrderReturnCauseService {
	
	/**
	 * 通过Id查询单个
	 */
	public OrderReturnCause getOrderReturnCauseById(Long id);
	
	/**
	 * 根据parentId
	 */
	public List<OrderReturnCause>  getOrderReturnCauseByParentId(Long id);
	
	/**
	 * 添加
	 */
	public Integer insertOrderReturnCause(OrderReturnCause orderReturnCause);
	
	/**
	 * 状态删除  根据Id删除
	 */
	public int deleteOrderReturnCause(Long id);
	
	/**
	 * 修改
	 */
	public int updateById(OrderReturnCause orderReturnCause);

	/**
	 * 通过条件查询 
	 */
	public List<OrderReturnCause> getPageResult(OrderReturnCause orderReturnCause);
	
	/**
	 * 查询所有
	 */
	public List<OrderReturnCause> getAll();
}
