package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerCommon;
import com.netcai.admin.entity.BuyerCommon.GoodId;
import com.netcai.admin.vo.BuyerCommonVo;

/**
 *
 */
public interface BuyerCommonDao {
	
	
	/**
	 *获取数量;
	 */
	public int getCount(@Param("b")BuyerCommonVo b);
	
	/**
	 * 查询信息
	 */
    public List<BuyerCommonVo> getBuyerCommon(@Param("b")BuyerCommonVo b,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
    
    /**
     *根据buyerId删除
     */
    public int deleteAllByBuyerId(@Param("buyerId")Long buyerId);
    
    /**
     *根据buyerId查询信息
     */
    public List<BuyerCommonVo> getAllByBuyerId(@Param("buyerId")Long buyerId);
    
    /**
     *根据buyerId删除
     */
    public int delete(@Param("bcIds")List<Long> bcIds);
    
    /**
     *批量新增
     */
    public int batchSave(@Param("list")List<BuyerCommon> list);
    
    /**
     *批量替换常用清单
     */
    public int updateGoodsId(BuyerCommon buyerCommon);
    
    /**
	 *获取数量;
	 */
	public List<GoodId> getGoodsIdAndGoodsIdOld(@Param("sellerId")Long sellerId,@Param("sellerIdOld")Long sellerIdOld);
}
