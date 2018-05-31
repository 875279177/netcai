package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.TodayStatistics;

/**
 */
public interface TodayStatisticsDao {

	/**
	 * 获取全部
	 */
	public List<TodayStatistics> getList(@Param("t") TodayStatistics todayStatistics);
}
