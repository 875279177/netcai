package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.Date;

import com.netcai.admin.entity.Goods;
/**
 * 系统常用清单;
 */
public class SysCommonVo implements Serializable{
	
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
    
    /**
     * 商品
     */
    private Goods goods;
    
    /**
     * 区域名称
     */
    private String areaName;
    
    /**
	 * 买家类型
	 */
    private String buyerType;

	public Long getScId() {
		return scId;
	}

	public void setScId(Long scId) {
		this.scId = scId;
	}

	public Integer getBuyerTypeId() {
		return buyerTypeId;
	}

	public void setBuyerTypeId(Integer buyerTypeId) {
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

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getBuyerType() {
		return buyerType;
	}

	public void setBuyerType(String buyerType) {
		this.buyerType = buyerType;
	}
    
	
}