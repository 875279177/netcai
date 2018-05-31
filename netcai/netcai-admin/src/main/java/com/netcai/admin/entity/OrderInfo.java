package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 订单的配送，贺卡等详细信息
 * @author administrator
 *
 */
public class OrderInfo implements Serializable , Comparable<OrderInfo>{

	private static final long serialVersionUID = 8058734556895568614L;

	/**
	 * 订单主表id,order_info表的order_id
	 */
	private Long id;
	/**
	 * 唯一订单号
	 */
	private String orderNumber;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 交易状态。0为进行中, 1,已完成，2为取消交
	 */
	private Integer tradeStatus;
	/**
	 * 支付状态；1，未付款；2，已付款
	 */
	private Integer payStatus;
	/**
	 * 收货人的最佳送货时间
	 */
	private Date bestTime;
	/**
	 * 订单项备注，由用户提交订单前填写
	 */
	private String remark;
	/**
	 * 商品总金额
	 */
	private BigDecimal totalAmount;
	/**
	 * 应付款金额
	 */
	private BigDecimal orderAmount;
	/**
	 * 支付金额
	 */
	private BigDecimal payAmount;
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
	 * 订单类型
	 */
	private Integer orderType;
	/**
	 * 买家 
	 */
	private Buyer buyer;
	/**
	 * 卖家
	 */
	private Seller seller;
	/**
	 * 订单的子项目
	 */
	private List<OrderItem> orderItem;
	
	
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
	public List<OrderItem> getOrderItem() {
		return orderItem;
	}
	public void setOrderItem(List<OrderItem> orderItem) {
		this.orderItem = orderItem;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/*******************************************************query***************************************************/
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
	public BigDecimal getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}
	/********************************************************query***************************************************************************/
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
	 /**所属区
     */
    private String areaName;

	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
    
	/**是否是当天注册，当天下的单;0为不是,1为是;
     */
    private int newOrder;

	public int getNewOrder() {
		return newOrder;
	}
	public void setNewOrder(int newOrder) {
		this.newOrder = newOrder;
	}
	
	/**
	 * 配送人员姓名
	 */
	private String deliveryName;


	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	
	/**
	 * 销售人员姓名
	 */
	private String salesName;


	public String getSalesName() {
		return salesName;
	}
	public void setSalesName(String salesName) {
		this.salesName = salesName;
	}
	
	/**
	 * 时间查询;
	 */
	private String time;


	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	@Override
	public int compareTo(OrderInfo o) {
		 int i = o.getNewOrder() - this.getNewOrder();
	        if(i == 0){  
	            return this.newOrder - o.newOrder;
	        }  
	        return i;
	}
	public OrderInfo(Long id, String orderNumber, Long buyerId, Integer tradeStatus, Integer payStatus, Date bestTime,
			String remark, BigDecimal totalAmount, BigDecimal orderAmount, BigDecimal payAmount, Date payTime,
			String cardOwner, String cardCode, String cardName, String cardNumber, String outerTradeNo, Date createTime,
			Buyer buyer, Seller seller, List<OrderItem> orderItem, String createTimeStart, String createTimeStop,
			String beatTimeStart, String beatTimeStop, String pStatus, String tStatus, String areaName, Long regionId,
			int newOrder, String deliveryName, String salesName, String time) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.buyerId = buyerId;
		this.tradeStatus = tradeStatus;
		this.payStatus = payStatus;
		this.bestTime = bestTime;
		this.remark = remark;
		this.totalAmount = totalAmount;
		this.orderAmount = orderAmount;
		this.payAmount = payAmount;
		this.payTime = payTime;
		this.cardOwner = cardOwner;
		this.cardCode = cardCode;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.outerTradeNo = outerTradeNo;
		this.createTime = createTime;
		this.buyer = buyer;
		this.seller = seller;
		this.orderItem = orderItem;
		this.createTimeStart = createTimeStart;
		this.createTimeStop = createTimeStop;
		this.beatTimeStart = beatTimeStart;
		this.beatTimeStop = beatTimeStop;
		this.pStatus = pStatus;
		this.tStatus = tStatus;
		this.areaName = areaName;
		this.regionId = regionId;
		this.newOrder = newOrder;
		this.deliveryName = deliveryName;
		this.salesName = salesName;
		this.time = time;
	}
	public OrderInfo() {
		super();
	}
	
	/**销售人员Id
     */
    private Long saleId;


	public Long getSaleId() {
		return saleId;
	}
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
}
