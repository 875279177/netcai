package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品实体类
 * @author administrator
 */
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long goodsId;
	/**
	 * 商品分类
	 */
	private Category category;
	/**
	 * 用户Id(卖家)
	 */
	private Long userId;
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
	 * 商品描述
	 */
	private String goodsDesc;
	/**
	 * 排序
	 */
	private Integer goodsSeq;
	/**
	 * 状态(1为上架，2为下架)
	 */
	private Short goodsStatus;
	/**
	 * 商品备注
	 */
	private String goodsRemark;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 商品规格
	 */
	private List<GoodsFormat> formatList;
	/**
	 * 商品图片
	 */
	private List<GoodsPicture> pictureList;
	/**
	 * 商品加工方式
	 */
	private List<Integer> methodList;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
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
	public String getGoodsRemark() {
		return goodsRemark;
	}
	public void setGoodsRemark(String goodsRemark) {
		this.goodsRemark = goodsRemark;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public List<GoodsFormat> getFormatList() {
		return formatList;
	}
	public void setFormatList(List<GoodsFormat> formatList) {
		this.formatList = formatList;
	}
	public List<GoodsPicture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<GoodsPicture> pictureList) {
		this.pictureList = pictureList;
	}
	public List<Integer> getMethodList() {
		return methodList;
	}
	public void setMethodList(List<Integer> methodList) {
		this.methodList = methodList;
	}
}
