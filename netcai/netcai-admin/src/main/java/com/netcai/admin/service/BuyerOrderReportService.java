package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import com.netcai.admin.vo.BuyerOrderReportVo;
import com.netcai.admin.vo.ReportBuyerVo;

/**
 * 统计买家每日订单金额
 */
public interface BuyerOrderReportService {

	/**
	 * 批量新增
	 */
	public int insertBatch(Integer today);

	/**
	 * 查询所有;
	 */
	public Map<Integer,List<BuyerOrderReportVo>> selectList(BuyerOrderReportVo buyerOrderReportVo);
	
	/**
	 * 统计买家订单报表;
	 */
	public List<ReportBuyerVo> selectListByDateByHz(ReportBuyerVo r);
}
