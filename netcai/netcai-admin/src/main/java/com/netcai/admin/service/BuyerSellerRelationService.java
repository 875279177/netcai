package com.netcai.admin.service;

import com.netcai.admin.entity.BuyerSellerRelation;
import com.netcai.admin.utils.PageUtil;

/**
 */
public interface BuyerSellerRelationService {
	
	public int deleteById(Long id);

	public int insert(BuyerSellerRelation record);

	public BuyerSellerRelation selectByBuyerId(Long id);
	
	public PageUtil findList(BuyerSellerRelation buyerSellerRelation, Integer pageNum, Integer pageSize);

	public int updateById(BuyerSellerRelation buyerSellerRelation);
}
