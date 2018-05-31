package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单的子项目
 * @author administrator
 *
 */
public class OrderItem implements Serializable{

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
	 * 配送人员ID
	 */
	private Long deliveryId;
	/**
	 * 配送人员姓名
	 */
	private String deliveryName;
	/**
	 * 配送类型，1为平台送,2.卖家自己送
	 */
	private Integer deliveryType;
	/**
	 * 配送状态：0 表示未收货，1表示已收货,送货中，2表示已收货，已送货
	 */
	private Integer deliveryStatus;
	/**
	 * 卖家备货状态：0为备货中，1为备货完成,2为缺货,3为配送师傅点击缺货，4为补货，5为不补货
	 */
	private Integer sellerStatus;
	/**
	 * 买家状态：0待收货，1为已收货，2为换货，3.退还中，4，退还完成，卖家未确认，5，卖家确认，退货完成
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
	 * 商品原金额
	 */
	private BigDecimal goodsAmountOld;
	/**
	 * 商品金额
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
	 *所属订单 
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
	 *sku
	 */
	private GoodsFormat goodsFormat;
	/**
	 * 订单商品初始数量
	 */
	private Double goodsNumberOld;
	/**
	 * 子项数量
	 */
	private Double goodsNumber;
	/**
	 * 名称
	 */
	private String formatName;
	/**
	 * 单位名称
	 */
	private String methodName;
	/**
	 * 单位名称
	 */
	private String unitName;
	/**
	 * 商品名称
	 */
	private String goodsName;
	
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

	public Double getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(Double goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
/************************************query*****************************************/

	
	public Long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Long deliveryId) {
		this.deliveryId = deliveryId;
	}

	/**
	 * 下单时间开始;
	 */
	private String createTimeStart;
	
	/**
	 * 下单时间结束;
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

	public Double getGoodsNumberOld() {
		return goodsNumberOld;
	}

	public void setGoodsNumberOld(Double goodsNumberOld) {
		this.goodsNumberOld = goodsNumberOld;
	}

	public BigDecimal getGoodsAmountOld() {
		return goodsAmountOld;
	}

	public void setGoodsAmountOld(BigDecimal goodsAmountOld) {
		this.goodsAmountOld = goodsAmountOld;
	}
	
	/**
	 * 规格数量
	 */
	private Double formatNum;

	public Double getFormatNum() {
		return formatNum;
	}

	public void setFormatNum(Double formatNum) {
		this.formatNum = formatNum;
	}
	
	/**
	 * 最佳送货时间;
	 */
	private String bestTime;

	public String getBestTime() {
		return bestTime;
	}

	public void setBestTime(String bestTime) {
		this.bestTime = bestTime;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	/**所属区
     */
    private Long regionId;

	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	/**所属区
     */
    private String areaName;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	
	/**
	 * 支付状态；1，未付款；2，已付款, 3，线下付款，4 线下付款已收款',
	 */
	private String payStatus;

	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

}
