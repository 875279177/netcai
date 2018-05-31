package com.netcai.buyer.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Goods;
import com.netcai.buyer.entity.GoodsCart;
import com.netcai.buyer.entity.GoodsFormat;
import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.vo.TransactionDetails;

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
	public int updateGoodsFromat(GoodsFormat goodsFormat);
	
	/*
	 * 根据formatId查询;
	 */
	public GoodsFormat getById(Long formatId);
	
	/*
	 * 根据formatId查询单价;
	 */
	public BigDecimal getFormatPriceById(Long formatId);
	
	/*
	 * 根据Id和FormatStatus查询FormatId
	 */
	public List<GoodsFormat> getFormatIdByIdAndFormatStatus(@Param("orderItems") List<OrderItem> orderItems);
	
	/*
	 * 根据Id和FormatStatus查询FormatId
	 */
	public List<GoodsFormat> getByIdAndFormatStatus(@Param("goodsCarts") List<GoodsCart> goodsCarts);
	
	/**
	 * 根据一级节点查询所有的商品规格id
	 * @return
	 */
	public List<Long> getFormatIdsByLevelOne(Integer id);
	
	/**
	 * 根据商品规格id查询上架的商品详细信息
	 * @param queryMap
	 * @return
	 */
	public TransactionDetails getGoodsDetailsByFormateIds(Map<String, Long> queryMap);
}
