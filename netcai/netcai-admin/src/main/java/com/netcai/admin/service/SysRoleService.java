package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.SysRole;
import com.netcai.admin.utils.PageUtil;
/**
 * 角色service
 * @author administrator
 */
public interface SysRoleService {

	/**
	 * 分页查询角色
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SysRole> getAllSysRole(int currentPageNum,int currentPageSize);

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(int currentPageNum,int currentPageSize);

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
	public SysRole getSysRoleById(int id);
	
	/**
	 * 取得所有在用的角色
	 */
	public List<SysRole> getAllSysRoleByStatus();
	
	/**
	 * 取得用户角色信息
	 */
    public List<SysRole> getRoleByUserId(Long userId);
}
