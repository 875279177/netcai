package com.netcai.admin.dao;

import com.netcai.admin.entity.WithdrawalConfig;

/**
 * 卖家提款支付宝手续费配置Dao
 * 
 * @author administrator
 *
 */
public interface WithdrawalConfigDao {
	/**
	 * 根据卖家id查询数据
	 * @param sellerId
	 * @return
	 */
	public WithdrawalConfig selectBySellerId(Long sellerId);

}
