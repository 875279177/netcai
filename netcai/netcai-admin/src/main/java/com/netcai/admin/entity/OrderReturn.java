package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 商品退货
 * @author administrator
 *
 */
public class OrderReturn implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3985611714927041673L;
	/**
	 * 退换货id
	 */
	private Long id;
	/**
	 * 商品唯一id
	 */
    private Integer itemId;
    /**
	 * 买家用户ID
	 */
    private Long buyerId;
    /**
	 * 所属订单编号
	 */
    private Long orderId;
    /**
	 * 订单号
	 */
    private String orderNumber;
    /**
	 * 退换货原因
	 */
    private Integer causeId;
    /**
	 * 应退金额
	 */
    private BigDecimal shouldReturn;
    /**
	 * 实退金额
	 */
    private BigDecimal actualReturn;
    /**
	 * 退换货状态
	 */
    private Byte returnStatus;
    /**
	 * 退款状态
	 */
    private Byte refundStatus;
    /**
	 * 创建时间
	 */
    private Date createTime;
    /**
	 * 备注
	 */
    private String remark;
    
    /**
	 * 订单的子项目
	 */
    private OrderItem orderItem;
    /**
	 * 买家用户
	 */
    private Buyer buyer;
    /**
     * 退换货原因
     */
    private OrderReturnCause orderReturnCause;
    
    public Long getReturnId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Integer getCauseId() {
        return causeId;
    }

    public void setCauseId(Integer causeId) {
        this.causeId = causeId;
    }

    public BigDecimal getShouldReturn() {
        return shouldReturn;
    }

    public void setShouldReturn(BigDecimal shouldReturn) {
        this.shouldReturn = shouldReturn;
    }

    public BigDecimal getActualReturn() {
        return actualReturn;
    }

    public void setActualReturn(BigDecimal actualReturn) {
        this.actualReturn = actualReturn;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Byte getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Byte refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public OrderReturnCause getOrderReturnCause() {
		return orderReturnCause;
	}

	public void setOrderReturnCause(OrderReturnCause orderReturnCause) {
		this.orderReturnCause = orderReturnCause;
	}

	public Long getId() {
		return id;
	}
    
    
}
