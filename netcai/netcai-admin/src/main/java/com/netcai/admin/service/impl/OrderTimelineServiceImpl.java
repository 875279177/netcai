package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.OrderTimelineDao;
import com.netcai.admin.entity.OrderTimeline;
import com.netcai.admin.service.OrderTimelineService;

@Service
public class OrderTimelineServiceImpl implements OrderTimelineService {

	@Autowired
	private OrderTimelineDao orderTimelineDao;

	/**
	 * 根据订单项Id获取退货时间轴;
	 */
	@Override
	public List<OrderTimeline> getList(Long itemId) {
		return orderTimelineDao.getList(itemId);
	}

}