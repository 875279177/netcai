package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.GoodsCart;
import com.netcai.admin.vo.GoodsCartVo;

/**
 * 购物车DAO
 * @author administrator
 */
public interface GoodsCartDao {

	

	/**
	 * 查询列表;
	 */
	public List<GoodsCartVo> getGoodsCartList( @Param("g")GoodsCart g  ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("g")GoodsCart g );
	
	/**
	 * @return 查询总数
	 */
	public int getPageCountList( @Param("g")GoodsCart g );
	
	/**
	 * 添加
	 */
	public int insertGoodsCart(GoodsCart GoodsCart);
	
	/**
	 * 修改GoodsNumber数量
	 */
	public int updateGoodsNumber(@Param("g")GoodsCart g);
	
	/**
	 * 删除
	 */
	public int deleteGoodsCart(Long cartId);
}