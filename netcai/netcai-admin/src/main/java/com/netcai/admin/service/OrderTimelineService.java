package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.OrderTimeline;

/**
 * 账单service
 * @author administrator
 *
 */
public interface OrderTimelineService {
	/**
	 * 根据订单项Id获取退货时间轴;
	 */
	public List<OrderTimeline> getList(Long itemId);	
}
