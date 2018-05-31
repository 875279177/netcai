package com.netcai.admin.service;

import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动service
 * @author administrator
 *
 */
public interface GroupsService {
	
	/**
	 * 分页查询团购活动信息
	 * @param groups
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllByPage(GroupsVo groups,int currentPage,int pageSize);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public GroupsVo getById(Long id);
	
	/**
	 * 新增
	 * @param groups
	 * @return
	 */
	public int insert(GroupsVo groups);
	
	/**
	 * 修改
	 * @param groups
	 * @return
	 */
	public int update(GroupsVo groups);
	
	/**
	 * 更改状态为不开团
	 * @param id
	 * @return
	 */
	public int disabled(Long id);
	
	/**
	 * 更改状态为开团
	 * @param id
	 * @return
	 */
	public int enabled(Long id);
	

}
