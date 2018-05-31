package com.netcai.buyer.service;

/**
 */
public interface OfflinePowerService {
	
	/**
	 * 查询是否有权限;
	 */
	public int getCountByRegionIdOrBuyerId(Long buyerId,Long regionId);

}
