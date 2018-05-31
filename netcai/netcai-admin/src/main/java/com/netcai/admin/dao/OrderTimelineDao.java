package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderTimeline;

/**
 */
public interface OrderTimelineDao {
    
	/**
	 * 根据订单项Id获取退货时间轴;
	 */
	public List<OrderTimeline> getList(@Param("itemId")Long itemId);
	
	/**
	 * 新增数据
	 * @param orderTimeline
	 * @return
	 */
	public int insert(OrderTimeline orderTimeline);
}
