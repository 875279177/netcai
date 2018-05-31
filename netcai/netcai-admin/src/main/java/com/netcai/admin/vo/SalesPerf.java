package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 销售人员绩效
 */
public class SalesPerf implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7324786190128294191L;
	
	private Long salesId;
	/**
	 * 真实姓名
	 */
	private String trueName;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	/**
	 * 总合计
	 */
	private BigDecimal sumAmount;
	/**
	 * 查询时间;
	 */
	private Date createTime;
	/**
	 * 送货时间;
	 */
	private Date bestTime;
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public BigDecimal getSumAmount() {
		return sumAmount;
	}
	public void setSumAmount(BigDecimal sumAmount) {
		this.sumAmount = sumAmount;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getBestTime() {
		return bestTime;
	}
	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}
	
	/**
	 * 下单时间开始;
	 */
	private String createTimeStart;
	
	/**
	 * 下单时间结束;
	 */
	private String createTimeStop;
	
	/**
	 * 最佳收货时间开始;
	 */
	private String beatTimeStart;
	
	/**
	 * 最佳收货时间结束;
	 */
	private String beatTimeStop;

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
	public String getBeatTimeStart() {
		return beatTimeStart;
	}
	public void setBeatTimeStart(String beatTimeStart) {
		this.beatTimeStart = beatTimeStart;
	}
	public String getBeatTimeStop() {
		return beatTimeStop;
	}
	public void setBeatTimeStop(String beatTimeStop) {
		this.beatTimeStop = beatTimeStop;
	}
	public Long getSalesId() {
		return salesId;
	}
	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}
	
}
