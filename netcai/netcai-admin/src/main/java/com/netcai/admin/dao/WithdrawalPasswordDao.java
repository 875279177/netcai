package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.WithdrawalPassword;

/**
 * 卡密码管理DAO
 * @author administrator
 */
public interface WithdrawalPasswordDao {

	/**
	 * 通过Id查询单个
	 */
	public WithdrawalPassword getWithdrawalPasswordByKey(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<WithdrawalPassword> getWithdrawalPassword(@Param(value="w") WithdrawalPassword w ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount(@Param(value="w") WithdrawalPassword w);
	
	/**
	 * 添加
	 */
	public int insertWithdrawalPassword(WithdrawalPassword withdrawalPasswords);
	
	/**
	 * 初始化密码
	 */
	public int updatePasswordWithdrawalPassword(WithdrawalPassword withdrawalPassword);
}