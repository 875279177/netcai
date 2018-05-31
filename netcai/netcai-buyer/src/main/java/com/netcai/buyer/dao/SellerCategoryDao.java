package com.netcai.buyer.dao;

import java.util.List;

import com.netcai.buyer.entity.SellerCategory;

/**
 * 卖家商品分类Dao
 * @author administrator
 */
public interface SellerCategoryDao {

	/**
	 * 获取卖家的商品分类
	 */
	public List<SellerCategory> getSellerCategoryList(SellerCategory sellerCategory);

}
