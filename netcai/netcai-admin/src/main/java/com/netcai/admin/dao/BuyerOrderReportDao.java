package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerOrderReport;
import com.netcai.admin.vo.BuyerOrderReportVo;
import com.netcai.admin.vo.ReportBuyerVo;

/**
 * 统计买家每日订单金额
 */
public interface BuyerOrderReportDao {
	
	/**
	 * 批量新增
	 */
	public int insertBatch(@Param("buyerOrderReports")List<BuyerOrderReport> buyerOrderReports);
	
	/**
	 * 查询所有;
	 */
	public List<BuyerOrderReportVo> selectList(@Param("b")BuyerOrderReportVo b);
	
	/**
	 * 统计买家订单报表;
	 */
	public List<ReportBuyerVo> selectListByDateByHz(@Param("r")ReportBuyerVo r);
}
