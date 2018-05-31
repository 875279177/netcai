package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.Date;

import com.netcai.admin.entity.Buyer;
import com.netcai.admin.entity.Goods;
/**
 * 常用清单;
 */
public class BuyerCommonVo implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -5894610129367005370L;

	private Long bcId;

	/**
	 * 买家ID
	 */
    private Long buyerId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 创建时间
     */
    private Date createTime;
    
    /**
     * 商品
     */
    private Goods goods;
    
	/**
	 * 买家 
	 */
	private Buyer buyer;
    
	public Long getBcId() {
		return bcId;
	}

	public void setBcId(Long bcId) {
		this.bcId = bcId;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
}