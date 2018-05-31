package com.netcai.buyer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.GoodsFormatDao;
import com.netcai.buyer.entity.GoodsFormat;
import com.netcai.buyer.service.GoodsFormatService;

/**
 *sku
 *serviceimpl
 * @author administrator
 */
@Service
public class GoodsFormatServiceImpl implements GoodsFormatService{
	
	@Autowired
	private GoodsFormatDao goodsFormatDao;

	@Override
	public GoodsFormat getGoodsFormatById(Long formatId) {
		return goodsFormatDao.getById(formatId);
	}
	

	



}
