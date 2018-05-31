package com.netcai.buyer.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 付款日志记录表
 * @author administrator
 */
public class PayLogs implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键，自动增加ID
	 */
	private Long logId;
	
	/**
	 * 付款的用户ID
	 */
	private Long userId;
	
	/**
	 * 订单ID，对应order_info中的Id
	 */
	private Long orderId;
	
	/**
	 * 订单编号
	 */
	private String orderNumber;
	
	/**
	 * 订单金额
	 */
	private BigDecimal orderAmount;
	
	/**
	 * 外部订单号，比如说支付宝交易订单号
	 */
	private String outerTradeNo;
	
	/**
	 * 支付状态，1为支付成功，-1为支付失败
	 */
	private int status;
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOuterTradeNo() {
		return outerTradeNo;
	}

	public void setOuterTradeNo(String outerTradeNo) {
		this.outerTradeNo = outerTradeNo;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}