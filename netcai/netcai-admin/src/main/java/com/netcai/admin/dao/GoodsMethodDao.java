package com.netcai.admin.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Goods;

/**
 * 商品加工方式Dao
 * @author administrator
 */
public interface GoodsMethodDao {

	/*
	 * 批量添加商品加工方式
	 */
	public int batchInsertGoodsMethod(Goods goods);
	
	/*
	 * 删除商品的加工方式
	 */
	public int deleteGoodsMethod(Goods goods);
	
	/*
	 * 复制商品的加工方式
	 */
	public int copyGoodsMethod(@Param("newGoodsId") Long newGoodsId,@Param("oldGoodsId") Long oldGoodsId);
}
