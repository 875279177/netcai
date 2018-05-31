package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.List;

import com.netcai.buyer.entity.GoodsCart;

public class GoodsListVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2024011567608945523L;

	private List<GoodsCart> list;
	
	private Long userId;
	
	private Long sellerId;

	public List<GoodsCart> getList() {
		return list;
	}

	public void setList(List<GoodsCart> list) {
		this.list = list;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	
}
