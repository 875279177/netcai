package com.netcai.admin.entity;

import java.util.List;

/**
 * 当前登录用户
 * 
 * @author administrator
 *
 */
public class ActiveSysUser {

	private Long id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 真实姓名
	 */
	private String name;
	/**
	 * 加密的盐
	 */
	private String salt;
	/**
	 * 菜单
	 */
	private List<SysMenu> menuList;
	/**
	 * 资源权限
	 */
	private List<SysMenu> permissions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

	public List<SysMenu> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<SysMenu> permissions) {
		this.permissions = permissions;
	}

}
