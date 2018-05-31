package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.netcai.admin.vo.GoodsFormatVo;

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
	 * 商品数量
	 */
    private Double goodsNumber;

    /**
	 * 商品金额
	 */
    private BigDecimal goodsAmount;

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
	private GoodsFormatVo goodsFormat;
	
	/**
	 * 加工方式
	 */
	private ProcessMethod processMethod;
	
	
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

    public Double getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Double goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
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


	public GoodsFormatVo getGoodsFormat() {
		return goodsFormat;
	}

	public void setGoodsFormat(GoodsFormatVo goodsFormat) {
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