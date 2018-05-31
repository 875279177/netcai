package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.FinancialStatistics;

/**
 */
public interface FinancialStatisticsDao {

	/**
	 * 查询总财务统计
	 */
	public List<FinancialStatistics> getList(@Param("f") FinancialStatistics financialStatistics);
	
	/**
	 * 查询总客户分类统计
	 */
	public List<FinancialStatistics> getCustomerList(@Param("f") FinancialStatistics financialStatistics);
	
	/**
	 * SKU财务统计
	 */
	public List<FinancialStatistics> getSkuList(@Param("f") FinancialStatistics financialStatistics);
}
