package com.netcai.admin.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Activity;

/**
 * 促销活动商家DAO
 * @author administrator
 */
public interface ActivitySellerDao {

	/*
	 * 批量添加活动商家
	 */
	public int batchInsertActivitySeller(Activity activity);
	
	/*
	 * 删除活动商家
	 */
	public int deleteActivitySeller(@Param("activityId") int activityId);
}
