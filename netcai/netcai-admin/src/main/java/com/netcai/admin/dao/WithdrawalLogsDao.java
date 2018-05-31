package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.WithdrawalLogs;

/**
 * DAO
 * @author administrator
 */
public interface WithdrawalLogsDao {

	
	/**
	 * 通过条件查询 
	 */
	public List<WithdrawalLogs> getWithdrawalLogs(@Param(value="w") WithdrawalLogs w ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount();
	
	/**
	 * 添加
	 */
	public int insertWithdrawalLogs(WithdrawalLogs withdrawalLogs);
	
	/**
	 * 通过订单id查询多个
	 */
	public List<WithdrawalLogs> getWithdrawalLogsByWithdrawOrder(String withdrawOrder);
	
}