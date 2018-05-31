package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SysMenu;

/**
 * 系统菜单Dao
 * @author administrator
 */
public interface SysMenuDao {

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
	public SysMenu getMenuById(@Param("menuId") int menuId);
	
	/**
	 * 根据菜单id查询其子菜单
	 * @param menuId
	 * @return
	 */
	public List<SysMenu> getChildrenMenuById(Integer menuId);
	
	/**
	 * 根据角色取得菜单
	 */
	public List<SysMenu> getAllMenuByRoleId(@Param("roleId") int roleId);
	
	/**
	 * 添加角色菜单
	 */
	public int insertRoleMenu(@Param("roleId") int roleId,@Param("menuIdList")List<String> menuIdList);
	
	/**
	 * 根据角色id删除角色菜单
	 */
	public int deleteRoleMenu(@Param("roleId") int roleId);
	
	/**
	 * 根据用户和菜单类型查询菜单
	 */
	public List<SysMenu> getAllMenuByUserId(@Param("userId") Long userId,@Param("type") int type);
	
	/**
	 * 根据菜单id删除角色菜单
	 */
	public int deleteRoleMenuByMenuId(Integer menuId);
	
	/**
	 * 删除菜单
	 * @param menuId
	 * @return
	 */
	public int delete(Integer menuId);
}
