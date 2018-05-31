package com.netcai.buyer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.CategoryDao;
import com.netcai.buyer.entity.Category;
import com.netcai.buyer.service.CategoryService;

/**
 * 商品分类serviceimpl
 * @author administrator
 */
@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * 取得所有的商品分类
	 */
	@Override
	public List<Category> getAllCategory(String parentId,String level) {
		return categoryDao.getAllCategory(parentId,level);
	}

	/*
	 * 查找商品分类详情
	 */
	@Override
	public Category getCategoryById(int categoryId){
		return categoryDao.getCategoryById(categoryId);
	}
}
