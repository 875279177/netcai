package com.netcai.admin.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 统计卖家每天的抽点信息
 * @author Administrator
 *
 */
public class OrderPercentageVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 所属卖家ID
	 */
	private Long sellerId;

	/**
	 * 卖家店铺名称
	 */
	private String sellerName;

	/**
	 * 订单金额
	 */
	private BigDecimal originalAmount;

	/**
	 * 抽点金额
	 */
	private BigDecimal percentageAmount;

	/**
	 * 订单实际金额(订单金额减去抽点金额)
	 */
	private BigDecimal realAmount;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	private String createTimeStr;

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public BigDecimal getOriginalAmount() {
		return originalAmount;
	}

	public void setOriginalAmount(BigDecimal originalAmount) {
		this.originalAmount = originalAmount;
	}

	public BigDecimal getPercentageAmount() {
		return percentageAmount;
	}

	public void setPercentageAmount(BigDecimal percentageAmount) {
		this.percentageAmount = percentageAmount;
	}

	public BigDecimal getRealAmount() {
		return realAmount;
	}

	public void setRealAmount(BigDecimal realAmount) {
		this.realAmount = realAmount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	/****************************************query***********************************************/
	
	/**
	 * 时间开始;
	 */
	private String createTimeStart;
	
	/**
	 * 时间结束;
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
	
}
