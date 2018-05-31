package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderCancelLogs;

public interface OrderCancelLogsDao {

	/**
	 * 数量;
	 */
	public int getCount(@Param("o")OrderCancelLogs orderCancelLogs);
	
	/**
	 * 条件查询列表;
	 */
	public List<OrderCancelLogs> getList(@Param("o")OrderCancelLogs orderCancelLogs,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	/**
	 * 保存记录信息
	 */
	public void addOrderCancelLogs(OrderCancelLogs orderCancelLogs);
}
