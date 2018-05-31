package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户提现的操作记录表
 * @author administrator
 */
public class Withdrawal implements Serializable{
	
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
	 * 银行卡对应的姓名
	 */
	private String applyer;
	
	/**
	 * 提现订单号
	 */
	private String withdrawOrder;
	
	/**
	 * 用户对应的设置的银行卡的ID
	 */
	private String withdrawBankId;
	
	/**
	 * 提现手续费
	 */
	private BigDecimal withdrawCharge;
	/**
	 * 实际提现金额
	 */
	private BigDecimal withdrawRealityTotal;
	
	/**
	 * 申请提现的金额
	 */
	private BigDecimal withdrawApplyTotal;
	
	/**
	 * 申请提现的时间
	 */
	private Date withdrawApplyTime;
	
	/**
	 * 提现状态,1表示申请提现,2表示审批通过,3,交易完成,-1审批不通过.
	 */
	private int status;
	
	/**
	 * 理由
	 */
	private String reason;
	
	/**
	 * 创建人
	 */
	public Long createBy;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 更新人
	 */
	private Long updateBy;
	
	/**
	 * 更新时间
	 */
	private Date lastUpdateTime;
	
	/**
	 * 申请的用户
	 */
	private Users users;
	
	/**
	 * 提现的银行
	 */
	private WithdrawalBank withdrawalBank;
	
	/**
	 * 接收前台的createTime转为Date传入后台查询；
	 */
	private String queryDate;
	
	/**
	 * 店铺名称
	 */
	private String  shopName;
	
	public Withdrawal() {
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

	public String getApplyer() {
		return applyer;
	}

	public void setApplyer(String applyer) {
		this.applyer = applyer;
	}

	public String getWithdrawOrder() {
		return withdrawOrder;
	}

	public void setWithdrawOrder(String withdrawOrder) {
		this.withdrawOrder = withdrawOrder;
	}

	public String getWithdrawBankId() {
		return withdrawBankId;
	}

	public void setWithdrawBankId(String withdrawBankId) {
		this.withdrawBankId = withdrawBankId;
	}

	public BigDecimal getWithdrawApplyTotal() {
		return withdrawApplyTotal;
	}

	public void setWithdrawApplyTotal(BigDecimal withdrawApplyTotal) {
		this.withdrawApplyTotal = withdrawApplyTotal;
	}

	public Date getWithdrawApplyTime() {
		return withdrawApplyTime;
	}

	public void setWithdrawApplyTime(Date withdrawApplyTime) {
		this.withdrawApplyTime = withdrawApplyTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
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

	public WithdrawalBank getWithdrawalBank() {
		return withdrawalBank;
	}

	public void setWithdrawalBank(WithdrawalBank withdrawalBank) {
		this.withdrawalBank = withdrawalBank;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public BigDecimal getWithdrawCharge() {
		return withdrawCharge;
	}

	public void setWithdrawCharge(BigDecimal withdrawCharge) {
		this.withdrawCharge = withdrawCharge;
	}

	public BigDecimal getWithdrawRealityTotal() {
		return withdrawRealityTotal;
	}

	public void setWithdrawRealityTotal(BigDecimal withdrawRealityTotal) {
		this.withdrawRealityTotal = withdrawRealityTotal;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
}