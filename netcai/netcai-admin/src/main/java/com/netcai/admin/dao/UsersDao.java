package com.netcai.admin.dao;

import java.util.Map;

import com.netcai.admin.entity.Users;

/**
 * UserDAO
 * @author administrator
 */
public interface UsersDao {
	
	/**
	 * 添加
	 * @param users
	 */
	public int insertUsers(Users users);
	
	/**
	 * 启用
	 * @param id
	 */
	public int startTypeById(Long id);
	
	/**
	 * 禁用
	 * @param id
	 */
	public int stopTypeById(Long id);
	
	
	/**
	 * 通过account查询用户信息
	 * @param id
	 */
	public Users getUsersByAccount(String account);
	
	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	public Users getUsersById(Long id);
	
	/**
	 * 启用or 禁用
	 * @param id
	 */
	public int updateStatusById(Users users);
	
	/**
	 * 修改;
	 * @param id
	 */
	public int update(Users users);
	
	/**
	 * 统计买家数量
	 * @param map
	 * @return
	 */
	public int getBuyerCount(Map<String, Object> map);
	
	/**
	 * 统计卖家数量
	 * @param map
	 * @return
	 */
	public int getSellerCount(Map<String, Object> map);
	
}