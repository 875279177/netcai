package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.TodayStatisticsDao;
import com.netcai.admin.entity.TodayStatistics;
import com.netcai.admin.service.TodayStatisticsService;

/**
 */
@Service
public class TodayStatisticsServiceImpl implements TodayStatisticsService{

	@Autowired
	private TodayStatisticsDao todayStatisticsDao;

	@Override
	public List<TodayStatistics> getList(TodayStatistics todayStatistics) {
		return todayStatisticsDao.getList(todayStatistics);
	}
	
}
