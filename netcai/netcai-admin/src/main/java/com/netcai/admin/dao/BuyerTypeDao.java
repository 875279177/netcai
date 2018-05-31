package com.netcai.admin.dao;

import java.util.List;

import com.netcai.admin.entity.BuyerType;

public interface BuyerTypeDao {
	
	/**
	 * 查询所有买家类型
	 * @return
	 */
	public List<BuyerType> getAllBuyerType();
}
