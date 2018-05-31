package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.SysMenu;

import net.sf.json.JSONArray;

/**
 * 菜单service
 * @author administrator
 */
public interface SysMenuService {

	/**
	 * 查询所有菜单
	 */
	public List<SysMenu> getAllMenu();

	/**
	 * 添加菜单
	 */
	public int insertMenu(SysMenu entity);

	/**
	 * 更新菜单
	 */
	public int updateMenu(SysMenu entity);
	
	/**
	 * 根据id查找菜单
	 */
	public SysMenu getMenuById(int menuId);
	
	/**
	 * 根据菜单id查询其子菜单
	 */
	public List<SysMenu> getChildrenMenu(int menuId);
	
	/*
	 * 分类树(json格式)
	 */
	public JSONArray menuTree(List<SysMenu> menuList,int parentId);
	
	/**
	 * 根据角色取得菜单
	 */
	public List<SysMenu> getAllMenuByRoleId(int roleId);
	
	/**
	 * 添加角色菜单
	 */
	public int insertRoleMenu(int roleId,List<String> menuIdList);
	
	/**
	 * 查询用户的菜单
	 */
	public List<SysMenu> getMyMenu(List<SysMenu> menuList,int parentId);
	
	/**
	 * 根据用户和菜单类型查询菜单
	 */
	public List<SysMenu> getAllMenuByUserId(Long userId, int type);
	
	/**
	 * 删除菜单
	 */
	public int deleteMenu(Integer menuId);

}
