package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.WithdrawalLogs;

public interface WithdrawalLogsService {
	
	
	
	/**
	 * 通过订单id查询多个
	 */
	public List<WithdrawalLogs> getWithdrawalLogsByWithdrawOrder(String withdrawOrder);
	
	/**
	 * 添加
	 */
	public int insertWithdrawalLogs(WithdrawalLogs withdrawalLogs);
}
