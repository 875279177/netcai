package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Groups;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动配置Dao
 * @author administrator
 *
 */
public interface GroupsDao {
	
	/**
	 * 分页查询团购配置信息
	 * 
	 * @param groups
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<GroupsVo> getAll(@Param("groups") GroupsVo groups, @Param("start") int start,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @param groups
	 * @return
	 */
	public int getTotalCount(@Param("groups") GroupsVo groups);
	
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
	 * 批量修改
	 */
	public int updateBatch(@Param("list")List<Groups> groups);
	
	/**
	 * 修改
	 * @param groups
	 * @return
	 */
	public int update(GroupsVo groups);
	
	/**
	 * 更新状态
	 * @param id
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("id")Long id,@Param("status")int status);
	
}
