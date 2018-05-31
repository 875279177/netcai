package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.GroupsItem;

/**
 * 团购明细Dao
 * @author administrator
 *
 */
public interface GroupsItemDao {
	
	/**
	 * 根据团购活动id查询明细
	 * @param groups
	 * @return
	 */
	public List<GroupsItem> getByGroupsId(Long groupsId);
	
	/**
	 * 批量新增
	 * @param items
	 * @return
	 */
	public int batchInsert(List<GroupsItem> items);
	/**
	 * 更新
	 * @param item
	 * @return
	 */
	public int update(GroupsItem item);
	
	/**
	 * 更新状态
	 * @param id
	 * @return
	 */
	public int updateStatus(@Param("id")Long id,@Param("status")int status);
	
	/**
	 * 根据团购活动id批量更新状态
	 * @param groupsId
	 * @return
	 */
	public int updateStatusByGroupsId(@Param("groupsId")Long groupsId,@Param("status")int status);
	
	/**
	 * 批量删除
	 * @param item
	 * @return
	 */
	public int batchDelete(@Param("groupsId")Long groupsId,@Param("list")List<Long> formateIds);
	
}
