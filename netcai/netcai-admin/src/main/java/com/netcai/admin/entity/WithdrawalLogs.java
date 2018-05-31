package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户提现的操作记录表
 * @author administrator
 */
public class WithdrawalLogs implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 自动增加ID
	 */
	private Long id;
	/**
	 * 提现申请人
	 */
	private Long uid;
	/**
	 * 提现状态,1表示申请提现,2表示审批通过,3,交易完成,-1审批不通过.
	 */
	private int status;
	/**
	 * 提现订单号
	 */
	private String withdrawOrder;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 创建人
	 */
	public Long createBy;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 申请的用户
	 */
	private Users users;
	
	public WithdrawalLogs() {
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

	public String getWithdrawOrder() {
		return withdrawOrder;
	}

	public void setWithdrawOrder(String withdrawOrder) {
		this.withdrawOrder = withdrawOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
}