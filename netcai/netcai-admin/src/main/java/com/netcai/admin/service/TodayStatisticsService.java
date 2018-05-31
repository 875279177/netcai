package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.TodayStatistics;

/**
 */
public interface TodayStatisticsService {

	/**
	 * 获取全部
	 */
	public List<TodayStatistics> getList(TodayStatistics todayStatistics);
}
