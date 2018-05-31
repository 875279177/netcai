package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.GoodsFormat;

/**
 * 商品规格Dao
 * @author administrator
 */
public interface GoodsFormatDao {

	/*
	 * 批量添加商品规格
	 */
	public int batchInsertGoodsFormat(Goods goods);
	
	/*
	 * 修改商品规格
	 */
	public int updateGoodsFormat(GoodsFormat goodsFormat);
	
	/*
	 * 复制商品规格
	 */
	public int copyGoodsFormat(@Param("newGoodsId") Long newGoodsId,@Param("oldGoodsId") Long oldGoodsId);
	
	/*
	 * 判断商品规格有没有被使用
	 */
	public Integer checkGoodsFormat(@Param("formatId") Long formatId);
	
	/*
	 * 删除商品规格 
	 */
	public int deleteGoodsFormat(@Param("formatId") Long formatId);
	
	/*
	 * 根据商品id查询商品规格
	 */
	public List<GoodsFormat> selectGoodsFormat(Long goodsId);
}
