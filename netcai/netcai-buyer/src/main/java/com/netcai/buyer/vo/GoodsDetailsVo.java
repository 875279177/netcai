package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品显示类
 * 
 * @author administrator
 */
public class GoodsDetailsVo implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 商品规格id
	 */
	private Long formatId;
	/**
	 * 商品规格名称
	 */
	private String formatName;
	/**
	 * 加工方式id
	 */
	private Long methodId;
	/**
	 * 加工方式名称
	 */
	private String methodName;
	/**
	 * 购买数量
	 */
	private BigDecimal goodsNumber;
	/**
	 * 价格
	 */
	private BigDecimal formatPrice;
	/**
	 * 数量
	 */
	private BigDecimal formatNum;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品标签
	 */
	private String goodsLabel;
	/**
	 * 商品品牌
	 */
	private String goodsBrand;
	/**
	 * 单位名称
	 */
	private String unitName;
	/**
	 * 商品描述
	 */
	private String remark;

	/**
	 * 商品图片集合
	 */
	private List<GoodsPictureVo> goodsPictureList;
	/**
	 * 购物车id
	 */
	private Long cartId;

	public Long getFormatId() {
		return formatId;
	}

	public void setFormatId(Long formatId) {
		this.formatId = formatId;
	}

	public String getFormatName() {
		return formatName;
	}

	public void setFormatName(String formatName) {
		this.formatName = formatName;
	}

	public Long getMethodId() {
		return methodId;
	}

	public void setMethodId(Long methodId) {
		this.methodId = methodId;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public BigDecimal getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(BigDecimal goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public BigDecimal getFormatPrice() {
		return formatPrice;
	}

	public void setFormatPrice(BigDecimal formatPrice) {
		this.formatPrice = formatPrice;
	}

	public BigDecimal getFormatNum() {
		return formatNum;
	}

	public void setFormatNum(BigDecimal formatNum) {
		this.formatNum = formatNum;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<GoodsPictureVo> getGoodsPictureList() {
		return goodsPictureList;
	}

	public void setGoodsPictureList(List<GoodsPictureVo> goodsPictureList) {
		this.goodsPictureList = goodsPictureList;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

}
