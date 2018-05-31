package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.FinancialStatisticsDao;
import com.netcai.admin.entity.FinancialStatistics;
import com.netcai.admin.service.FinancialStatisticsService;

/**
 */
@Service
public class FinancialStatisticsServiceImpl implements FinancialStatisticsService{

	@Autowired
	private FinancialStatisticsDao financialStatisticsDao;

	@Override
	public List<FinancialStatistics> getList(FinancialStatistics financialStatistics) {
		return financialStatisticsDao.getList(financialStatistics);
	}

	@Override
	public List<FinancialStatistics> getCustomerList(FinancialStatistics financialStatistics) {
		return financialStatisticsDao.getCustomerList(financialStatistics);
	}

	@Override
	public List<FinancialStatistics> getSkuList(FinancialStatistics financialStatistics) {
		return financialStatisticsDao.getSkuList(financialStatistics);
	}
	
}
