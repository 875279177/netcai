package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.SellerCategory;

/**
 * 卖家商品分类service
 * @author administrator
 */
public interface SellerCategoryService {

	/**
	 * 获取卖家的商品分类
	 */
	public List<SellerCategory> getSellerCategoryList(SellerCategory sellerCategory);
	
}
