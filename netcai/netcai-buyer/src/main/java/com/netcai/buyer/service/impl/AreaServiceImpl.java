package com.netcai.buyer.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.AreaDao;
import com.netcai.buyer.entity.Area;
import com.netcai.buyer.service.AreaService;

@Service(value="areaService")
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaDao areaDao;
	
	/**
	 * 查询所有的区域
	 * @return
	 */
	@Override
	public List<Area> getAllRegion() {
		return areaDao.getAllRegion();
	}
	
	/**
	 * 根据买家id查询区域起送价
	 */
	@Override
	public BigDecimal getSendingPrice(Long buyerId) {
		return areaDao.getSendingPrice(buyerId);
	}
}
