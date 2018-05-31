package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 广告显示类
 * @author administrator
 */
public class BannerVo implements Serializable{
		
	private static final long serialVersionUID = 1L;

	private Integer bannerId;
	/**
	 * 广告主题
	 */
	private String bannerTitle;

	/**
	 * 图片地址
	 */
	private String bannerUrl;
	
	/**
	 * 链接IDS
	 */
	private String bannerIds;

	public Integer getBannerId() {
		return bannerId;
	}

	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}

	public String getBannerTitle() {
		return bannerTitle;
	}

	public void setBannerTitle(String bannerTitle) {
		this.bannerTitle = bannerTitle;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public String getBannerIds() {
		return bannerIds;
	}

	public void setBannerIds(String bannerIds) {
		this.bannerIds = bannerIds;
	}
}
