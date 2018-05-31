package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
/**
 *统计买家订单报表;
 */
public class ReportBuyerVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6871202508116896156L;
	/**
	 * 关联user表中的id
	 */
	private Long buyerId;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	/**
	 * 餐馆地址
	 */
	private String buyerAddress;
	/**
	 * 老板名称(买家姓名)
	 */
	private String bossName;
	/**
	 * 老板电话号码
	 */
	private String bossTel;
	/**
	 * 配送区域名称
	 */
	private String deliveryAreaName;
	/**
	 * 区名称
	 */
	private String regionName;
	/**
	 * 订单频次;
	 */
	private Integer frequency;
	/**
	 * 均价;
	 */
	private BigDecimal avgMoney;
	/**
	 * 总价;
	 */
	private BigDecimal totalMoney;
	
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerAddress() {
		return buyerAddress;
	}
	public void setBuyerAddress(String buyerAddress) {
		this.buyerAddress = buyerAddress;
	}
	public String getBossName() {
		return bossName;
	}
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	public String getBossTel() {
		return bossTel;
	}
	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}
	public String getDeliveryAreaName() {
		return deliveryAreaName;
	}
	public void setDeliveryAreaName(String deliveryAreaName) {
		this.deliveryAreaName = deliveryAreaName;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public Integer getFrequency() {
		return frequency;
	}
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	public BigDecimal getAvgMoney() {
		return avgMoney;
	}
	public void setAvgMoney(BigDecimal avgMoney) {
		this.avgMoney = avgMoney;
	}
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	
	/*******************************query***************************************/
	
	/**
	 * 区Id
	 */
	private Long regionId;
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}


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

	
	/**
	 * 下单频次;
	 */
	private Integer more;
	/**
	 * 下单频次;
	 */
	private Integer less;
	
	public Integer getMore() {
		return more;
	}
	public void setMore(Integer more) {
		this.more = more;
	}
	public Integer getLess() {
		return less;
	}
	public void setLess(Integer less) {
		this.less = less;
	}
	
}
