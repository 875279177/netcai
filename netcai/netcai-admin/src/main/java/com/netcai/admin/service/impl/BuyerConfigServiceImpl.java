package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerConfigDao;
import com.netcai.admin.entity.BuyerConfig;
import com.netcai.admin.service.BuyerConfigService;

@Service
public class BuyerConfigServiceImpl implements BuyerConfigService {

	@Autowired
	private BuyerConfigDao buyerConfigDao;
	
	/**
	 * 先删除；再添加；
	 */
	@Override
	public void batchSave(List<BuyerConfig> list,Long buyerId) {
		buyerConfigDao.deleteAllByBuyerId(buyerId);
		if(list != null && list.size()>0){
			buyerConfigDao.batchSave(list);
		}
	}

	/**
	    * 根据买家ID查询所有卖家ID
	    * @param buyerId
	    * @return
	    */
	@Override
	public List<Long> getAllSellerIdByBuyerId(Long buyerId) {
		return buyerConfigDao.getAllSellerIdByBuyerId(buyerId);
	}

	
}