package com.netcai.buyer.service;

import com.netcai.buyer.entity.Users;

public interface UsersService {

	/**
	 * 根据用户的ID获取用户对象
	 * @param userId
	 * @return
	 */
	public Users getUsersById(Long userId);
	
	/**
	 * 根据用户的账号(目前是手机号码),获取用户对象
	 * @param account
	 * @return
	 */
	public Users getUserByAccount(String account);
	
	/**
	 * 注册,增加买家
	 * @param users
	 * @return
	 */
	public int addUsers(Users users);
	
	/**
	 * 新增用户
	 * @param account
	 * @param password
	 * @return
	 */
	public void insertUsers(String account,String password);
	
	/*
	 * 重置密码
	 */
	public int updatePassword(Long userId,String password);
}