package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.DeliveryIncome;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;
/**
 * 配送人员收入service
 * @author administrator
 *
 */
public interface DeliveryIncomeService {
	
	/**
	 * 查询全部数据
	 */
	public PageUtil getPageResult(DeliveryIncome deliveryIncome, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 查询全部数据
	 */
	public List<DeliveryIncome> getResult(DeliveryIncome deliveryIncome, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 批量新增配送人员收入 （定时器执行）
	 */
	public int calculatedDeliveryIncome();
	
	/**
	 * 查询配送人员送到的买家;
	 */
	public List<BuyerVo> getBuyer(DeliveryIncome deliveryIncome);
}
