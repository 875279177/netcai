package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class BuyerSellerRelation implements Serializable{
    /**
	 */
	private static final long serialVersionUID = 1216204479184652378L;

	private Long id;

    /**
     * 卖家
     */
    private Long sellerId;
    
    private Seller seller;

    /**
     * 买家
     */
    private Long buyerId;
    
    private Buyer buyer;

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

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	/**所属区
     */
    private String areaName;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
}