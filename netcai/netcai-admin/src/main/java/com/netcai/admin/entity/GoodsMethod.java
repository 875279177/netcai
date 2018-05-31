package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品加工方式实体类
 * @author administrator
 */
public class GoodsMethod implements Serializable{

    private static final long serialVersionUID = 1L;
	
	private Long gmId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 加工方式ID
	 */
	private Integer methodId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getGmId() {
		return gmId;
	}
	public void setGmId(Long gmId) {
		this.gmId = gmId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getMethodId() {
		return methodId;
	}
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
