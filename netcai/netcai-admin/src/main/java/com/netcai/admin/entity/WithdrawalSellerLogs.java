package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 提现平台补手续费记录实体
 * @author administrator
 *
 */
public class WithdrawalSellerLogs implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 提现订单号
	 */
	private String withdrawOrder;
	/**
	 * 提现金额
	 */
	private BigDecimal withdrawApplyTotal;
	/**
	 * 手续费
	 */
	private BigDecimal withdrawCharge;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getWithdrawOrder() {
		return withdrawOrder;
	}

	public void setWithdrawOrder(String withdrawOrder) {
		this.withdrawOrder = withdrawOrder;
	}

	public BigDecimal getWithdrawApplyTotal() {
		return withdrawApplyTotal;
	}

	public void setWithdrawApplyTotal(BigDecimal withdrawApplyTotal) {
		this.withdrawApplyTotal = withdrawApplyTotal;
	}

	public BigDecimal getWithdrawCharge() {
		return withdrawCharge;
	}

	public void setWithdrawCharge(BigDecimal withdrawCharge) {
		this.withdrawCharge = withdrawCharge;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
