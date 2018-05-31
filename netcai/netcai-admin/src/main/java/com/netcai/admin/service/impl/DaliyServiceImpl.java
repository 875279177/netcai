package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.DaliyDao;
import com.netcai.admin.entity.SalesDaliy;
import com.netcai.admin.entity.SalesVisit;
import com.netcai.admin.entity.SalesWeekly;
import com.netcai.admin.service.DaliyService;
import com.netcai.admin.utils.PageUtil;

@Service
public class DaliyServiceImpl implements DaliyService{
	
	@Autowired
	private DaliyDao daliyDao;
	
	/**
	 * 销售人员日报列表
	 * @return PageUtil
	 */
	public PageUtil getPageDaliyResult(Long saleId,String beginDate,String endDate,Integer lookStatus,int currentPageNum,int currentPageSize){
		int size = daliyDao.getSalesDaliyCount(saleId, beginDate, endDate,lookStatus);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<SalesDaliy> result = daliyDao.getSalesDaliyList(saleId, beginDate, endDate,lookStatus, offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}

	/**
	 * 销售人员拜访记录列表
	 * @return PageUtil
	 */
	public PageUtil getPageVisitResult(String buyerName,Long saleId,String beginDate,String endDate,Short svType,int currentPageNum,int currentPageSize){
		int size = daliyDao.getSalesVisitCount(buyerName,saleId, beginDate, endDate,svType);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<SalesVisit> result = daliyDao.getSalesVisitList(buyerName,saleId, beginDate, endDate,svType, offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
	
	/**
	 * 更新当天销售业绩/线上支付/蔬菜销售
	 */
	public int updateDailyTask(){
		return daliyDao.updateDailyTask();
	}
	
	/**
	 * 更新当天新注册/空降A/维护客户
	 */
	public int updateCustomerTask(){
		return daliyDao.updateCustomerTask();
	}
	
	/**
	 * 跟新日拜访量
	 */
	public int updateDayVisitTask(){
		return daliyDao.updateDayVisitTask();
	}
	
	/**
	 * 销售人员周报列表
	 * @return PageUtil
	 */
	public PageUtil getPageWeeklyResult(Long saleId,Integer lookStatus,int currentPageNum,int currentPageSize){
		int size = daliyDao.getSalesWeeklyCount(saleId, lookStatus);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<SalesWeekly> result = daliyDao.getWeeklyList(saleId, lookStatus, currentPageNum,currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}
}
