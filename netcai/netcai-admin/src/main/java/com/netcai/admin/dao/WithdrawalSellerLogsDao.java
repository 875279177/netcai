package com.netcai.admin.dao;

import com.netcai.admin.entity.WithdrawalSellerLogs;

/**
 * 提现平台补手续费记录Dao
 * @author administrator
 *
 */
public interface WithdrawalSellerLogsDao {
	
	/**
	 * 新增数据
	 * @param withdrawalSellerLogs
	 * @return
	 */
	public int insert(WithdrawalSellerLogs withdrawalSellerLogs); 

}
