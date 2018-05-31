package com.netcai.buyer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Category;

/**
 * 商品分类Dao
 * @author administrator
 */
public interface CategoryDao {

	/*
	 * 查询所有的商品分类
	 */
	public List<Category> getAllCategory(@Param("parentId") String parentId,@Param("level") String level);
	
	/*
	 * 查找商品分类详情
	 */
	public Category getCategoryById(@Param("categoryId") int categoryId);
}
