package com.netcai.admin.vo;

import java.io.Serializable;

/**
 * 商品列表搜索vo类
 * @author administrator
 */
public class SearchGoodsVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 商家ID
	 */
	private Long sellerId;
	/**
	 * 商家名称
	 */
	private String sellerName;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 商品名称
	 */
	private String searchName;
	/**
	 * 状态(1为上架，-1为下架)
	 */
	private Short searchStatus;
	/**
	 * 当前页数
	 */
	private int pageNum;
	/**
	 * 每页显示条数
	 */
	private int pageSize;
	/**
	 * type=0 商品列表  type=1 商家商品列表
	 */
	private int type = 0;
	
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Short getSearchStatus() {
		return searchStatus;
	}
	public void setSearchStatus(Short searchStatus) {
		this.searchStatus = searchStatus;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	 /**
     * 所属区域
     */
    private Long areaId;

	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
    
	/**
     * goodIds
     */
    private String goodIds;

	public String getGoodIds() {
		return goodIds;
	}
	public void setGoodIds(String goodIds) {
		this.goodIds = goodIds;
	}
    
	/**
	 * 状态
	 */
	private Short formatStatus;

	public Short getFormatStatus() {
		return formatStatus;
	}
	public void setFormatStatus(Short formatStatus) {
		this.formatStatus = formatStatus;
	}
	
	/**
	 * 卖家状态
	 */
	private Short sellerStatus;

	public Short getSellerStatus() {
		return sellerStatus;
	}
	public void setSellerStatus(Short sellerStatus) {
		this.sellerStatus = sellerStatus;
	}
	
}
