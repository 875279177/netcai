package com.netcai.buyer.dao;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.buyer.entity.Area;

/**
 * 区域DAO
 * @author administrator
 */
public interface AreaDao {

	/**
	 * 查询所有的区
	 * @param id
	 * @return
	 */
	public List<Area> getAllRegion();
	
	/**
	 * 根据买家id查询区域起送价
	 * @param buyerId
	 * @return
	 */
	public BigDecimal getSendingPrice(Long buyerId);
	
}