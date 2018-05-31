package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.GoodsCart;
import com.netcai.buyer.vo.GoodsCartVo;
import com.netcai.buyer.vo.ProductVo;

/**
 * 购物车DAO
 * @author administrator
 */
public interface GoodsCartDao {

	

	/**
	 * 
	 * @return
	 */
	public List<GoodsCart> getGoodsCartList( Long buyerId);
	
	/**
	 * 查询当前买家在商家店铺购物车所有商品 
	 * @return
	 */
	public List<ProductVo> getGoodsCartListBySellerId( @Param("buyerId")Long buyerId,@Param("sellerId")Long sellerId);
	
	
	/**
	 * 查询当前买家购物车所有商品
	 * @return
	 */
	public List<GoodsCartVo> getGoodsCartListByBuyerId( Long buyerId);
	
	/**
	 * 添加
	 * @param GoodsCart
	 */
	public int insertGoodsCart(GoodsCart goodsCart);
	
	/**
	 * 批量	添加 
	 * @param GoodsCart
	 */
	public int insertGoodsCartBatch(@Param("list")List<GoodsCart> list);
	
	/**
	 * 添加前先判断是否存在否则新增;
	 * @param GoodsCart
	 */
	public int insertGoodsCartSelect(GoodsCart goodsCart);
	
	/**
	 * 修改 购买商品数量
	 * @param GoodsCart
	 */
	public int updateGoodsNumber(@Param("g")GoodsCart g,@Param("cartId")Long cartId);
	
	/**
	 * 删除
	 * @param GoodsCart
	 */
	public int deleteGoodsCart(Long cartId);
	
	/**
	 * 删除
	 * @param GoodsCart
	 */
	public int deleteGoodsCartByBuyerId(Long buyerId);
	
	/**
	 * 批量删除
	 * @param GoodsCart
	 */
	public int deleteGoodsCartBatch(@Param("ids")List<Long> ids);
	
	/**
	 * 删除买家在当前店铺的购物车
	 * @param GoodsCart
	 */
	public int deleteGoodsCartByBuyerIdSellerId(@Param("buyerId")Long buyerId,@Param("sellerId")Long sellerId);
	
	/**
	 * 判断是否存在该商品
	 * @param 
	 */
	public Long getByFormatIdAndUserId(@Param("formatId")Long formatId,@Param("methodId")Long methodId,@Param("userId")Long userId);
}