package com.netcai.admin.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.netcai.admin.entity.GoodsFormat;

/**
 * 商品列表vo
 * @author administrator
 */
public class GoodsListVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long goodsId;
	/**
	 * 商品分类ID
	 */
	private Integer categoryId;
	/**
	 * 商品分类编码
	 */
	private String categoryCode;
	/**
	 * 商品分类名称
	 */
	private String categoryName;
	/**
	 * 用户Id(卖家)
	 */
	private Long sellerId;
	/**
	 * 店铺名称
	 */
	private String sellerName;
	/**
	 * 店铺账号
	 */
	private String sellerAccount;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品别名
	 */
	private String goodsAs;
	/**
	 * 商品标签
	 */
	private String goodsLabel;
	/**
	 * 商品品牌
	 */
	private String goodsBrand;
	/**
	 * 排序
	 */
	private Integer goodsSeq;
	/**
	 * 状态(1为上架，2为下架)
	 */
	private Short goodsStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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
	public String getSellerAccount() {
		return sellerAccount;
	}
	public void setSellerAccount(String sellerAccount) {
		this.sellerAccount = sellerAccount;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsAs() {
		return goodsAs;
	}
	public void setGoodsAs(String goodsAs) {
		this.goodsAs = goodsAs;
	}
	public String getGoodsLabel() {
		return goodsLabel;
	}
	public void setGoodsLabel(String goodsLabel) {
		this.goodsLabel = goodsLabel;
	}
	public String getGoodsBrand() {
		return goodsBrand;
	}
	public void setGoodsBrand(String goodsBrand) {
		this.goodsBrand = goodsBrand;
	}
	public Integer getGoodsSeq() {
		return goodsSeq;
	}
	public void setGoodsSeq(Integer goodsSeq) {
		this.goodsSeq = goodsSeq;
	}
	public Short getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(Short goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/********************************************************QUERY******************************************************************************/
	
	/**
	 * 商品规格
	 */
	private List<GoodsFormat> formatList;

	public List<GoodsFormat> getFormatList() {
		return formatList;
	}
	public void setFormatList(List<GoodsFormat> formatList) {
		this.formatList = formatList;
	}
	
}
