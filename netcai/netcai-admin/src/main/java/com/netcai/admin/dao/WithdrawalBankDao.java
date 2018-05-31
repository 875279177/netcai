package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.WithdrawalBank;

/**
 * 用户银行DAO
 * @author administrator
 */
public interface WithdrawalBankDao {

	/**
	 * 通过Id查询单个
	 */
	public WithdrawalBank getWithdrawalBankByKey(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<WithdrawalBank> getWithdrawalBank(@Param(value="w") WithdrawalBank w ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

	
	/**
	 * @return 查询总数
	 */
	public int getPageCount(@Param(value="w") WithdrawalBank w);
	
	/**
	 * 添加
	 */
	public int insertWithdrawalBank(WithdrawalBank withdrawalBank);
}