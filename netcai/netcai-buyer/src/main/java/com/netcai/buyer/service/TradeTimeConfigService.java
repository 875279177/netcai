package com.netcai.buyer.service;

import com.netcai.buyer.entity.TradeTimeConfig;


/**
 * 交易时间配置Dao
 * @author administrator
 *
 */
public interface TradeTimeConfigService {
	
	/**
	 * 根据区域 id查询交易时间
	 * @param regionId
	 * @return
	 */
	public TradeTimeConfig getByRegionId(Long regionId);

}
