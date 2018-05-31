package com.netcai.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.DeliveryTaskDao;
import com.netcai.admin.entity.DeliveryTask;
import com.netcai.admin.service.DeliveryTaskService;
import com.netcai.admin.vo.OrderTaskVo;

/**
 * 
 */
@Service
public class DeliveryTaskServiceImpl implements DeliveryTaskService {

	@Autowired
	private DeliveryTaskDao deliveryTaskDao;
	
	/**
	 * 查询当天任务;
	 */
	@Override
	public Map<Long, DeliveryTask> getByThatDay() {
		Map<Long ,DeliveryTask> map = new HashMap<Long, DeliveryTask>();
		List<DeliveryTask> list = deliveryTaskDao.getByThatDay();
		for (int i = 0; i < list.size(); i++) {
			DeliveryTask deliveryTask = list.get(i);
			Long orderId = deliveryTask.getOrderId();
			map.put(orderId, deliveryTask);
		}
		return map;
	}

	/**
	 * 新增;
	 */
	@Override
	public int insert(DeliveryTask deliveryTask) {
		return deliveryTaskDao.insert(deliveryTask);
	}

	@Override
	public List<OrderTaskVo> getByThatDayByDeliveryId(Long deliveryId) {
		return deliveryTaskDao.getByThatDayByDeliveryId(deliveryId);
	}

	@Override
	public List<OrderTaskVo> getByDeliveryId(Long deliveryId) {
		return deliveryTaskDao.getByDeliveryId(deliveryId);
	}

	@Override
	public int insertBatch(List<DeliveryTask> deliveryTasks) {
		return deliveryTaskDao.insertBatch(deliveryTasks);
	}

	@Override
	public int delByOrderIdByDeliveryId(Long orderId, Long deliveryId) {
		return deliveryTaskDao.delByOrderIdByDeliveryId(orderId, deliveryId);
	}
}