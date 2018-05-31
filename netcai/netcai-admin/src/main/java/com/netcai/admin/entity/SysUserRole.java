package com.netcai.admin.entity;

import java.io.Serializable;

/**
 * 用户角色关联实体类
 * @author administrator
 *
 */
public class SysUserRole implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	/**
	 * 用户编号
	 */
	private Long userId; 
	/**
	 * 角色编号
	 */
	private Long roleId;
	
	public SysUserRole() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
	
	

}
