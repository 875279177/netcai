package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.vo.BannerVo;

/**
 * App广告栏service
 * @author administrator
 */
public interface BannerService {

	/**
	 * 通过区域ID获取广告
	 * @param regionId
	 * @return
	 */
	public List<BannerVo> getBannerByRegionId(Long regionId); 
}
