package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Category;

import net.sf.json.JSONArray;

/**
 * 商品分类service
 * @author administrator
 */
public interface CategoryService {
	
	/**
	 * 查询所有商品分类
	 */
	public List<Category> getAllCategory();

	/**
	 * 添加商品分类
	 */
	public int insertCategory(Category entity);

	/**
	 * 更新商品分类
	 */
	public int updateCategory(Category entity);
	
	/**
	 * 根据id查找商品分类
	 */
	public Category getCategoryById(int categoryId);
	
	/*
	 * 分类树(json格式)
	 */
	public JSONArray categoryTree(List<Category> categoryList,int parentId);
}
