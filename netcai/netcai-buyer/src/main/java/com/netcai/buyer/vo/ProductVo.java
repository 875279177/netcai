package com.netcai.buyer.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.netcai.buyer.entity.GoodsPicture;

public class ProductVo implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 8344265512641447909L;
		
		private Long itemId;
		
		/**
		 * 
		 */
		private Long cartId;
		    
		/**
		 * 商品规格id
		 */
		private Long formatId;
		   
		/**
		 * 加工方式ID
		 */
		private Long methodId;
			   
		   /**
		 * 商品数量
		 */
		private Double goodsNumber;
		   
		 /**
		 * 是否选择 (1是 -1否)
		 */
		private Integer isSelected;
		
		/**
		 * 创建时间
		 */
		private Date createTime;
			   
		/**
		 * 加工方式
		 */
		private String methodName;
		
		/**
		 * 规格名称
		 */
		private String formatName;
		/**
		 * 价格
		 */
		private BigDecimal formatPrice;
		/**
		 * 数量
		 */
		private Integer formatNum;
		/**
		 * 商品标签
		 */
		private String goodsLabel;
		/**
		 * 单项总金额
		 */
		private BigDecimal goodsAmount;
		/**
		 * 商品品牌
		 */
		private String goodsBrand;
		/**
		 * 单位名称
		 */
		private String unitName;
		
		/**
		 * 商品名称
		 */
		private String goodsName;
		/**
		 * 订单项备注，由用户提交订单前填写
		 */
		private String remark;
		/**
		 * 店铺名称
		 */
		private String sellerName;
		/**
		 * 商品图片
		 */
		private List<GoodsPicture> pictureList;
		
		public Long getCartId() {
			return cartId;
		}
		
		public void setCartId(Long cartId) {
			this.cartId = cartId;
		}
		
		public Long getFormatId() {
			return formatId;
		}
		
		public void setFormatId(Long formatId) {
			this.formatId = formatId;
		}
		
		public Long getMethodId() {
			return methodId;
		}
		
		public void setMethodId(Long methodId) {
			this.methodId = methodId;
		}
		
		public Double getGoodsNumber() {
			return goodsNumber;
		}
		
		public void setGoodsNumber(Double goodsNumber) {
			this.goodsNumber = goodsNumber;
		}
		
		public Integer getIsSelected() {
			return isSelected;
		}
		
		public void setIsSelected(Integer isSelected) {
			this.isSelected = isSelected;
		}
		
		public Date getCreateTime() {
			return createTime;
		}
		
		public void setCreateTime(Date createTime) {
			this.createTime = createTime;
		}
		
		public String getMethodName() {
			return methodName;
		}
		
		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}
		
		public String getFormatName() {
			return formatName;
		}
		
		public void setFormatName(String formatName) {
			this.formatName = formatName;
		}
		
		public BigDecimal getFormatPrice() {
			return formatPrice;
		}
		
		public void setFormatPrice(BigDecimal formatPrice) {
			this.formatPrice = formatPrice;
		}
		
		public Integer getFormatNum() {
			return formatNum;
		}
		
		public void setFormatNum(Integer formatNum) {
			this.formatNum = formatNum;
		}
		
		public String getUnitName() {
			return unitName;
		}
		
		public void setUnitName(String unitName) {
			this.unitName = unitName;
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
		
		public List<GoodsPicture> getPictureList() {
			return pictureList;
		}
		
		public void setPictureList(List<GoodsPicture> pictureList) {
			this.pictureList = pictureList;
		}
		
		public String getRemark() {
			return remark;
		}
		
		public void setRemark(String remark) {
			this.remark = remark;
		}
		
		public String getSellerName() {
			return sellerName;
		}
		
		public void setSellerName(String sellerName) {
			this.sellerName = sellerName;
		}
		
		public BigDecimal getGoodsAmount() {
			return goodsAmount;
		}
		
		public void setGoodsAmount(BigDecimal goodsAmount) {
			this.goodsAmount = goodsAmount;
		}

		public Long getItemId() {
			return itemId;
		}

		public void setItemId(Long itemId) {
			this.itemId = itemId;
		}
	
		
}
