package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerSellerRelation;

public interface BuyerSellerRelationDao {
    
	public int deleteById(Long id);

	public int insert(BuyerSellerRelation record);

	public BuyerSellerRelation selectByBuyerId(@Param("buyerId")Long buyerId);
	
	public int findCount(@Param("b")BuyerSellerRelation buyerSellerRelation);
	
	public List<BuyerSellerRelation> findList(@Param("b")BuyerSellerRelation buyerSellerRelation,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

	public int updateById(BuyerSellerRelation buyerSellerRelation);
}