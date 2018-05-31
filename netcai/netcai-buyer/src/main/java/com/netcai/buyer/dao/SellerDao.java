package com.netcai.buyer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.vo.SellerVo;

public interface SellerDao {

	/**
	 * 获取最优的10个卖家店铺
	 * @return
	 */
     public List<SellerVo> getTop10Seller(@Param("regionId") Long regionId);
     
 	/**
 	 * APP全文搜索
 	 * @return
 	 */
     public List<SellerVo> searchSeller(@Param("regionId") Long regionId,@Param("keyword") String keyword);
     
     /**
  	 * 获取常用的卖家
  	 * @return
  	 */
     public List<SellerVo> getCommonSeller(Long userId);
     
     /**
      * 根据分类查找商家
      */
     public List<SellerVo> searchSellerByCategory(@Param("categoryCode") String categoryCode);
     
     /**
      * 根据sellerId查询单条数据
      */
     public SellerVo getBySellerId(@Param("sellerId") Long sellerId);
}
