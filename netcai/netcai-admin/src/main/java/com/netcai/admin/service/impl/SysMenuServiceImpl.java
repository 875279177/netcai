package com.netcai.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SysMenuDao;
import com.netcai.admin.entity.SysMenu;
import com.netcai.admin.service.SysMenuService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 菜单service impl
 * @author administrator
 */
@Service
public class SysMenuServiceImpl implements SysMenuService{
	
	@Autowired
	private SysMenuDao menuDao;
	
	/**
	 * 查询所有商品分类
	 */
	@Override
	public List<SysMenu> getAllMenu(){
		return menuDao.getAllMenu();
	}

	/**
	 * 添加商品分类
	 */
	@Override
	public int insertMenu(SysMenu entity) {
		menuDao.insertMenu(entity);
		return entity.getMenuId();
	}

	/**
	 * 更新商品分类
	 */
	@Override
	public int updateMenu(SysMenu entity) {
		int result = menuDao.updateMenu(entity);
		return result;
	}

	/**
	 * 根据id查找商品分类
	 */
	@Override
	public SysMenu getMenuById(int menuId){
		return menuDao.getMenuById(menuId);
	}
	
	/*
	 * 分类树(json格式)
	 */
	@Override
	public JSONArray menuTree(List<SysMenu> menuList,int parentId){
		JSONArray all = new JSONArray();
        for (SysMenu menu : menuList) {
            JSONObject main = JSONObject.fromObject(menu);
            int menuId = main.getInt("menuId");
            int pid = main.getInt("parentId");
            if (parentId == pid) {
                JSONArray children = menuTree(menuList, menuId);
                main.put("children", children);
                all.add(main);
            }
        }
        return all;
	}

	/**
	 * 根据角色取得菜单
	 */
	public List<SysMenu> getAllMenuByRoleId(int roleId){
		return menuDao.getAllMenuByRoleId(roleId);
	}
	
	/**
	 * 添加角色菜单
	 */
	public int insertRoleMenu(int roleId,List<String> menuIdList){
		menuDao.deleteRoleMenu(roleId);
		return menuDao.insertRoleMenu(roleId, menuIdList);
	}
	
	/**
	 * 查询用户的菜单
	 */
	public List<SysMenu> getMyMenu(List<SysMenu> menuList,int parentId){
		List<SysMenu> smList = new ArrayList<SysMenu>();
        for (SysMenu menu : menuList) {
            int menuId = menu.getMenuId();
            int pid = menu.getParentId();
            if (parentId == pid) {
                menu.setMenuList(getMyMenu(menuList,menuId));
                smList.add(menu);
            } 
        }
        return smList;
	}
	
	/**
	 * 根据用户和菜单类型查询菜单
	 */
	@Override
	public List<SysMenu> getAllMenuByUserId(Long userId, int type) {
		return menuDao.getAllMenuByUserId(userId, type);
	}
	
	/**
	 * 根据菜单id查询其子菜单
	 */
	@Override
	public List<SysMenu> getChildrenMenu(int menuId) {
		return menuDao.getChildrenMenuById(menuId);
	}
	
	/**
	 * 删除菜单
	 */
	@Override
	public int deleteMenu(Integer menuId) {
		//先删除菜单角色关联表中的数据
		menuDao.deleteRoleMenuByMenuId(menuId);
		//删除菜单
		return menuDao.delete(menuId);
	}

}
