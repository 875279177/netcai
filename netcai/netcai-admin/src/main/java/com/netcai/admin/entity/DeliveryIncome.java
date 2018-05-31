package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DeliveryIncome implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5813485193938475259L;

	private Long diId;

    /**
     * 配送人员ID
     */
    private Long deliveryId;

    /**
     * 配送人员名称
     */
    private String deliveryName;

    /**
     * 配送人员电话
     */
    private String deliveryPhone;

    /**
     * 配送日期
     */
    private Date diDate;

    /**
     * 送达金额
     */
    private BigDecimal diAmt;

    /**
     * 送达家数
     */
    private Integer diCount;

    /**
     * 提成收入
     */
    private BigDecimal diIncome;

    /**
     * 配送区域
     */
    private String diArea;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getDiId() {
        return diId;
    }

    public void setDiId(Long diId) {
        this.diId = diId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName == null ? null : deliveryName.trim();
    }

    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone == null ? null : deliveryPhone.trim();
    }

    public Date getDiDate() {
        return diDate;
    }

    public void setDiDate(Date diDate) {
        this.diDate = diDate;
    }

    public BigDecimal getDiAmt() {
        return diAmt;
    }

    public void setDiAmt(BigDecimal diAmt) {
        this.diAmt = diAmt;
    }

    public Integer getDiCount() {
        return diCount;
    }

    public void setDiCount(Integer diCount) {
        this.diCount = diCount;
    }

    public BigDecimal getDiIncome() {
        return diIncome;
    }

    public void setDiIncome(BigDecimal diIncome) {
        this.diIncome = diIncome;
    }

    public String getDiArea() {
        return diArea;
    }

    public void setDiArea(String diArea) {
        this.diArea = diArea == null ? null : diArea.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    /************************************************query*******************************************/
    /**
	 * 送达时间开始;
	 */
	private String createTimeStart;
	
	/**
	 * 送达时间结束;
	 */
	private String createTimeStop;
	
	/**
	 * 送达家数开始;
	 */
	private Integer countStart;
	
	/**
	 * 送达家数结束;
	 */
	private Integer countStop;
	
	/**
	 * 总订单金额开始;
	 */
	private BigDecimal amtStart;
	
	/**
	 * 总订单金额结束;
	 */
	private BigDecimal amtStop;
	
	/**
	 * 总订单金额开始;
	 */
	private BigDecimal incomeStart;
	
	/**
	 * 总订单金额结束;
	 */
	private BigDecimal incomeStop;

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

	public Integer getCountStart() {
		return countStart;
	}

	public void setCountStart(Integer countStart) {
		this.countStart = countStart;
	}

	public Integer getCountStop() {
		return countStop;
	}

	public void setCountStop(Integer countStop) {
		this.countStop = countStop;
	}

	public BigDecimal getAmtStart() {
		return amtStart;
	}

	public void setAmtStart(BigDecimal amtStart) {
		this.amtStart = amtStart;
	}

	public BigDecimal getAmtStop() {
		return amtStop;
	}

	public void setAmtStop(BigDecimal amtStop) {
		this.amtStop = amtStop;
	}

	public BigDecimal getIncomeStart() {
		return incomeStart;
	}

	public void setIncomeStart(BigDecimal incomeStart) {
		this.incomeStart = incomeStart;
	}

	public BigDecimal getIncomeStop() {
		return incomeStop;
	}

	public void setIncomeStop(BigDecimal incomeStop) {
		this.incomeStop = incomeStop;
	}
	
	/**
	 * 时间;
	 */
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}