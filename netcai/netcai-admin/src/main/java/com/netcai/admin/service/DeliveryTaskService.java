package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import com.netcai.admin.entity.DeliveryTask;
import com.netcai.admin.vo.OrderTaskVo;

/**
 * 
 */
public interface DeliveryTaskService {

	/**
	 * 查询当天所有分配任务
	 */
	public Map<Long,DeliveryTask> getByThatDay();
	
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
	public int insertBatch(List<DeliveryTask> deliveryTasks);
	
	/**
	 * 删除根据orderId deliveryId
	 */
	public int delByOrderIdByDeliveryId(Long orderId,Long deliveryId);
}
