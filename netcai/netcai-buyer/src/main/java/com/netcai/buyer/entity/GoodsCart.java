package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车
 * @author administrator
 */
public class GoodsCart implements Serializable{
	
	private static final long serialVersionUID = 7078019879911908296L;

	/**
	 * 
	 */
    private Long cartId;
	/**
	 * 买家ID
	 */
    private Long buyerId;

    /**
	 * 商品规格id
	 */
    private Long formatId;

    /**
	 * 所属卖家ID
	 */
    private Long sellerId;
    
    /**
	 * 店铺名称
	 */
    private String sellerName;


    /**
	 * 商品数量
	 */
    private BigDecimal goodsNumber;


    /**
	 * 加工方式ID
	 */
    private Long methodId;
    
    /**
	 * 是否选择 (1是 -1否)
	 */
    private Integer isSelected;

    /**
	 * 创建时间
	 */
    private Date createTime;
    
    /**
	 * 查询创建时间
	 */
    private String queryTime;

    /**
	 * 买家 
	 */
	private Buyer buyer;
	
	/**
	 * 卖家
	 */
	private Seller seller;
	
	/**
	 *sku
	 */
	private GoodsFormat goodsFormat;
	
	/**
	 * 加工方式
	 */
	private ProcessMethod processMethod;
	
	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getFormatId() {
        return formatId;
    }

    public void setFormatId(Long formatId) {
        this.formatId = formatId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public BigDecimal getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(BigDecimal goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public GoodsFormat getGoodsFormat() {
		return goodsFormat;
	}

	public void setGoodsFormat(GoodsFormat goodsFormat) {
		this.goodsFormat = goodsFormat;
	}

	public String getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}

	public Long getMethodId() {
		return methodId;
	}

	public void setMethodId(Long methodId) {
		this.methodId = methodId;
	}

	public Integer getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Integer isSelected) {
		this.isSelected = isSelected;
	}

	public ProcessMethod getProcessMethod() {
		return processMethod;
	}

	public void setProcessMethod(ProcessMethod processMethod) {
		this.processMethod = processMethod;
	}

	
    
}