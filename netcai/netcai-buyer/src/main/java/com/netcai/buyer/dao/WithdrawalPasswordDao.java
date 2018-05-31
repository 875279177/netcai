package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.WithdrawalPassword;

/**
 * 卡密码管理DAO
 * @author administrator
 */
public interface WithdrawalPasswordDao {

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
	 * 通过条件查询 
	 * @param WithdrawalPassword 查询条件
	 * @param pageNum 分页参数
	 * @param pageSize 分页参数
	 * @return
	 */
	public List<WithdrawalPassword> getWithdrawalPassword(@Param(value="w") WithdrawalPassword w ,@Param("pageNum") int pageNum,
			@Param("pageSize") int pageSize);

	
	/**
	 * 
	 * @param 
	 * @return 查询总数
	 */
	public int getPageCount(@Param(value="w") WithdrawalPassword w);
	
	/**
	 * 添加
	 * @param withdrawalPasswords
	 */
	public int insertWithdrawalPassword(WithdrawalPassword withdrawalPasswords);
	
	/**
	 * 初始化密码
	 * @param withdrawalPassword
	 * @return
	 */
	public int updatePasswordWithdrawalPassword(WithdrawalPassword withdrawalPassword);
}