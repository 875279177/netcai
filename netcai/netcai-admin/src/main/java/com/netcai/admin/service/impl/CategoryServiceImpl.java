package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.CategoryDao;
import com.netcai.admin.entity.Category;
import com.netcai.admin.service.CategoryService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 商品分类serviceimpl
 * @author administrator
 */
@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;
	
	/**
	 * 查询所有商品分类
	 */
	@Override
	public List<Category> getAllCategory(){
		return categoryDao.getAllCategory();
	}

	/**
	 * 添加商品分类
	 */
	@Override
	public int insertCategory(Category entity) {
		categoryDao.insertCategory(entity);
		List<Integer> methodList = entity.getMethodIds();
		if(null != methodList && methodList.size()>0){
			//添加商品分类的加工方式
			categoryDao.insertCategoryMethod(entity);
		}
		return entity.getCategoryId();
	}

	/**
	 * 更新商品分类
	 */
	@Override
	public int updateCategory(Category entity) {
		//删除商品分类的加工方式
		categoryDao.deleteCategoryMethod(entity);
		List<Integer> methodList = entity.getMethodIds();
		if(null != methodList && methodList.size() >0){
			//添加商品分类的加工方式
			categoryDao.insertCategoryMethod(entity);
		}
		//修改分类的信息
		int result = categoryDao.updateCategory(entity);
		return result;
	}

	/**
	 * 根据id查找商品分类
	 */
	@Override
	public Category getCategoryById(int categoryId){
		return categoryDao.getCategoryById(categoryId);
	}
	
	/*
	 * 分类树(json格式)
	 */
	@Override
	public JSONArray categoryTree(List<Category> categoryList,int parentId){
		JSONArray all = new JSONArray();
        for (Category category : categoryList) {
            JSONObject main = JSONObject.fromObject(category);
            int categoryId = main.getInt("categoryId");
            int pid = main.getInt("parentId");
            if (parentId == pid) {
                JSONArray children = categoryTree(categoryList, categoryId);
                main.put("children", children);
                all.add(main);
            }
        }
        return all;
	}
}
