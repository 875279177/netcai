package com.netcai.admin.service;

import com.netcai.admin.entity.WithdrawalBank;
import com.netcai.admin.utils.PageUtil;

public interface WithdrawalBankService {
	
	/**
	 * 通过Id查询单个
	 */
	public WithdrawalBank getWithdrawalBankByKey(Long id);
	
	/**
	 * 添加
	 * @param withdrawalBank
	 */
	public void insertWithdrawalBank(WithdrawalBank withdrawalBank);
	
	

	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(WithdrawalBank withdrawalBank, int currentPageNum, int currentPageSize);
}
