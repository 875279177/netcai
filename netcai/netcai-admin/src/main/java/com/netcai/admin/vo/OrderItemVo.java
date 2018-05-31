package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.netcai.admin.entity.OrderItem;
/**
 * @author administrator
 *
 */
public class OrderItemVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3416003870467304498L;

	/**
	 * 订单项
	 */
	private List<OrderItem> orderItems;
	
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	/**
	 * 餐馆地址
	 */
	private String buyerAddress;
	/**
	 * 客户的类型，1为火锅店，2为小餐馆，3为中餐馆，4,为烧烤
	 */
	private Integer buyerType;
	/**
	 * 客户级别，1为A类客户,2为B类客户,3为C类客户
	 */
	private Integer buyerLevel;
	/**
	 * 老板电话号码
	 */
	private String bossTel;
	/**
	 * 老板名称(买家姓名)
	 */
	private String bossName;
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	/**
	 * 支付状态；1，未付款；2，已付款, 3，线下付款，4 线下付款已收款',
	 */
	private Integer payStatus;
	/**
	 * 订单项状态，1为已提交订单，2为取消订单
	 */
	private Integer orderStatus;
	/**
	 * 买家状态，1为已收货，2为换货，3为退货
	 */
	private Integer buyerStatus;
	/**
	 * 配送费用
	 */
	private BigDecimal deliveryMoney;
	/**
	 * 配送类型，1为平台送,2.卖家自己送
	 */
	private Integer deliveryType;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 总计
	 */
	private BigDecimal totalMoney;

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
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

	public Integer getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(Integer buyerType) {
		this.buyerType = buyerType;
	}

	public Integer getBuyerLevel() {
		return buyerLevel;
	}

	public void setBuyerLevel(Integer buyerLevel) {
		this.buyerLevel = buyerLevel;
	}

	public String getBossTel() {
		return bossTel;
	}

	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}

	public String getBossName() {
		return bossName;
	}

	public void setBossName(String bossName) {
		this.bossName = bossName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getBuyerStatus() {
		return buyerStatus;
	}

	public void setBuyerStatus(Integer buyerStatus) {
		this.buyerStatus = buyerStatus;
	}

	public BigDecimal getDeliveryMoney() {
		return deliveryMoney;
	}

	public void setDeliveryMoney(BigDecimal deliveryMoney) {
		this.deliveryMoney = deliveryMoney;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

}
