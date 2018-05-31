package com.netcai.buyer.service;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.buyer.entity.Area;

/**
 * @author mengjie
 */
public interface AreaService {
	
	/**
	 * 查询所有的区域
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
