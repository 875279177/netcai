package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderPercentage;
import com.netcai.admin.vo.OrderPercentageVo;

/**
 * 卖家抽点Dao
 * @author administrator
 *
 */
public interface OrderPercentageDao {
	
	/**
	 * 根据时间查询卖家的抽点金额
	 * @param percentage
	 * @return
	 */
	public List<OrderPercentage> getOrderPercentagesByDate(OrderPercentage percentage);
	
	/**
	 * 根据时间统计卖家的抽点金额 
	 * @param percentage
	 * @return
	 */
	public List<OrderPercentageVo> getAmountByDate(@Param(value="p")OrderPercentageVo p,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	/**
	 * 根据时间统计卖家的抽点金额 
	 * @param percentage
	 * @return
	 */
	public List<OrderPercentageVo> getAmountByDate(@Param(value="p")OrderPercentageVo p);
	
	/**
	 * @return 数量
	 */
	public int getAmountByDateCount(@Param(value="p")OrderPercentageVo p);
	
	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的抽成金额
	 * @param map
	 * @return
	 */
	public BigDecimal getAmountByTimeType(Map<String, Object> map);
	
	/**
	 * 根据区域查询平台抽点的总金额
	 * @param areaId
	 * @return
	 */
	public BigDecimal getPercentageAmount(@Param(value="areaId")Long areaId);
	
	/**
	 * 根据时间统计卖家的抽点总金额 
	 * @param sellerId
	 * @param time
	 * @return
	 */
	public BigDecimal getTotalPercentagesAmountByDate(@Param(value="sellerId")Long sellerId,@Param(value="time")String time);
	
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);

}
