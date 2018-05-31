package com.netcai.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.UsersDao;
import com.netcai.admin.entity.Users;
import com.netcai.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao usersDao;

	/**
	 * 判断当前账号是否注册;
	 */
	@Override
	public int getByAccount(String account) {
		int result = 0;
		Users usersByAccount = usersDao.getUsersByAccount(account);
		if (usersByAccount != null) {
			result = 1;
		}
		return result;
	}

	@Override
	public Users getUsersByAccount(String account) {
		return usersDao.getUsersByAccount(account);
	}
}