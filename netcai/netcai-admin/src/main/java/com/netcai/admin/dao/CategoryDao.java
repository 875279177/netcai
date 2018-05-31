package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Category;

/**
 * 商品分类Dao
 * @author administrator
 */
public interface CategoryDao {
	
	/**
	 * 查询所有商品分类
	 */
	public List<Category> getAllCategory();

	/**
	 * 添加商品分类
	 */
	public int insertCategory(Category entity);
	
	/**
	 * 添加商品分类的加工方式
	 */
	public int insertCategoryMethod(Category entity);
	
	/**
	 * 删除商品分类的加工方式
	 */
	public int deleteCategoryMethod(Category entity);

	/**
	 * 更新商品分类
	 */
	public int updateCategory(Category entity);
	
	/**
	 * 根据id查找商品分类
	 */
	public Category getCategoryById(@Param("categoryId") int categoryId);
	
	/**
	 * 查询顶级商品分类
	 * @return
	 */
	public List<Map<String, Object>> getCategorysTopLevel();
}
