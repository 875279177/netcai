package com.netcai.buyer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.BuyerTypeDao;
import com.netcai.buyer.entity.BuyerType;
import com.netcai.buyer.service.BuyerTypeService;

@Service
public class BuyerTypeServiceImpl implements BuyerTypeService {

	@Autowired
	private BuyerTypeDao buyerTypeDao;
	
	@Override
	public List<BuyerType> getAllBuyerType() {
		return buyerTypeDao.getAllBuyerType();
	}
}