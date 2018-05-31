package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.WithdrawalBank;

/**
 * 用户银行DAO
 * @author administrator
 */
public interface WithdrawalBankDao {

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
	 * 通过条件查询 
	 * @param WithdrawalBank 查询条件
	 * @param pageNum 分页参数
	 * @param pageSize 分页参数
	 * @return
	 */
	public List<WithdrawalBank> getWithdrawalBank(@Param(value="w") WithdrawalBank w);

	
	/**
	 * 添加
	 * @param withdrawal
	 */
	public int insertWithdrawalBank(WithdrawalBank withdrawalBank);
}