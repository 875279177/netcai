package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.service.AreaService;

/**
 * TODO 注释
 * @author Administrator
 */
@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaDao areaDao;
	
	/**
	 * 查询所有的省份
	 * @return
	 */
	@Override
	public List<Area> getAllProvince() {
		return areaDao.getAllProvince();
	}
	
	/**
	 * 查询所有的市
	 * @return
	 */
	@Override
	public List<Area> getAllCity(Long id) {
		return areaDao.getAllCity(id);
	}
	
	/**
	 * 查询所有的区域
	 * @return
	 */
	@Override
	public List<Area> getAllRegion(Long id) {
		return areaDao.getAllCity(id);
	}
	
	/**
	 * 查询所有的区域
	 */
	@Override
	public List<Area> getAllRegion() {
		return areaDao.getRegions();
	}
}