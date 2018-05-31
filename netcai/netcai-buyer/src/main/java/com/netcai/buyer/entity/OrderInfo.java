package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单信息表(订单主表)
 * 订单的配送，贺卡等详细信息
 * @author administrator
 */
public class OrderInfo implements Serializable {

	private static final long serialVersionUID = 8058734556895568614L;

	/**
	 * 订单主表id,order_info表的order_id
	 */
	private Long orderId;
	/**
	 * 订单类型(0普通订单 1团购订单)
	 */
	private Short orderType;
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 交易状态。0为进行中, 1,已完成，2为取消交易
	 */
	private int tradeStatus;
	/**
	 * 支付状态；1，未付款；2，已付款
	 */
	private int payStatus;
	/**
	 * 收货人的最佳送货时间
	 */
	private Date bestTime;
	/**
	 * 订单项备注，由用户提交订单前填写
	 */
	private String remark;
	/**
	 * 订单金额
	 */
	private BigDecimal orderAmount;
	
	/**
	 * 付款金额
	 */
	private BigDecimal payAmount;
	/**
	 * 商品最终金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 订单支付时间
	 */
	private Date payTime;
	/**
	 * 卡的所有者
	 */
	private String cardOwner;
	/**
	 * 卡的编码
	 */
	private String cardCode;
	/**
	 * 卡名称
	 */
	private String cardName;
	/**
	 * 卡号
	 */
	private String cardNumber;
	/**
	 * 交易订单号，比如支付宝给我平台的订单号
	 */
	private String outerTradeNo;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 订单的子项目
	 */
	private List<OrderItem> orderItem;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Short getOrderType() {
		return orderType;
	}

	public void setOrderType(Short orderType) {
		this.orderType = orderType;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public int getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(int tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public int getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	public Date getBestTime() {
		return bestTime;
	}

	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getCardOwner() {
		return cardOwner;
	}

	public void setCardOwner(String cardOwner) {
		this.cardOwner = cardOwner;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getOuterTradeNo() {
		return outerTradeNo;
	}

	public void setOuterTradeNo(String outerTradeNo) {
		this.outerTradeNo = outerTradeNo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<OrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
}