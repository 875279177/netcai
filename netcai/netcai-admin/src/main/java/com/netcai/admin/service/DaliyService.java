package com.netcai.admin.service;

import com.netcai.admin.utils.PageUtil;

public interface DaliyService {
	
	/**
	 * 销售人员日报列表
	 * @return PageUtil
	 */
	public PageUtil getPageDaliyResult(Long saleId,String beginDate,String endDate,Integer lookStatus,int currentPageNum,int currentPageSize);
	
	/**
	 * 销售人员拜访记录列表
	 * @return PageUtil
	 */
	public PageUtil getPageVisitResult(String buyerName,Long saleId,String beginDate,String endDate,Short svType,int currentPageNum,int currentPageSize);
	
	/**
	 * 更新当天销售业绩/线上支付/蔬菜销售
	 */
	public int updateDailyTask();
	
	/**
	 * 更新当天新注册/空降A/维护客户
	 */
	public int updateCustomerTask();
	
	/**
	 * 跟新日拜访量
	 */
	public int updateDayVisitTask();
	
	/**
	 * 销售人员周报列表
	 * @return PageUtil
	 */
	public PageUtil getPageWeeklyResult(Long saleId,Integer lookStatus,int currentPageNum,int currentPageSize);
}
