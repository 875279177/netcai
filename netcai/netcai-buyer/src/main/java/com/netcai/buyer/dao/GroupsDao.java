package com.netcai.buyer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.GroupBuyer;
import com.netcai.buyer.vo.GroupsVo;

/**
 * 团购DAO
 * @author administrator
 */
public interface GroupsDao {

	/**
	 * 团购清单
	 */
	public List<GroupsVo> getGroupsList(@Param("regionId") Long regionId);
	
	/**
	 * 团购详情
	 */
	public GroupsVo getGroupsInfo(@Param("groupId") Long groupId);
	
	/**
	 * 添加买家团购记录
	 */
	public int batchInsertGroupBuyer(@Param("gbList") List<GroupBuyer> gbList);
	
	/**
	 * 根据订单ID修改买家团购成功标识
	 */
	public int updateGbStatusByOrderId(@Param("orderId") Long orderId);
	
	/**
	 * 根据订单号修改买家团购成功标识
	 */
	public int updateGbStatusByOrderNumber(@Param("orderNumber") String orderNumber);
}
