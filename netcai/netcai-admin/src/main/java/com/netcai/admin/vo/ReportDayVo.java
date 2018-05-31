package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 统计每天订单报表
 */
public class ReportDayVo implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = 7987395959842351937L;

	private Long dayId;

    /**创建时间
     */
    private Date today;
    
    /**订单数（卖家-买家）
     */
    private Integer orderNum;
    
    /**订单总金额
     */
    private BigDecimal orderAmount;
    
    /**购买商家总数
     */
    private Integer sellerNum;
    
    /**客单价
     */
    private BigDecimal perAmount;
    
    /**订单均价(订单总额/order_num)
     */
    private BigDecimal avAmount;
    
    /**昨天注册，今天下单的买家数量;
     */
    private Integer newBuyerNum;
    
    /**新注册买家
     */
    private Integer newBuyer;
    
    /**所属区
     */
    private String areaName;
    
    /**所属区Id
     */
    private Integer areaId;

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

	public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getSellerNum() {
        return sellerNum;
    }

    public void setSellerNum(Integer sellerNum) {
        this.sellerNum = sellerNum;
    }

    public BigDecimal getPerAmount() {
        return perAmount;
    }

    public void setPerAmount(BigDecimal perAmount) {
        this.perAmount = perAmount;
    }

    public BigDecimal getAvAmount() {
        return avAmount;
    }

    public void setAvAmount(BigDecimal avAmount) {
        this.avAmount = avAmount;
    }

    public Integer getNewBuyerNum() {
        return newBuyerNum;
    }

    public void setNewBuyerNum(Integer newBuyerNum) {
        this.newBuyerNum = newBuyerNum;
    }

    public Integer getNewBuyer() {
        return newBuyer;
    }

    public void setNewBuyer(Integer newBuyer) {
        this.newBuyer = newBuyer;
    }

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/***********************************************************query***********************************************************************************/
	
	/**
	 * 时间开始;
	 */
	private String createTimeStart;
	
	/**
	 * 时间结束;
	 */
	private String createTimeStop;

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeStop() {
		return createTimeStop;
	}

	public void setCreateTimeStop(String createTimeStop) {
		this.createTimeStop = createTimeStop;
	}

}