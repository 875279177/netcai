package com.netcai.buyer.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.vo.BannerVo;

/**
 * App广告DAO
 * @author administrator
 */
public interface BannerDao {

	/**
	 * 通过区域ID获取广告
	 * @param regionId
	 * @return
	 */
	public List<BannerVo> getBannerByRegionId(@Param("regionId") Long regionId); 
}
