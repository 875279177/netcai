package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 优惠券消费记录表
 */
public class CouponLogs implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 787725471111513239L;
	
	private Long id;
    /**
	 * 买家ID
	 */
    private Long buyerId;
    /**
	 * 优惠券编号
	 */
    private Long couponId;
    /**
	 * 订单号
	 */
    private String orderNumber;
    /**
	 * 抵扣优惠券之后的订单金额
	 */
    private BigDecimal orderFinalAmount;
    /**
	 * 订单金额
	 */
    private BigDecimal orderAmount;
    /**
	 * 优惠券的金额
	 */
    private BigDecimal couponAmount;
    /**
	 * 领取时间
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

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public BigDecimal getOrderFinalAmount() {
		return orderFinalAmount;
	}

	public void setOrderFinalAmount(BigDecimal orderFinalAmount) {
		this.orderFinalAmount = orderFinalAmount;
	}

	public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}