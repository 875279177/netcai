package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品显示类
 * @author administrator
 */
public class GoodsVo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Long bcId;
	
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
	private List<GoodsFormatVo> formatList;
	/**
	 * 商品图片
	 */
	private List<GoodsPictureVo> pictureList;
	/**
	 * 商品加工方式
	 */
	private List<GoodsMethodVo> methodList;
	
	
	public Long getBcId() {
		return bcId;
	}
	public void setBcId(Long bcId) {
		this.bcId = bcId;
	}
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
	public List<GoodsFormatVo> getFormatList() {
		return formatList;
	}
	public void setFormatList(List<GoodsFormatVo> formatList) {
		this.formatList = formatList;
	}
	public List<GoodsPictureVo> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<GoodsPictureVo> pictureList) {
		this.pictureList = pictureList;
	}
	public List<GoodsMethodVo> getMethodList() {
		return methodList;
	}
	public void setMethodList(List<GoodsMethodVo> methodList) {
		this.methodList = methodList;
	}
}
