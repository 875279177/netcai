package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.vo.CategoryGoodsVo;
import com.netcai.buyer.vo.GoodsVo;
import com.netcai.buyer.vo.NewSearchVo;
import com.netcai.buyer.vo.SearchVo;

/**
 * 商品service
 * @author administrator
 */
public interface GoodsService {

	/**
	 * 查询商品信息
	 * @return
	 */
	public List<GoodsVo> getAllGoods(Long userId,Integer categoryId);
	
	/**
	 * 按二级分类查找商品
	 */
	public List<CategoryGoodsVo> getAllGoodsByCategory(Long userId,Integer categoryId);
	/**
	 * 根据id查找商品信息
	 */
	public GoodsVo getGoodsById(int goodsId);
	
	/**
	 * 搜索店铺内商品
	 */
	public List<GoodsVo> searchGoodsBySellerId(Long userId,String keyword);
	
	/**
	 * 全局搜索商品
	 */
	public List<SearchVo> searchGoods(Long userId,Long regionId,String keyword);
	
	/**
	 * 根据分类查找商品
	 */
	public List<SearchVo> searchGoodsByCategory(Long userId,Long regionId,String categoryCode);
	
	/**
	 * 全局搜索商品 新
	 */
	public List<NewSearchVo> newSearchGoods(Long userId,Long regionId,String keyword);
	
	/**
	 * 根据分类查找商品 新
	 */
	public List<NewSearchVo> newSearchGoodsByCategory(Long userId,Long regionId,String categoryCode);
	
}
