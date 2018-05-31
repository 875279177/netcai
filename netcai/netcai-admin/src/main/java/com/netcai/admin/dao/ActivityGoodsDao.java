package com.netcai.admin.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Activity;

/**
 * 促销活动商品DAO
 * @author administrator
 */
public interface ActivityGoodsDao {

	/*
	 * 批量添加活动商品
	 */
	public int batchInsertActivityGoods(Activity activity);
	
	/*
	 * 删除活动商品
	 */
	public int deleteActivityGoods(@Param("activityId") int activityId);
}
