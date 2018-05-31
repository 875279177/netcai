package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.BuyerConfig;

public interface BuyerConfigService {
	/**
	 * 批量新增;
	 */
	public void batchSave(List<BuyerConfig> list,Long buyerId);
	
	/**
	 * 查询所有;
	 */
	public List<Long> getAllSellerIdByBuyerId(Long buyerId);
}
