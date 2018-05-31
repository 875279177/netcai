package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Area;

/**
 * @author mengjie
 */
public interface AreaService {
	
	/**
	 * 查询所有的省份
	 * @return
	 */
	public List<Area> getAllProvince();
	
	
	/**
	 * 查询所有的市
	 * @return
	 */
	public List<Area> getAllCity(Long id);
	
	
	/**
	 * 查询所有的区域
	 * @return
	 */
	public List<Area> getAllRegion(Long id);
	
	/**
	 * 查询所有的区域
	 */
	public List<Area> getAllRegion();
	
	
}
