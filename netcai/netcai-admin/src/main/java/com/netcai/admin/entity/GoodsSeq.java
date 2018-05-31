package com.netcai.admin.entity;

import java.io.Serializable;

/**
 * 商品顺序
 * @author administrator
 */
public class GoodsSeq implements Serializable{

    private static final long serialVersionUID = 1L;
	/**
	 * 商品ID
	 */
    private Long goodsId;
	/**
	 * 排序
	 */
	private Integer goodsSeq;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Integer goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
}
