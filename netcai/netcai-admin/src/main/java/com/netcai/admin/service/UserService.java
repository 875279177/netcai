package com.netcai.admin.service;

import com.netcai.admin.entity.Users;

public interface UserService {
	
	/**
	 * 启用系统用户
	 */
	public int getByAccount(String account);
	
	public Users getUsersByAccount(String account);
}
