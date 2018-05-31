package com.netcai.buyer.entity;

import java.io.Serializable;

/**
 * 商品分类实体类
 * @author administrator
 */
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer categoryId;
	/**
	 * 分类编码
	 */
	private String categoryCode;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 父类ID,0表示第一级
	 */
	private Integer parentId;
	/**
	 * 分类顺序
	 */
	private Integer categorySeq;
	/**
	 * 层级
	 */
	private Short categoryLevel;
	/**
	 * 是否末级 1表示是末级
	 */
	private Short isEnd;
	/**
	 * 分类图片
	 */
	private String categoryLogo;
	
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getCategorySeq() {
		return categorySeq;
	}
	public void setCategorySeq(Integer categorySeq) {
		this.categorySeq = categorySeq;
	}
	public Short getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(Short categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public Short getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(Short isEnd) {
		this.isEnd = isEnd;
	}
	public String getCategoryLogo() {
		return categoryLogo;
	}
	public void setCategoryLogo(String categoryLogo) {
		this.categoryLogo = categoryLogo;
	}
}
