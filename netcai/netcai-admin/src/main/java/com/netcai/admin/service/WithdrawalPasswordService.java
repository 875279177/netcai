package com.netcai.admin.service;

import com.netcai.admin.entity.WithdrawalPassword;
import com.netcai.admin.utils.PageUtil;

public interface WithdrawalPasswordService {
	
	/**
	 * 通过Id查询单个
	 */
	public WithdrawalPassword getWithdrawalPasswordByKey(Long id);
	
	/**
	 * 添加
	 */
	public void insertWithdrawalPassword(WithdrawalPassword withdrawalPassword);
	
	

	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(WithdrawalPassword withdrawalPassword, int currentPageNum, int currentPageSize);
	
	/**
	 * 初始化密码
	 */
	public int updatePasswordWithdrawalPassword(WithdrawalPassword withdrawalPassword);
}
