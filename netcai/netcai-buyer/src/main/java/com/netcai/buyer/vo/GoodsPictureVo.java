package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 商品图片显示类
 * @author administrator
 */
public class GoodsPictureVo implements Serializable {

    private static final long serialVersionUID = 1L;
	
	private Long picId;
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
	
	public Long getPicId() {
		return picId;
	}
	public void setPicId(Long picId) {
		this.picId = picId;
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
	
}
