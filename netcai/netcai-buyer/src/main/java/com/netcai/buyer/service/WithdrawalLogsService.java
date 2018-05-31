package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.WithdrawalLogs;

public interface WithdrawalLogsService {
	
	
	
	/**
	 * 通过订单id查询多个
	 * @param 
	 * @return
	 */
	public List<WithdrawalLogs> getWithdrawalLogsByWithdrawOrder(String withdrawOrder);
	
	/**
	 * 添加
	 * @param withdrawal
	 */
	public int insertWithdrawalLogs(WithdrawalLogs withdrawalLogs);
}
