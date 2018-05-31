package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户设置的卡
 */
public class WithdrawalBank implements Serializable{
	
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
	 * 中文姓名
	 */
	private String cnname;
	
	/**
	 * 卡的缩写
	 */
	private  String bankCode;
	
	/**
	 * 卡的名称
	 */
	private  String bankName;
	
	/**
	 * 卡号
	 */
	private  String bankNumber;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 申请的用户
	 */
	private Users users;

	public WithdrawalBank() {
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

	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}