package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SalesPlanDao;
import com.netcai.admin.entity.SalesPlan;
import com.netcai.admin.service.SalesPlanService;
import com.netcai.admin.utils.PageUtil;

@Service
public class SalesPlanServiceImpl implements SalesPlanService{

	@Autowired
	private SalesPlanDao salesPlanDao;
	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(SalesPlan salesPlan,int currentPageNum,int currentPageSize){
		int size = salesPlanDao.getPageCount(salesPlan);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<SalesPlan> result = salesPlanDao.getAllSalesPlan(salesPlan,offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
	
	/**
	 * 新增商品信息
	 */
	public long insertSalesPlan(SalesPlan salesPlan){
		return salesPlanDao.insertSalesPlan(salesPlan);
	}

	/**
	 * 更新商品信息
	 */
	public int updateSalesPlan(SalesPlan salesPlan){
		return salesPlanDao.updateSalesPlan(salesPlan);
	}
	
	/**
	 * 根据id查找商品信息
	 */
	public SalesPlan getSalesPlanById(Long spId){
		return salesPlanDao.getSalesPlanById(spId);
	}
}
