package com.netcai.buyer.vo;

import java.util.List;

/**
 * 订单列表VO
 * @author administrator
 */
public class OrderListVo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public String date;

	private List<OrderInfoVo> list;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<OrderInfoVo> getList() {
		return list;
	}
	public void setList(List<OrderInfoVo> list) {
		this.list = list;
	}
}