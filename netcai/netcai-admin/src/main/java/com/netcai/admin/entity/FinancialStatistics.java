package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinancialStatistics implements Serializable{

	private static final long serialVersionUID = 4514401442628162776L;

	/**
	 *时间
	 */
	private String time;
	/**
	 * 区域名称
	 */
	private String names;
	/**
	 * 区域Id
	 */
	private Long areaId;
	/**
	 * 注册用户
	 */
	private Long newUser;
	/**
	 * 月活跃用户
	 */
	private Long activeUser;
	/**
	 * 下订单频率
	 */
	private Long hz;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	public Long getNewUser() {
		return newUser;
	}
	public void setNewUser(Long newUser) {
		this.newUser = newUser;
	}
	public Long getActiveUser() {
		return activeUser;
	}
	public void setActiveUser(Long activeUser) {
		this.activeUser = activeUser;
	}
	public Long getHz() {
		return hz;
	}
	public void setHz(Long hz) {
		this.hz = hz;
	}
	
	/**
	 * 客户级别，1为A类客户,2为B类客户,3为C类客户
	 */
	private Integer buyerLevel;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;

	public Integer getBuyerLevel() {
		return buyerLevel;
	}
	public void setBuyerLevel(Integer buyerLevel) {
		this.buyerLevel = buyerLevel;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 数量
	 */
	private Long goodsNum;
	/**
	 * 金额
	 */
	private BigDecimal money;

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Long getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Long goodsNum) {
		this.goodsNum = goodsNum;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
}
