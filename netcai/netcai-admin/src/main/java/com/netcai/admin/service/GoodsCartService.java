package com.netcai.admin.service;

import com.netcai.admin.entity.GoodsCart;
import com.netcai.admin.utils.PageUtil;

public interface GoodsCartService {
	
	
	/**
	 * 添加
	 */
	public Integer insertGoodsCart(GoodsCart goodsCart);
	
	
	
	/**
	 *   根据Id删除
	 */
	public int deleteGoodsCart(Long id);
	
	/**
	 * 修改GoodsNumber数量
	 */
	public int updateGoodsNumber(GoodsCart goodsCart);

	/**
	 * 通过条件查询 返回Vo
	 */
	public PageUtil getPageResultList(GoodsCart goodsCart, int currentPageNum, int currentPageSize);
}
