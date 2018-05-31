package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基本信息
 * @author administrator
 */
public class Users implements Serializable{
	
	private static final long serialVersionUID = -2869034349247740496L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 账号，目前采用手机号码为账号
	 */
	private String account;

	/**
	 * 别名,可以理解为简称
	 */
	private String password;
	
	/**
	 * 状态，1为可用，-1为不可用
	 */
	private int status;
	
	/**
	 * 真实姓名
	 */
	private String trueName;
	
	/**
	 * 注册时间
	 */
	private Date createTime;
	
	/**
	 * 最后一次登录时间
	 */
	private Date lastLoginTime;
	
	/**
	 * 1为买家，2为卖家
	 */
	private int type;
	
	/**
	 * 所属区域
	 */
	private Long regionId;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Users [id=");
		builder.append(id);
		builder.append(", account=");
		builder.append(account);
		builder.append(", password=");
		builder.append(password);
		builder.append(", status=");
		builder.append(status);
		builder.append(", trueName=");
		builder.append(trueName);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append(", lastLoginTime=");
		builder.append(lastLoginTime);
		builder.append(", type=");
		builder.append(type);
		builder.append(", regionId=");
		builder.append(regionId);
		builder.append("]");
		return builder.toString();
	}
}