package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.SellerCategory;

/**
 * 商家分类信息service
 * @author administrator
 */
public interface SellerCategoryService {

	/**
	 * 取得商家的商品分类
	 */
	public List<SellerCategory> getSellerCategoryList(Long userId,Short level);

	/**
	 * 批量新增商家分类
	 */
	public int batchInsertSellerCategory(Long userId,List<SellerCategory> scList);
}
