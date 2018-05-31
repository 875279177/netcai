package com.netcai.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	 * 分类图片
	 */
	private String categoryLogo;
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
	 * 状态(1为可用，-1为不可用)
	 */
	private Integer categoryStatus;
	/**
	 * 数量向上浮动
	 */
	private BigDecimal upNumber;
	/**
	 * 数量向下浮动
	 */
	private BigDecimal downNumber;
	/**
	 * 销售提成
	 */
	private BigDecimal salePercentage;
	/**
	 * 平台抽点
	 */
	private BigDecimal platformPercentage;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 加工方式Ids
	 */
	private List<Integer> methodIds;
	/**
	 * 编码加名称(分类树需要用)
	 */
	private String fullName;
	
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
	public Integer getCategoryStatus() {
		return categoryStatus;
	}
	public void setCategoryStatus(Integer categoryStatus) {
		this.categoryStatus = categoryStatus;
	}
	public BigDecimal getUpNumber() {
		return upNumber;
	}
	public void setUpNumber(BigDecimal upNumber) {
		this.upNumber = upNumber;
	}
	public BigDecimal getDownNumber() {
		return downNumber;
	}
	public void setDownNumber(BigDecimal downNumber) {
		this.downNumber = downNumber;
	}
	public BigDecimal getSalePercentage() {
		return salePercentage;
	}
	public void setSalePercentage(BigDecimal salePercentage) {
		this.salePercentage = salePercentage;
	}
	public BigDecimal getPlatformPercentage() {
		return platformPercentage;
	}
	public void setPlatformPercentage(BigDecimal platformPercentage) {
		this.platformPercentage = platformPercentage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<Integer> getMethodIds() {
		return methodIds;
	}
	public void setMethodIds(List<Integer> methodIds) {
		this.methodIds = methodIds;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCategoryLogo() {
		return categoryLogo;
	}
	public void setCategoryLogo(String categoryLogo) {
		this.categoryLogo = categoryLogo;
	}
	
}
