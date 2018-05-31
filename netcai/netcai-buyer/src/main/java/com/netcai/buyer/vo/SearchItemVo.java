package com.netcai.buyer.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索显示类(APP全局搜索)
 * @author administrator
 */
public class SearchItemVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long goodsId;
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
	

	private Long formatId;
	/**
	 * 计量单位ID
	 */
	private Integer unitId;
	/**
	 * 计量单位名称
	 */
	private String unitName;
	/**
	 * 名称
	 */
	private String formatName;
	/**
	 * 价格
	 */
	private Double formatPrice;
	/**
	 * 数量
	 */
	private Integer formatNum;
	/**
	 * 商品图片
	 */
	private List<GoodsPictureVo> pictureList;
	/**
	 * 商品加工方式
	 */
	private List<GoodsMethodVo> methodList;
	
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
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
	public Long getFormatId() {
		return formatId;
	}
	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getFormatName() {
		return formatName;
	}
	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}
	public Double getFormatPrice() {
		return formatPrice;
	}
	public void setFormatPrice(Double formatPrice) {
		this.formatPrice = formatPrice;
	}
	public Integer getFormatNum() {
		return formatNum;
	}
	public void setFormatNum(Integer formatNum) {
		this.formatNum = formatNum;
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
