package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.DeliveryTask;
import com.netcai.admin.vo.OrderTaskVo;

/**
 * 订单分配任务
 */
public interface DeliveryTaskDao {

	/**
	 * 查询当天所有分配任务
	 */
	public List<DeliveryTask> getByThatDay();
	
	/**
	 * 新增配送人员信息
	 */
	public int insert(DeliveryTask deliveryTask);
	
	/**
	 * 查询某个配送员当天所有分配任务
	 */
	public List<OrderTaskVo> getByThatDayByDeliveryId(Long deliveryId);
	
	/**
	 * 查询某个配送员历史分配订单;
	 */
	public List<OrderTaskVo> getByDeliveryId(Long deliveryId);
	
	/**
	 * 批量新增
	 */
	public int insertBatch( @Param("deliveryTasks")List<DeliveryTask> deliveryTasks);
	
	/**
	 * 删除根据orderId deliveryId
	 */
	public int delByOrderIdByDeliveryId(@Param("orderId")Long orderId,@Param("deliveryId")Long deliveryId);
}