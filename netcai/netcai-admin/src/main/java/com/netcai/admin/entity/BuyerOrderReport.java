package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 统计买家每日订单金额
 */
public class BuyerOrderReport implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -987309458615193459L;
	
	private Long id;
	/**创建时间
	 */
    private Date today;

    /**买家Id
     */
    private Long buyerId;

    /**下单金额
     */
    private BigDecimal orderMoney;

    /**是否预警（0为警告，1为正常）
     */
    private Integer warn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Integer getWarn() {
        return warn;
    }

    public void setWarn(Integer warn) {
        this.warn = warn;
    }
}