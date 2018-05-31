package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.GroupsItem;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动明细
 * @author administrator
 *
 */
public interface GroupsItemService {
	
	/**
	 * 根据团购活动id查询明细
	 * @param groups
	 * @return
	 */
	public List<GroupsItem> getByGroupsId(Long groupsId);
	
	/**
	 * 批量新增
	 * @param groups
	 * @return
	 */
	public int add(GroupsVo groups);
	
	/**
	 * 更新
	 * @param groups
	 * @return
	 */
	public int update(GroupsVo groups);
	
	/**
	 * 启用
	 * @param id
	 * @return
	 */
	public int enabled(Long id);
	
	/**
	 * 禁用
	 * @param id
	 * @return
	 */
	public int disabled(Long id);
}
