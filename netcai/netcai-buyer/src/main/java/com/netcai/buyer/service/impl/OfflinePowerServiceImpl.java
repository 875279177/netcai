package com.netcai.buyer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.OfflinePowerDao;
import com.netcai.buyer.service.OfflinePowerService;

/**
 *
 */

@Service
public class OfflinePowerServiceImpl implements OfflinePowerService{
	
	@Autowired
	private OfflinePowerDao offlinePowerDao;

	@Override
	public int getCountByRegionIdOrBuyerId(Long buyerId, Long regionId) {
		return offlinePowerDao.getCountByRegionIdOrBuyerId(buyerId, regionId);
	}
}
