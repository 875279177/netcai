package com.netcai.buyer.service;

import com.netcai.buyer.entity.Withdrawal;
import com.netcai.buyer.entity.WithdrawalLogs;
import com.netcai.buyer.utils.PageUtil;

public interface WithdrawalService {
	
	/**
	 * 通过Id查询单个对象
	 * @param 
	 * @return
	 */
	public Withdrawal getWithdrawalById(Long id);
	
	/**
	 * 通过订单查询单个对象
	 * @param 
	 * @return
	 */
	public Withdrawal getWithdrawalByWithdrawOrder(String withdrawOrder);
	
	/**
	 * 申请提现
	 * @param withdrawal
	 * @param withdrawalLogs
	 * @return
	 */
	public void applyWithdrawal(Withdrawal withdrawal,WithdrawalLogs withdrawalLogs);

	/**
	 * 通过条件查询 
	 * @param withdrawal 
	 * @return
	 */
	public PageUtil getPageResult(Withdrawal withdrawal, int currentPageNum, int currentPageSize);
	
}
