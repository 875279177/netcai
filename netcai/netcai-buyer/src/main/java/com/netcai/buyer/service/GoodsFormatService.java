package com.netcai.buyer.service;

import com.netcai.buyer.entity.GoodsFormat;

/**
 * skuservice
 * @author administrator
 */
public interface GoodsFormatService {

	
	
	/**
	 * 根据id查找商品信息
	 */
	public GoodsFormat getGoodsFormatById(Long formatId);
	

	
}
