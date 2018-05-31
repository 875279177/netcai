package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.List;

public class OrderCategoryListVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sendDate;
	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 买家名称
	 */
	private String buyerName;
	
	private List<OrderCategoryItemVo> clist;

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public List<OrderCategoryItemVo> getClist() {
		return clist;
	}

	public void setClist(List<OrderCategoryItemVo> clist) {
		this.clist = clist;
	}

}
