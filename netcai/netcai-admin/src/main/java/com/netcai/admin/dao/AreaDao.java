package com.netcai.admin.dao;

import java.util.List;

import com.netcai.admin.entity.Area;

/**
 * 区域DAO
 * @author administrator
 */
public interface AreaDao {
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<Area> getAllAreas();

	/**
	 * 查询所有的省
	 * @return
	 */
	public List<Area> getAllProvince();
	/**
	 * 查询所有的城市
	 * @param id
	 * @return
	 */
	public List<Area> getAllCity(Long id);

	/**
	 * 查询所有的区
	 * @param id
	 * @return
	 */
	public List<Area> getAllRegion(Long id);
	
	/**
	 * 根据id查询区域信息
	 * @param id
	 * @return
	 */
	public Area getAreaById(Long id);
	
	/**
	 * 查询所有的区
	 * @return
	 */
	public List<Area> getRegions();
	
}