package com.netcai.buyer.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品图片实体类
 * @author administrator
 */
public class GoodsPicture implements Serializable{

private static final long serialVersionUID = 1L;
	
	private Long picId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 图片地址
	 */
	private String picUrl;
	/**
	 * 顺序号
	 */
	private Short picSeq;
	/**
	 * 是否主图(1是 -1否)
	 */
	private Short isMain;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Long getPicId() {
		return picId;
	}
	public void setPicId(Long picId) {
		this.picId = picId;
	}
	public Long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public Short getPicSeq() {
		return picSeq;
	}
	public void setPicSeq(Short picSeq) {
		this.picSeq = picSeq;
	}
	public Short getIsMain() {
		return isMain;
	}
	public void setIsMain(Short isMain) {
		this.isMain = isMain;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
