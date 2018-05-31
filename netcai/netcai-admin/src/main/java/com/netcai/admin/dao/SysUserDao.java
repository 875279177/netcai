package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SysUser;

/**
 * 后台用户Dao
 * @author mengj
 *
 */
public interface SysUserDao {
	
	/**
	 * 分页查询用户信息
	 * 
	 * @param user
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SysUser> getAllSysUser(@Param("user") SysUser user, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @param user
	 * @return
	 */
	public int getPageCount(@Param("user") SysUser user);

	/**
	 * 根据登录名称查询用户
	 * @param loginName
	 * @return
	 */
	public SysUser getUserByUserName(String username);
	
	/**
	 * 根据手机号称查询用户
	 * @param phone
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
	public int insertSysUser(SysUser user);
	
	/**
	 * 更新系统用户
	 * @param user
	 * @return
	 */
	public int updateSysUser(SysUser user);
	
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
	
	/**
	 * 删除用户角色
	 */
	public int deleteUserRole(@Param("userId") Long userId);
	
	/**
	 * 添加用户角色
	 */
	public int insertUserRole(@Param("userId") Long userId,@Param("roleIds") List<Long> roleIds);
}
