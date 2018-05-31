package com.netcai.admin.service;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.admin.entity.Withdrawal;
import com.netcai.admin.entity.WithdrawalLogs;
import com.netcai.admin.utils.PageUtil;

public interface WithdrawalService {
	
	/**
	 * 通过Id查询单个
	 */
	public Withdrawal getWithdrawalByKey(Long id);
	
	/**
	 * 添加
	 */
	public int insertWithdrawal(Withdrawal withdrawal);
	
	/**
	 * 修改Status
	 */
	public void updateStatus(Withdrawal w ,WithdrawalLogs withdrawalLogs,Long sellerId,BigDecimal withdrawApplyTotal);

	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(Withdrawal withdrawal, int currentPageNum, int currentPageSize);
	
	/**
	 * 通过订单id查询多个
	 */
	public List<Withdrawal> getWithdrawalByWithdrawOrder(String withdrawOrder);
}