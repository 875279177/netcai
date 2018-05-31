package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BuyerReceipt implements Serializable{
	/**
	 */
	private static final long serialVersionUID = -8261082704694840981L;
	/**
	 * 自增ID
	 */
    private Long brId;
    /**
	 * 买家ID
	 */
    private Long buyerId;
    /**
	 * 收款日期
	 */
    private Date receiptDate;
    /**
	 * 销售人员ID
	 */
    private Long saleId;
    /**
	 * 配送人员ID
	 */
    private Long deliveryId;
    /**
	 * 应收金额
	 */
    private BigDecimal ysAmt;
    /**
	 * 实收金额
	 */
    private BigDecimal ssAmt;
    /**
	 * 收款状态(1未收 2已收)
	 */
    private Byte skStatus;
    /**
	 * 收款备注
	 */
    private String skReamk;
    /**
	 * 收款时间
	 */
    private Date skTime;
    /**
	 * 核实状态(1未核实 2已核实)
	 */
    private Byte hsStatus;
    /**
	 * 核实人
	 */
    private Long hsUserId;
    /**
	 * 核实时间
	 */
    private Date hsTime;
    /**
	 * 入账状态(1未入账 2已入账)
	 */
    private Byte rzStatus;
    /**
	 * 入账人
	 */
    private Long rzUserId;
    /**
	 * 入账时间
	 */
    private Date rzTime;

    public Long getBrId() {
        return brId;
    }

    public void setBrId(Long brId) {
        this.brId = brId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public BigDecimal getYsAmt() {
        return ysAmt;
    }

    public void setYsAmt(BigDecimal ysAmt) {
        this.ysAmt = ysAmt;
    }

    public BigDecimal getSsAmt() {
        return ssAmt;
    }

    public void setSsAmt(BigDecimal ssAmt) {
        this.ssAmt = ssAmt;
    }

    public Byte getSkStatus() {
        return skStatus;
    }

    public void setSkStatus(Byte skStatus) {
        this.skStatus = skStatus;
    }

    public String getSkReamk() {
        return skReamk;
    }

    public void setSkReamk(String skReamk) {
        this.skReamk = skReamk == null ? null : skReamk.trim();
    }

    public Date getSkTime() {
        return skTime;
    }

    public void setSkTime(Date skTime) {
        this.skTime = skTime;
    }

    public Byte getHsStatus() {
        return hsStatus;
    }

    public void setHsStatus(Byte hsStatus) {
        this.hsStatus = hsStatus;
    }

    public Long getHsUserId() {
        return hsUserId;
    }

    public void setHsUserId(Long hsUserId) {
        this.hsUserId = hsUserId;
    }

    public Date getHsTime() {
        return hsTime;
    }

    public void setHsTime(Date hsTime) {
        this.hsTime = hsTime;
    }

    public Byte getRzStatus() {
        return rzStatus;
    }

    public void setRzStatus(Byte rzStatus) {
        this.rzStatus = rzStatus;
    }

    public Long getRzUserId() {
        return rzUserId;
    }

    public void setRzUserId(Long rzUserId) {
        this.rzUserId = rzUserId;
    }

    public Date getRzTime() {
        return rzTime;
    }

    public void setRzTime(Date rzTime) {
        this.rzTime = rzTime;
    }
    
    
    /************************************************Query**********************************************************/
    /**
	 * 买家
	 */
    private String buyerName;
    /**
	 * 销售
	 */
    private String trueName;
    /**
	 * 配送
	 */
    private String deliveryName;
    /**
	 * 核实人
	 */
    private String hsName;
    /**
	 * 入账人
	 */
    private String rzName;

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getHsName() {
		return hsName;
	}

	public void setHsName(String hsName) {
		this.hsName = hsName;
	}

	public String getRzName() {
		return rzName;
	}

	public void setRzName(String rzName) {
		this.rzName = rzName;
	}
    
	/**
	 * 是否相同;
	 */
    private String alike;

	public String getAlike() {
		return alike;
	}
	public void setAlike(String alike) {
		this.alike = alike;
	}
	
	 /**
	 * 收款日期
	 */
    private String receiptDateQuery;

	public String getReceiptDateQuery() {
		return receiptDateQuery;
	}

	public void setReceiptDateQuery(String receiptDateQuery) {
		this.receiptDateQuery = receiptDateQuery;
	}
    
	/**
	 * 最佳收货时间开始;
	 */
	private String beatTimeStart;
	
	/**
	 * 最佳收货时间结束;
	 */
	private String beatTimeStop;
	
	/**
	 * 商品总金额
	 */
	private BigDecimal totalAmount;
	
	/**
	 * 原始商品总金额
	 */
	private BigDecimal oldAmt;

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getOldAmt() {
		return oldAmt;
	}

	public void setOldAmt(BigDecimal oldAmt) {
		this.oldAmt = oldAmt;
	}
	
	/**
	 * 配送人员;
	 */
    private String deliveryIds;

	public String getDeliveryIds() {
		return deliveryIds;
	}
	public void setDeliveryIds(String deliveryIds) {
		this.deliveryIds = deliveryIds;
	}
    
	
	/**所属区
     */
    private Long areaId;
    
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
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
	
	
}