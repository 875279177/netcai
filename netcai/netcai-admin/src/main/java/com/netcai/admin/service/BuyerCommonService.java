package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.BuyerCommon;
import com.netcai.admin.entity.BuyerCommon.GoodId;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerCommonVo;

public interface BuyerCommonService {
	
	/**
	 * 根据id查询买家信息
	 */
    public PageUtil getBuyerCommon(BuyerCommonVo buyerCommonVo, Integer currentPageNum, Integer currentPageSize);
    
    /**
     *根据buyerId删除
     */
    public int deleteAllByBuyerId(Long buyerId);
    
    /**
     *根据buyerId查询信息
     */
    public List<BuyerCommonVo> getAllByBuyerId(Long buyerId);
    
    /**
     *删除
     */
    public int delete(List<Long> bcIds);
    
    /**
     *批量新增
     */
    public int batchSave(List<BuyerCommon> list);
    
    /**
     *批量替换常用清单
     */
    public int updateGoodsId(BuyerCommon buyerCommon);
    
    /**
   	 *获取数量;
   	 */
   	public List<GoodId> getGoodsIdAndGoodsIdOld(Long sellerId,Long sellerIdOld);
}
