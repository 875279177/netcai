package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 系统常用清单;
 */
public class SysCommon implements Serializable{
	
    /**
	 */
	private static final long serialVersionUID = -5894610129367005370L;

	private Long scId;

	/**
	 * 买家类型
	 */
    private Integer buyerTypeId;

    /**
     * 所属区域
     */
    private Long areaId;
    
    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 创建时间
     */
    private Date createTime;

	public Long getScId() {
		return scId;
	}

	public void setScId(Long scId) {
		this.scId = scId;
	}

	public Integer getbuyerTypeId() {
		return buyerTypeId;
	}

	public void setbuyerTypeId(Integer buyerTypeId) {
		this.buyerTypeId = buyerTypeId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}