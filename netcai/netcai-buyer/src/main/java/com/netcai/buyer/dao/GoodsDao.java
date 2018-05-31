package com.netcai.buyer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.vo.CategoryGoodsVo;
import com.netcai.buyer.vo.GoodsVo;
import com.netcai.buyer.vo.NewSearchVo;
import com.netcai.buyer.vo.SearchVo;

/**
 * 商品Dao
 * @author administrator
 */
public interface GoodsDao {

	/**
	 * 查询商品信息
	 * @return
	 */
	public List<GoodsVo> getAllGoods(@Param("userId") Long userId,@Param("categoryId") Integer categoryId);
	/**
	 * 按二级分类查找商品
	 */
	public List<CategoryGoodsVo> getAllGoodsByCategory(@Param("userId") Long userId,@Param("categoryId") Integer categoryId);
	
	/**
	 * 根据id查找商品信息
	 */
	public GoodsVo getGoodsById(@Param("goodsId") int goodsId);
	
	/**
	 * 搜索店铺内商品
	 */
	public List<GoodsVo> searchGoodsBySellerId(@Param("userId") Long userId,@Param("keyword") String keyword);
	
	/**
	 * 全局搜索商品
	 */
	public List<SearchVo> searchGoods(@Param("userId") Long userId,@Param("regionId") Long regionId,@Param("keyword") String keyword);
	
	/**
	 * 根据分类查找商品
	 */
	public List<SearchVo> searchGoodsByCategory(@Param("userId") Long userId,@Param("regionId") Long regionId,@Param("categoryCode") String categoryCode);
	
	/**
	 * 全局搜索商品 新
	 */
	public List<NewSearchVo> newSearchGoods(@Param("userId") Long userId,@Param("regionId") Long regionId,@Param("keyword") String keyword);
	
	/**
	 * 根据分类查找商品 新
	 */
	public List<NewSearchVo> newSearchGoodsByCategory(@Param("userId") Long userId,@Param("regionId") Long regionId,@Param("categoryCode") String categoryCode);
}
