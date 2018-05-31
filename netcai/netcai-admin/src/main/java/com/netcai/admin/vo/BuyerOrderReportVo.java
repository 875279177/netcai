package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 统计买家每日订单金额
 */
public class BuyerOrderReportVo implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -987309458615193459L;
	
	 /**店铺名称;
     */
    private String name;
    
    /**买家Id
     */
    private Long buyerId;

    /**今天金额;
     */
    private BigDecimal today;
    
    /**昨天金额;
     */
    private BigDecimal yesterday;
    
    /**前天金额;
     */
    private BigDecimal anteayer;

    /**今天预警（0为警告，1为正常）
     */
    private Integer warnT;
    
    /**昨天预警（0为警告，1为正常）
     */
    private Integer warnY;
    
    /**前天预警（0为警告，1为正常）
     */
    private Integer warnV;
    
    /**所属区Id
     */
    private Integer areaId;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getToday() {
		return today;
	}


	public void setToday(BigDecimal today) {
		this.today = today;
	}


	public BigDecimal getYesterday() {
		return yesterday;
	}


	public void setYesterday(BigDecimal yesterday) {
		this.yesterday = yesterday;
	}


	public BigDecimal getAnteayer() {
		return anteayer;
	}


	public void setAnteayer(BigDecimal anteayer) {
		this.anteayer = anteayer;
	}


	public Integer getAreaId() {
		return areaId;
	}


	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


	public Integer getWarnT() {
		return warnT;
	}


	public void setWarnT(Integer warnT) {
		this.warnT = warnT;
	}


	public Integer getWarnY() {
		return warnY;
	}


	public void setWarnY(Integer warnY) {
		this.warnY = warnY;
	}


	public Integer getWarnV() {
		return warnV;
	}


	public void setWarnV(Integer warnV) {
		this.warnV = warnV;
	}


	public Long getBuyerId() {
		return buyerId;
	}


	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	/****************************************************query****************************************************************************/
	
	 /**时间
     */
    private Integer time;
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
    
	 /**时间
     */
    private Date dateTime;
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
    
}