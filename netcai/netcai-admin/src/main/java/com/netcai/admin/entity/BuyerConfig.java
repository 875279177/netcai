package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 买家拒收商家
 * @author administrator
 *
 */
public class BuyerConfig implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5894610129367005370L;

	private Long id;

	/**
	 * 买家ID
	 */
    private Long buyerId;

    /**
     * 卖家ID
     */
    private Long sellerId;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}