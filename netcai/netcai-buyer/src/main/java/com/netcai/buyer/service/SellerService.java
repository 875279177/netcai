package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.vo.SellerVo;

public interface SellerService {

	/**
	 * 获取最优的10个卖家店铺
	 * @return
	 */
     public List<SellerVo> getTop10Seller(Long regionId);
	
  	/**
  	 * APP全文搜索
  	 * @return
  	 */
     public List<SellerVo> searchSeller(Long regionId,String keyword);
     
 	/**
 	 * 获取常用的卖家
 	 * @return
 	 */
     public List<SellerVo> getCommonSeller(Long userId);
     
     /**
      * 根据分类查找商家
      */
     public List<SellerVo> searchSellerByCategory(String categoryCode);
     
     /**
      * 根据sellerId查询单条数据
      */
     public SellerVo getBySellerId(Long sellerId);
}
