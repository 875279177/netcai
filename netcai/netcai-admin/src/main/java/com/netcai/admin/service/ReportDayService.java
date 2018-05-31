package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.CategoryItemVo;
import com.netcai.admin.vo.ReportDayVo;
import com.netcai.admin.vo.SearchVo;

/**
 * 统计每天订单报表
 */
public interface ReportDayService {


	/**
	 * 批量新增
	 */
	public int insertBatch(Integer today);
	
	/**
	 * 查询所有;
	 */
	public Map<Integer,List<ReportDayVo>> selectList(ReportDayVo reportDayVo);
	
	/**
	 * 查询当天的;
	 */
	public ReportDayVo getByDate(int date);
	
	public PageUtil getPageResult(int currentPageNum,int currentPageSize);
	
	public List<CategoryItemVo> getOrderItemByCategory(SearchVo search);
	
	public List<CategoryItemVo> getOrderBuyerByCategory(SearchVo search);
	
	public List<CategoryItemVo> getOrderBuyerByDate(SearchVo search);
}
