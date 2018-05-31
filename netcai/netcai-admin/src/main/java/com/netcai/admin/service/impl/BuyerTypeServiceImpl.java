package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerTypeDao;
import com.netcai.admin.entity.BuyerType;
import com.netcai.admin.service.BuyerTypeService;

@Service
public class BuyerTypeServiceImpl implements BuyerTypeService{
	@Autowired
	private BuyerTypeDao buyerTypeDao;
	
	@Override
	public List<BuyerType> getAllBuyerType() {
		return buyerTypeDao.getAllBuyerType();
	}
	
}
