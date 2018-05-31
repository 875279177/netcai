package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.Category;

/**
 * 商品分类service
 * @author administrator
 */
public interface CategoryService {

	/*
	 * 查询所有的商品分类
	 */
	public List<Category> getAllCategory(String parentId,String level);
	
	/*
	 * 查找商品分类详情
	 */
	public Category getCategoryById(int categoryId);
}
