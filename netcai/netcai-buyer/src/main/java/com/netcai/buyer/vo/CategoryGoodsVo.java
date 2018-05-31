package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 商品分类商品集合类
 * @author administrator
 */
public class CategoryGoodsVo implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 卖家分类主表ID
	 */
	private Long scId;
	private Integer categoryId;
	private String categoryCode;
	private String categoryName;
	private List<GoodsVo> goodsList;
	
	public Long getScId() {
		return scId;
	}
	public void setScId(Long scId) {
		this.scId = scId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<GoodsVo> getGoodsList() {
		return goodsList;
	}
	public void setGoodsList(List<GoodsVo> goodsList) {
		this.goodsList = goodsList;
	}
}
