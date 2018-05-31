package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.List;

public class GoodsCartVo implements Serializable{

	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -2278586556310041179L;

	/**
     * 购物车集合
     */
    private List<ProductVo> productVos;
    
	/**
	 * 卖家 店铺名称
	 */
	private String sellerName;

    /**
	 * 卖家Id
	 */
    private Long sellerId ;
    /**
	 * 收货地址
	 */
    private String buyerAddress ;

    /**
	 * 店铺logo
	 */
	private String sellerLogo;

	public List<ProductVo> getProductVos() {
		return productVos;
	}

	public void setProductVos(List<ProductVo> productVos) {
		this.productVos = productVos;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerLogo() {
		return sellerLogo;
	}

	public void setSellerLogo(String sellerLogo) {
		this.sellerLogo = sellerLogo;
	}

	public String getBuyerAddress() {
		return buyerAddress;
	}

	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}

}
