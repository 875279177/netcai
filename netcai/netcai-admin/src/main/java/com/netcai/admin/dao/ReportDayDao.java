package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.ReportDay;
import com.netcai.admin.vo.CategoryItemVo;
import com.netcai.admin.vo.OrderCategoryListVo;
import com.netcai.admin.vo.ReportDayVo;
import com.netcai.admin.vo.SearchVo;

/**
 * 统计每天订单报表
 */
public interface ReportDayDao {

	
	/**
	 * 批量新增
	 */
	public int insertBatch(@Param("reportDays")List<ReportDay> reportDays);
	
	/**
	 * 查询所有;
	 */
	public List<ReportDayVo> selectList(@Param("r")ReportDayVo r);
	
	/**
	 * 查询当天的;
	 */
	public ReportDayVo getByDate(int date);
	
	public int getOrderByCategoryCount();
	
	public List<OrderCategoryListVo> getOrderByCategory(@Param("offset") int offset,@Param("pageSize") int pageSize);
	
	public List<CategoryItemVo> getOrderItemByCategory(@Param("search") SearchVo search);
	
	public List<CategoryItemVo> getOrderBuyerByCategory(@Param("search") SearchVo search);
	
	public List<CategoryItemVo> getOrderBuyerByDate(@Param("search") SearchVo search);
}
