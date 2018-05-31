package com.netcai.buyer.service;

import com.netcai.buyer.entity.WithdrawalPassword;
import com.netcai.buyer.utils.PageUtil;

public interface WithdrawalPasswordService {
	
	/**
	 * 通过Id查询单个
	 * @param 
	 * @return
	 */
	public WithdrawalPassword getWithdrawalPasswordById(Long id);
	
	/**
	 * 通过Uid查询单个
	 * @param 
	 * @return
	 */
	public WithdrawalPassword getWithdrawalPasswordByUid(Long id);
	
	/**
	 * 添加
	 * @param WithdrawalPassword
	 */
	public int insertWithdrawalPassword(WithdrawalPassword withdrawalPassword);
	
	

	/**
	 * 通过条件查询 
	 * @param WithdrawalPassword 
	 * @return
	 */
	public PageUtil getPageResult(WithdrawalPassword withdrawalPassword, int currentPageNum, int currentPageSize);
	
	/**
	 * 初始化密码
	 * @param withdrawalPassword
	 * @return
	 */
	public int updatePasswordWithdrawalPassword(WithdrawalPassword withdrawalPassword);
}
