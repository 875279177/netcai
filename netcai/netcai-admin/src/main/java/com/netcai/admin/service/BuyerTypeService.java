package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.BuyerType;

public interface BuyerTypeService {
	
	/**
	 * 查询所有买家类型
	 * @return
	 */
	public List<BuyerType> getAllBuyerType();

}
