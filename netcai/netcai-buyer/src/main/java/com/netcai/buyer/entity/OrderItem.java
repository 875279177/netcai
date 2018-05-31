package com.netcai.buyer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单的子项目
 * 
 * @author administrator
 */
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 8058734556895568614L;

	private Long id;
	/**
	 * 订单主表id,order_info表的order_id
	 */
	private Long orderId;
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	/**
	 * 订单项状态，1为已提交订单，2为取消订单
	 */
	private Integer orderStatus;
	/**
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 所属卖家ID
	 */
	private Long sellerId;
	/**
	 * 加工方式ID
	 */
	private Long methodId;
	/**
	 * 是否选择 (1是 -1否)
	 */
	private Integer isSelected;
	/**
	 * 配送类型，1为平台送,2.卖家自己送
	 */
	private Integer deliveryType;
	/**
	 * 卖家备货状态，0为备货中，1为备货完成,2为取消备货
	 */
	private Integer deliveryStatus;
	/**
	 * 卖家备货状态，1为备货中，2为备货完成,3为取消备货
	 */
	private Integer sellerStatus;
	/**
	 * 买家状态，1为已收货，2为换货，3为退货
	 */
	private Integer buyerStatus;
	/**
	 * 订单项备注，由用户提交订单前填写
	 */
	private String remark;
	/**
	 * 商品单价
	 */
	private BigDecimal goodsPrice;
	/**
	 * 订单商品初始数量
	 */
	private BigDecimal goodsNumberOld;
	/**
	 * 单项总金额
	 */
	private BigDecimal goodsAmount;
	/**
	 * 配送费用
	 */
	private BigDecimal deliveryMoney;
	/**
	 * 订单创建时间
	 */
	private Date createTime;
	/**
	 * 配送人员接受时间
	 */
	private Date deliveryReceiveTime;
	/**
	 * 配送人员完成时间
	 */
	private Date deliveryFinishTime;
	/**
	 * 卖家完成时间
	 */
	private Date sellerFinishTime;
	/**
	 * 买家完成时间
	 */
	private Date buyerFinishTime;
	/**
	 * 所属订单
	 */
	private OrderInfo orderInfo;
	/**
	 * 买家
	 */
	private Buyer buyer;
	/**
	 * 卖家
	 */
	private Seller seller;
	/**
	 * sku
	 */
	private GoodsFormat goodsFormat;
	/**
	 * 子项数量
	 */
	private BigDecimal goodsNumber;
	/**
	 * 购物车id
	 */
	private Long cartId;
	/**
	 * 团购明细ID
	 */
	private Long itemId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getFormatId() {
		return formatId;
	}

	public void setFormatId(Long formatId) {
		this.formatId = formatId;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public BigDecimal getDeliveryMoney() {
		return deliveryMoney;
	}

	public void setDeliveryMoney(BigDecimal deliveryMoney) {
		this.deliveryMoney = deliveryMoney;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getDeliveryReceiveTime() {
		return deliveryReceiveTime;
	}

	public void setDeliveryReceiveTime(Date deliveryReceiveTime) {
		this.deliveryReceiveTime = deliveryReceiveTime;
	}

	public Date getDeliveryFinishTime() {
		return deliveryFinishTime;
	}

	public void setDeliveryFinishTime(Date deliveryFinishTime) {
		this.deliveryFinishTime = deliveryFinishTime;
	}

	public Date getSellerFinishTime() {
		return sellerFinishTime;
	}

	public void setSellerFinishTime(Date sellerFinishTime) {
		this.sellerFinishTime = sellerFinishTime;
	}

	public Date getBuyerFinishTime() {
		return buyerFinishTime;
	}

	public void setBuyerFinishTime(Date buyerFinishTime) {
		this.buyerFinishTime = buyerFinishTime;
	}

	public OrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public GoodsFormat getGoodsFormat() {
		return goodsFormat;
	}

	public void setGoodsFormat(GoodsFormat goodsFormat) {
		this.goodsFormat = goodsFormat;
	}

	public OrderItem() {
		super();
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Integer getSellerStatus() {
		return sellerStatus;
	}

	public void setSellerStatus(Integer sellerStatus) {
		this.sellerStatus = sellerStatus;
	}

	public Integer getBuyerStatus() {
		return buyerStatus;
	}

	public void setBuyerStatus(Integer buyerStatus) {
		this.buyerStatus = buyerStatus;
	}

	public BigDecimal getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(BigDecimal goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public Long getMethodId() {
		return methodId;
	}

	public void setMethodId(Long methodId) {
		this.methodId = methodId;
	}

	public Integer getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Integer isSelected) {
		this.isSelected = isSelected;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getGoodsNumberOld() {
		return goodsNumberOld;
	}

	public void setGoodsNumberOld(BigDecimal goodsNumberOld) {
		this.goodsNumberOld = goodsNumberOld;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

}