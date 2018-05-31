package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.List;

public class TransactionDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 卖家商铺名称
	 */
	private String sellerName;
	/**
	 * 卖家商铺logo图片
	 */
	private String sellerLogo;

	/**
	 * 商品详细信息集合
	 */
	private List<GoodsDetailsVo> goodsDetailList;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerLogo() {
		return sellerLogo;
	}

	public void setSellerLogo(String sellerLogo) {
		this.sellerLogo = sellerLogo;
	}

	public List<GoodsDetailsVo> getGoodsDetailList() {
		return goodsDetailList;
	}

	public void setGoodsDetailList(List<GoodsDetailsVo> goodsDetailList) {
		this.goodsDetailList = goodsDetailList;
	}

}
