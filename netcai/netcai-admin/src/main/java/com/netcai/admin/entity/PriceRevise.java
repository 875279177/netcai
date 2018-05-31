package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品价格调整实体类
 * @author administrator
 */
public class PriceRevise implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long prId;
	/**
	 * 商品规格ID
	 */
	private Long formatId;
	/**
	 * 原价
	 */
	private BigDecimal oldPrice;
	/**
	 * 调整后价格
	 */
	private BigDecimal revisePrice;
	/**
	 * 商家ID
	 */
	private Long userId;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	
	public Long getPrId() {
		return prId;
	}
	public void setPrId(Long prId) {
		this.prId = prId;
	}
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public BigDecimal getRevisePrice() {
		return revisePrice;
	}
	public void setRevisePrice(BigDecimal revisePrice) {
		this.revisePrice = revisePrice;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
