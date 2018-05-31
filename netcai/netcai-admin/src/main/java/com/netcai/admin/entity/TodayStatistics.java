package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class TodayStatistics implements Serializable{
	
	private static final long serialVersionUID = -3874051746746660133L;
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
	 * 今日订单量
	 */
	private Long orderNum;
	/**
	 * 用户量
	 */
	private Long userNum;
	/**
	 * 金额
	 */
	private BigDecimal money;
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
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public Long getUserNum() {
		return userNum;
	}
	public void setUserNum(Long userNum) {
		this.userNum = userNum;
	}
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
}
