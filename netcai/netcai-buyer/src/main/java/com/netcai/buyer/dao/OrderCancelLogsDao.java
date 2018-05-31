package com.netcai.buyer.dao;

import com.netcai.buyer.entity.OrderCancelLogs;

public interface OrderCancelLogsDao {

	/**
	 * 保存记录信息
	 * @return
	 */
	public int addOrderCancelLogs(OrderCancelLogs orderCancelLogs);
	
}
