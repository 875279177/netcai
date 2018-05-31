package com.netcai.admin.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.netcai.admin.entity.OrderPercentage;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.OrderPercentageVo;

/**
 * 卖家抽点service
 * @author administrator
 *
 */
public interface OrderPercentageService {
	
	/**
	 * 根据时间查询卖家的抽点金额
	 * @param createTime
	 * @return
	 */
	public List<OrderPercentage> getOrderPercentagesByDate(OrderPercentage percentage);
	
	/**
	 * 根据时间统计卖家的抽点金额 
	 * @param createTime
	 * @return
	 */
	public List<OrderPercentageVo> getAmountByDate(OrderPercentageVo percentage);
	
	/**
	 * 根据时间统计卖家的抽点金额 
	 * @param createTime
	 * @return
	 */
	public List<OrderPercentageVo> getAmountByDate(OrderPercentageVo percentage, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 分页查询
	 */
	public PageUtil getPageResult(OrderPercentageVo percentage, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的抽成金额
	 * @param timeType
	 * @return
	 */
	public Map<String, List<BigDecimal>> getAmountByTimeType(Integer timeType);
	
	/**
	 * 根据区域查询平台抽点的总金额
	 * @param areaId
	 * @return
	 */
	public BigDecimal getPercentageAmount(Long areaId);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);
	
}
