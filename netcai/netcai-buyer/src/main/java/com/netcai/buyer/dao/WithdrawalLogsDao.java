package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.WithdrawalLogs;

/**
 * DAO
 * @author administrator
 */
public interface WithdrawalLogsDao {

	
	/**
	 * 通过条件查询 
	 * @param WithdrawalLogs 查询条件
	 * @param pageNum 分页参数
	 * @param pageSize 分页参数
	 * @return
	 */
	public List<WithdrawalLogs> getWithdrawalLogs(@Param(value="w") WithdrawalLogs w ,@Param("pageNum") int pageNum,
			@Param("pageSize") int pageSize);

	
	/**
	 * 
	 * @param 
	 * @return 查询总数
	 */
	public int getPageCount();
	
	/**
	 * 添加
	 * @param withdrawal
	 */
	public int insertWithdrawalLogs(WithdrawalLogs withdrawalLogs);
	
	
	/**
	 * 通过订单id查询多个
	 * @param 
	 * @return
	 */
	public List<WithdrawalLogs> getWithdrawalLogsByWithdrawOrder(String withdrawOrder);
	
}