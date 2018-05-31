package com.netcai.buyer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.GoodsDao;
import com.netcai.buyer.service.GoodsService;
import com.netcai.buyer.vo.CategoryGoodsVo;
import com.netcai.buyer.vo.GoodsVo;
import com.netcai.buyer.vo.NewSearchVo;
import com.netcai.buyer.vo.SearchVo;

/**
 * 商品信息serviceimpl
 * @author administrator
 */
@Service
public class GoodsServiceImpl implements GoodsService{
	
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 查询商品信息
	 * @return
	 */
	@Override
	public List<GoodsVo> getAllGoods(Long userId,Integer categoryId){
		return goodsDao.getAllGoods(userId,categoryId);
	}
	
	/**
	 * 按二级分类查找商品
	 */
	public List<CategoryGoodsVo> getAllGoodsByCategory(Long userId,Integer categoryId){
		return goodsDao.getAllGoodsByCategory(userId, categoryId);
	}
	
	/**
	 * 根据id查找商品信息
	 */
	@Override
	public GoodsVo getGoodsById(int goodsId){
		return goodsDao.getGoodsById(goodsId);
	}

	/**
	 * 搜索店铺内商品
	 */
	@Override
	public List<GoodsVo> searchGoodsBySellerId(Long userId,String keyword){
		return goodsDao.searchGoodsBySellerId(userId, keyword);
	}
	
	/**
	 * 全局搜索商品
	 */
	@Override
	public List<SearchVo> searchGoods(Long userId,Long regionId,String keyword){
		return goodsDao.searchGoods(userId,regionId,keyword);
	}
	
	/**
	 * 根据分类查找商品
	 */
	public List<SearchVo> searchGoodsByCategory(Long userId,Long regionId,String categoryCode){
		return goodsDao.searchGoodsByCategory(userId,regionId, categoryCode);
	}
	
	/**
	 * 全局搜索商品 新
	 */
	public List<NewSearchVo> newSearchGoods(Long userId,Long regionId,String keyword){
		return goodsDao.newSearchGoods(userId, regionId, keyword);
	}
	
	/**
	 * 根据分类查找商品 新
	 */
	public List<NewSearchVo> newSearchGoodsByCategory(Long userId,Long regionId,String categoryCode){
		return goodsDao.newSearchGoodsByCategory(userId, regionId, categoryCode);
	}
}
