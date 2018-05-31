package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerConfig;

public interface BuyerConfigDao {
	
   /**
    * 批量新增
    * @param list
    * @return
    */
   public int batchSave(@Param("list")List<BuyerConfig> list);
   
   /**
    * 根据买家ID删除所有
    * @param buyerId
    * @return
    */
   public int deleteAllByBuyerId(Long buyerId);
   
   /**
    * 根据买家ID查询所有卖家ID
    * @param buyerId
    * @return
    */
   public List<Long> getAllSellerIdByBuyerId(Long buyerId);

}