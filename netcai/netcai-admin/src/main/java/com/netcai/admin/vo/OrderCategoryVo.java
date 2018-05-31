package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrderCategoryVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String sendDate;
	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 买家名称
	 */
	private String buyerName;
	/**
	 * 买家数量
	 */
    private Integer buyerNum;
	/**
	 * 订单金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 蔬菜类
	 */
	private BigDecimal itemAmount1;
	/**
	 * 禽肉快捷菜
	 */
	private BigDecimal itemAmount2;
	/**
	 * 蛋类
	 */
	private BigDecimal itemAmount3;
	/**
	 * 米面粮油
	 */
	private BigDecimal itemAmount4;
	/**
	 * 冰鲜冻品
	 */
	private BigDecimal itemAmount5;
	/**
	 * 干货调料
	 */
	private BigDecimal itemAmount6;
	/**
	 * 酒水饮料
	 */
	private BigDecimal itemAmount7;
	/**
	 * 水产海鲜
	 */
	private BigDecimal itemAmount8;
	/**
	 * 豆制品
	 */
	private BigDecimal itemAmount9;
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
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
	public Integer getBuyerNum() {
		return buyerNum;
	}
	public void setBuyerNum(Integer buyerNum) {
		this.buyerNum = buyerNum;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BigDecimal getItemAmount1() {
		return itemAmount1;
	}
	public void setItemAmount1(BigDecimal itemAmount1) {
		this.itemAmount1 = itemAmount1;
	}
	public BigDecimal getItemAmount2() {
		return itemAmount2;
	}
	public void setItemAmount2(BigDecimal itemAmount2) {
		this.itemAmount2 = itemAmount2;
	}
	public BigDecimal getItemAmount3() {
		return itemAmount3;
	}
	public void setItemAmount3(BigDecimal itemAmount3) {
		this.itemAmount3 = itemAmount3;
	}
	public BigDecimal getItemAmount4() {
		return itemAmount4;
	}
	public void setItemAmount4(BigDecimal itemAmount4) {
		this.itemAmount4 = itemAmount4;
	}
	public BigDecimal getItemAmount5() {
		return itemAmount5;
	}
	public void setItemAmount5(BigDecimal itemAmount5) {
		this.itemAmount5 = itemAmount5;
	}
	public BigDecimal getItemAmount6() {
		return itemAmount6;
	}
	public void setItemAmount6(BigDecimal itemAmount6) {
		this.itemAmount6 = itemAmount6;
	}
	public BigDecimal getItemAmount7() {
		return itemAmount7;
	}
	public void setItemAmount7(BigDecimal itemAmount7) {
		this.itemAmount7 = itemAmount7;
	}
	public BigDecimal getItemAmount8() {
		return itemAmount8;
	}
	public void setItemAmount8(BigDecimal itemAmount8) {
		this.itemAmount8 = itemAmount8;
	}
	public BigDecimal getItemAmount9() {
		return itemAmount9;
	}
	public void setItemAmount9(BigDecimal itemAmount9) {
		this.itemAmount9 = itemAmount9;
	}
}
