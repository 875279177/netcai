package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.GoodsCart;
import com.netcai.buyer.vo.GoodsCartVo;
import com.netcai.buyer.vo.ProductVo;

public interface GoodsCartService {
	
	
	/**
	 * 先查再新增
	 * @param GoodsCart
	 */
	public Integer insertGoodsCart(GoodsCart goodsCart);
	
	/**
	 *   根据Id删除
	 * @param id
	 * @return 
	 */
	public int deleteGoodsCart(Long id);
	
	/**
	 *   删除买家在当前店铺的购物车 
	 * @param id
	 * @return 
	 */
	public int commitCartByBuyerIdSellerId(List<GoodsCart> lists,Long buyerId,Long sellerId);
	
	/**
	 * 修改GoodsNumber数量
	 * @param GoodsCart
	 */
	public int updateAndInsertGoodsCart(GoodsCart goodsCart);

	/**
	 * 先查再新增
	 * @param GoodsCart
	 */
	public int updateGoodsCart(GoodsCart goodsCart);
	
	/**
	 * 通过条件查询 返回Vo
	 * @param GoodsCart 
	 * @return
	 */
	public List<GoodsCart> getGoodsCart(Long buyerId);
	
	/**
	 * 查询当前买家在商家店铺购物车所有商品 
	 * @return
	 */
	public List<ProductVo> getGoodsCartListBySellerId(Long buyerId,Long sellerId);
	
	/**
	 * 通过条件查询 返回Vo
	 * @return
	 */
	public List<GoodsCartVo> getGoodsCartBuyerId(Long buyerId);
	
	/**
	 * 提交购物车
	 * @param GoodsCart
	 */
	public int commitCart(List<GoodsCart> lists,Long userId);
	

}
