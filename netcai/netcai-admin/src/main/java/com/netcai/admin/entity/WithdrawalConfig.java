package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 卖家提款支付宝手续费配置
 * 
 * @author administrator
 *
 */
public class WithdrawalConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 描述
	 */
	private String remarks;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
