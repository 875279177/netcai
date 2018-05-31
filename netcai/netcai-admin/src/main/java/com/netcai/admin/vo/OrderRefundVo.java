package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderRefundVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 买家id
	 */
	private Long buyerId;
	/**
	 * 卖家id
	 */
	private Long sellerId;
	/**
	 * 销售id
	 */
	private Long saleId;
	/**
	 * 买家餐馆名称
	 */
	private String buyerName;
	/**
	 * 卖家店铺名称
	 */
	private String sellerName;
	/**
	 * 销售姓名
	 */
	private String salesName;
	/**
	 * 卖家交易金额
	 */
	private BigDecimal sellerMoney;
	/**
	 * 买家交易金额
	 */
	private BigDecimal buyerMoney;
	/**
	 * 退换原因id(多个拼接)
	 */
	private String refundCauseIds;
	/**
	 * 退换原因
	 */
	private String reason;
	/**
	 * 备注说明
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 1为显示；0为不显示
	 */
	private int isShow;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSalesName() {
		return salesName;
	}

	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}

	public BigDecimal getSellerMoney() {
		return sellerMoney;
	}

	public void setSellerMoney(BigDecimal sellerMoney) {
		this.sellerMoney = sellerMoney;
	}

	public BigDecimal getBuyerMoney() {
		return buyerMoney;
	}

	public void setBuyerMoney(BigDecimal buyerMoney) {
		this.buyerMoney = buyerMoney;
	}

	public String getRefundCauseIds() {
		return refundCauseIds;
	}

	public void setRefundCauseIds(String refundCauseIds) {
		this.refundCauseIds = refundCauseIds;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getIsShow() {
		return isShow;
	}

	public void setIsShow(int isShow) {
		this.isShow = isShow;
	}

}
