package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.GroupOrder;
import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.vo.GroupsVo;

/**
 * 团购service
 * @author administrator
 */
public interface GroupsService {

	/**
	 * 团购清单
	 */
	public List<GroupsVo> getGroupsList(Long regionId);
	
	/**
	 * 团购详情
	 */
	public GroupsVo getGroupsInfo(Long groupId);
	
    /**
     * 创建团购订单
     */
	public OrderInfo addOrderInfo(GroupOrder groupOrder);
	
	/**
	 * 根据订单ID修改买家团购成功标识
	 */
	public int updateGbStatusByOrderId(Long orderId);
	
	/**
	 * 根据订单号修改买家团购成功标识
	 */
	public int updateGbStatusByOrderNumber(String orderNumber);
}
