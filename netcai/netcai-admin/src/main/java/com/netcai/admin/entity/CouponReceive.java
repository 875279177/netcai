package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 优惠券领取记录表
 */
public class CouponReceive implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1144560831602601473L;
	
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
     * 券额
     */
    private BigDecimal couponMoney;
    /**
     * 领取时间
     */
    private Date createTime;
    /**
     * 金额满
     */
    private BigDecimal fullMoney;
    /**
     * 状态，1为已使用，0为未使用
     */
    private Integer status;

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

    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getFullMoney() {
        return fullMoney;
    }

    public void setFullMoney(BigDecimal fullMoney) {
        this.fullMoney = fullMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}