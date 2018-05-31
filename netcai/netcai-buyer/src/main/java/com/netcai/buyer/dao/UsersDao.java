package com.netcai.buyer.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Users;

/**
 * UserDAO
 * @author administrator
 */
public interface UsersDao {

	/**
	 * 查询用户对象根据Uid
	 * 
	 * @param users
	 */
	public Users getUsersById(Long userId);

	/**
	 * 查询用户对象根据account
	 * 
	 * @param users
	 */
	public Users getUsersByAccount(String account);

	/**
	 * 添加
	 * 
	 * @param users
	 */
	public int insertUsers(Users users);
	
	/**
	 * 更新用户的状态
	 * @param userId
	 * @param status
	 */
	public void updateUsersStatus(@Param("userId") Long userId,@Param("status")  int status);
	
	/**
	 * 重置用户登录密码
	 * @param userId
	 * @param password
	 * @return
	 */
    public int updatePassword(@Param("userId") Long userId,@Param("password") String password);
}