package com.netcai.buyer.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.constants.UserStatus;
import com.netcai.buyer.constants.UsersType;
import com.netcai.buyer.dao.BuyerDao;
import com.netcai.buyer.dao.UsersDao;
import com.netcai.buyer.entity.Buyer;
import com.netcai.buyer.entity.Users;
import com.netcai.buyer.service.UsersService;

/**
 * 用户服务
 * 
 * @author administrator
 */
@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;
	
	@Autowired
	private BuyerDao buyerDao;

	@Override
	public Users getUsersById(Long userId) {
		return usersDao.getUsersById(userId);
	}

	@Override
	public Users getUserByAccount(String account) {
		return usersDao.getUsersByAccount(account);
	}

	@Override
	public int addUsers(Users users) {
		 return usersDao.insertUsers(users);
	}

	@Override
	public void insertUsers(String account, String password) 
	{
		Users user = new Users();
		user.setAccount(account);
		user.setPassword(password);
		user.setCreateTime(new Date());
		user.setStatus(UserStatus.REGISTERED);
		user.setLastLoginTime(new Date());
		// 设置用户类型为卖家
		user.setType(UsersType.BUYER);
		
		usersDao.insertUsers(user);
		
		Buyer buyer=new Buyer();
		buyer.setBuyerId(user.getId());
		buyer.setBossTel(account);
		buyerDao.insertBuyer(buyer);
	}

	@Override
	public int updatePassword(Long userId, String password) {
		return usersDao.updatePassword(userId, password);
	}
}