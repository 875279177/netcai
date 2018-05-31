package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.WithdrawalBank;

public interface WithdrawalBankService {
	
	/**
	 * 通过Id查询单个
	 * @param 
	 * @return
	 */
	public WithdrawalBank getWithdrawalBankById(Long id);
	
	/**
	 * 通过uid查询单个
	 * @param 
	 * @return
	 */
	public List<WithdrawalBank> getWithdrawalBankByUid(Long id);
	
	/**
	 * 添加
	 * @param withdrawalBank
	 */
	public int insertWithdrawalBank(WithdrawalBank withdrawalBank);
	
	/**
	 * 通过条件查询 
	 * @param withdrawalBank 
	 * @return
	 */
	public List<WithdrawalBank> getResult(WithdrawalBank withdrawalBank);
}
