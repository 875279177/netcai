package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SellerCategory;

/**
 * 卖家商品分类Dao
 * @author administrator
 */
public interface SellerCategoryDao {
	
	/**
	 * 取得商家的商品分类
	 */
	public List<SellerCategory> getSellerCategoryList(@Param("userId") Long userId,@Param("level") Short level);

	/**
	 * 批量新增商家分类
	 */
	public int batchInsertSellerCategory(@Param("scList") List<SellerCategory> scList);
	
	/**
	 * 删除商家分类
	 */
	public int deleteSellerCategory(@Param("userId") Long userId);
}
