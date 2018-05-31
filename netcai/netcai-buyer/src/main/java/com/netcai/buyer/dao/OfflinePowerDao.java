package com.netcai.buyer.dao;

import org.apache.ibatis.annotations.Param;

public interface OfflinePowerDao {
	
	/**
	 * 查询是否有权限线下付款;
	 */
	public int getCountByRegionIdOrBuyerId(@Param("buyerId")Long buyerId,@Param("regionId")Long regionId);
}