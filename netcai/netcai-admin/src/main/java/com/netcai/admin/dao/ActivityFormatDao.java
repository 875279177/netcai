package com.netcai.admin.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Activity;

/**
 * 促销活动规则DAO
 * @author administrator
 */
public interface ActivityFormatDao {

	/*
	 * 批量添加活动规则
	 */
	public int batchInsertActivityFormat(Activity activity);
	
	/*
	 * 删除活动规则
	 */
	public int deleteActivityFormat(@Param("activityId") int activityId);
}
