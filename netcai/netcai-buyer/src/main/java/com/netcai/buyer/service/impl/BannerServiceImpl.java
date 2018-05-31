package com.netcai.buyer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.BannerDao;
import com.netcai.buyer.service.BannerService;
import com.netcai.buyer.vo.BannerVo;

/**
 * App广告栏serviceimpl
 * @author administrator
 */
@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerDao bannerDao;

	/**
	 * 通过区域ID获取广告
	 * @param regionId
	 * @return
	 */
	@Override
	public List<BannerVo> getBannerByRegionId(Long regionId) {
		return bannerDao.getBannerByRegionId(regionId);
	}
}
