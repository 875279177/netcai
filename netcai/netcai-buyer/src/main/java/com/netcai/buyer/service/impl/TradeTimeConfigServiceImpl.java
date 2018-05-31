package com.netcai.buyer.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.TradeTimeConfigDao;
import com.netcai.buyer.entity.TradeTimeConfig;
import com.netcai.buyer.service.TradeTimeConfigService;

/**
 * 交易时间配置服务层
 * @author administrator
 */
@Service
public class TradeTimeConfigServiceImpl implements TradeTimeConfigService{
	
	@Autowired 
	private TradeTimeConfigDao TradeTimeConfigDao;
	
	/**
	 * 根据区域 id查询交易时间
	 * @param regionId
	 * @return
	 */
	@Override
	public TradeTimeConfig getByRegionId(Long regionId) 
	{
		 TradeTimeConfig config  = TradeTimeConfigDao.getByRegionId(regionId);
		 if(config == null )
		 {
			 //如果系统没配置,默认下单时间为中午12：00到第二天的早上06：00
			 config = new TradeTimeConfig();
			 config.setRegionId(regionId);
			 config.setTradeStartTime("12:00");
			 config.setTradeEndTime("06:00");
			 config.setCreateTime(new Date());
		 }
		 return config;
	}
}