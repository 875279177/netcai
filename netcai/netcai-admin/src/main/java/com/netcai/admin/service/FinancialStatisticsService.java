package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.FinancialStatistics;

/**
 */
public interface FinancialStatisticsService {

	/**
	 * 查询总财务统计
	 */
	public List<FinancialStatistics> getList(FinancialStatistics financialStatistics);
	
	/**
	 * 查询总客户分类统计
	 */
	public List<FinancialStatistics> getCustomerList(FinancialStatistics financialStatistics);
	
	/**
	 * SKU财务统计
	 */
	public List<FinancialStatistics> getSkuList(FinancialStatistics financialStatistics);
}
