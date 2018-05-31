package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 提现密码
 * @author administrator
 */
public class WithdrawalPassword implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private Long id;
	
	/**
	 * 用户ID
	 */
	private Long uid;
	
	/**
	 * 提现的密码
	 */
	private String password;
	
	/**
	 * 添加时间
	 */
	private Date createTime;
	
	/**
	 * 最后一次修改时间
	 */
	private Date lastUpdateTime;
	
	/**
	 * 用户
	 */
	private Users users;
	
	public WithdrawalPassword() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}