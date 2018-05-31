package com.netcai.admin.service;

import com.netcai.admin.entity.ActiveSysUser;
import com.netcai.admin.entity.SysUser;
import com.netcai.admin.utils.PageUtil;

public interface SysUserService {
	
	/**
	 * 分页查询用户信息
	 * 
	 * @param user
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllSysUser(SysUser user,int pageNum,int pageSize);
	

	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public ActiveSysUser getUserByUserName(String username);
	
	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public SysUser getUserByPhone(String phone);
	
	/**
	 * 根据登录名称查询用户
	 * @param id
	 * @return
	 */
	public SysUser getUserById(Long id);
	
	/**
	 * 新增系统用户
	 * @param user
	 * @return
	 */
	public int insertAndUpdate(SysUser user);
	
	/**
	 * 禁用系统用户
	 * @param id
	 * @return
	 */
	public int disabledSysUser(Long id);
	
	/**
	 * 启用系统用户
	 * @param id
	 * @return
	 */
	public int enabledSysUser(Long id);
}
