package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.List;

import com.netcai.admin.entity.GoodsCart;

public class GoodsCartVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 369926165878007822L;

	
	/**
	 * 关联user表中的id
	 */
	private Long buyerId;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	
	
	/**
	 * 老板名称(买家姓名)
	 */
	private String bossName;
	
    /**
     * 购物车集合
     */
    private List<GoodsCart> goodsCarts;

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}


	public List<GoodsCart> getGoodsCarts() {
		return goodsCarts;
	}

	public void setGoodsCarts(List<GoodsCart> goodsCarts) {
		this.goodsCarts = goodsCarts;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

    
    
}
