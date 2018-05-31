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
public class OrderItemQuery implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7548768701666866881L;
	/**
	 * 买家店铺名称(也就是餐馆名称)
	 */
	private String buyerName;
	/**
	 * 餐馆地址
	 */
	private String buyerAddress;
	/**
	 * 老板电话号码
	 */
	private String bossTel;
	
	/**
	 * 账号,目前用手机号码作为账号
	 */
	private String sellerAccount;

	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	/**
	 * 下单时间
	 */
	private Date createTime;
	/**
	 * 收货人的最佳送货时间
	 */
	private Date bestTime;
	
	/**
	 * 订单原金额;
	 */
	private BigDecimal oldTotalMoney;
	/**
	 * 总计
	 */
	private BigDecimal totalMoney;
	
	/**
	 * 买家ID
	 */
	private Long buyerId;
	
	/**
	 * 所属卖家ID
	 */
	private Long sellerId;
	
	/**
	 * 订单主表id,order_info表的order_id
	 */
	private Long orderId;
	
	/**
	 * 详细订单;
	 */
	private List<OrderItem> orderItems;

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

	public String getBossTel() {
		return bossTel;
	}

	public void setBossTel(String bossTel) {
		this.bossTel = bossTel;
	}

	public String getSellerAccount() {
		return sellerAccount;
	}

	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	/*****************************query*******************************/
	/**
	 * 买家姓名或电话查询;
	 */
	private String buyerNameTel;
	/**
	 * 卖家姓名或电话查询;
	 */
	private String sellerNameTel;
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
	
	/**
	 * 交易状态;
	 */
	private Integer tradeStatus;
	
	/**
	 * 支付状态;
	 */
	private Integer payStatus;

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

	public Integer getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(Integer tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getBuyerNameTel() {
		return buyerNameTel;
	}

	public void setBuyerNameTel(String buyerNameTel) {
		this.buyerNameTel = buyerNameTel;
	}

	public String getSellerNameTel() {
		return sellerNameTel;
	}

	public void setSellerNameTel(String sellerNameTel) {
		this.sellerNameTel = sellerNameTel;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getBestTime() {
		return bestTime;
	}

	public void setBestTime(Date bestTime) {
		this.bestTime = bestTime;
	}

	public BigDecimal getOldTotalMoney() {
		return oldTotalMoney;
	}

	public void setOldTotalMoney(BigDecimal oldTotalMoney) {
		this.oldTotalMoney = oldTotalMoney;
	}
	
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 所属区
	 */
	private Long regionId;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	/**
	 * 支付状态；1，未付款；2，已付款, 3，线下付款，4 线下付款已收款',
	 */
	private String pStatus;
	/**
	 * 交易状态。0为进行中, 1,已完成，2,为取消交易,3,已结算',
	 */
	private String tStatus;

	public String getpStatus() {
		return pStatus;
	}
	public void setpStatus(String pStatus) {
		this.pStatus = pStatus;
	}
	public String gettStatus() {
		return tStatus;
	}
	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
	}
	
	/**
	 * 配送人員ID
	 */
	private Long deliveryId;

	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	
}
