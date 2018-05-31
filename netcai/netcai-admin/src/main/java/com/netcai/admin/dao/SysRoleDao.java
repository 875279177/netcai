package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SysRole;

/**
 * 角色信息Dao
 * @author administrator
 */
public interface SysRoleDao {
	
	/**
	 * 分页查询角色
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SysRole> getAllSysRole(@Param("offset") int offset,@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * @return total
	 */
	public int getPageCount();

	/**
	 * 添加角色
	 */
	public int insertSysRole(SysRole role);

	/**
	 * 更新角色
	 */
	public int updateSysRole(SysRole role);
	
	/**
	 * 根据id查找角色
	 */
	public SysRole getSysRoleById(@Param("id") int id);
	
	/**
	 * 取得所有在用的角色
	 */
	public List<SysRole> getAllSysRoleByStatus();
	
	/**
	 * 取得用户角色信息
	 */
    public List<SysRole> getRoleByUserId(@Param("userId") Long userId);
}
