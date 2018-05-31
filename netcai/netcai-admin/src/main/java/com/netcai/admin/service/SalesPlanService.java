package com.netcai.admin.service;

import com.netcai.admin.entity.SalesPlan;
import com.netcai.admin.utils.PageUtil;

/**
 * 销售目标接口
 * @author administrator
 */
public interface SalesPlanService {

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(SalesPlan salesPlan,int currentPageNum,int currentPageSize);
	
	/**
	 * 新增商品信息
	 */
	public long insertSalesPlan(SalesPlan salesPlan);

	/**
	 * 更新商品信息
	 */
	public int updateSalesPlan(SalesPlan salesPlan);
	
	/**
	 * 根据id查找商品信息
	 */
	public SalesPlan getSalesPlanById(Long spId);
}
