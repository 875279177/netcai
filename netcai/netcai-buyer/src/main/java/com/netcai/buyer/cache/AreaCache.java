package com.netcai.buyer.cache;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netcai.buyer.entity.Area;
import com.netcai.buyer.listener.SpringContextUtil;
import com.netcai.buyer.service.AreaService;

/**
 * 区域缓存
 * @author administrator
 */
public class AreaCache {

	private static final Logger logger=LoggerFactory.getLogger(AreaCache.class);
	
	public static Map<Long, String> cacheMap = new ConcurrentHashMap<Long, String>();
	
	/**
	 * 加载
	 */
	public static void load() {
		
		AreaService areaService = (AreaService)SpringContextUtil.getBean("areaService");
		
		List<Area> listArea=areaService.getAllRegion();
		
		if(CollectionUtils.isNotEmpty(listArea))
		{
			for (Area area : listArea) {
				cacheMap.put(area.getId(), area.getAreaName());
			}
		}
	}
	/**
	 * 重新加载
	 */
	public static void reLoad()
	{
		logger.info("[SystemConfigCache] 重新加载缓存");
		cacheMap.clear();
		load();
	}
	
	/**
	 * 获取名称 	
	 * @param id
	 * @return
	 */
	public static String getAreaName(Long id)
	{
		return cacheMap.get(id);
	}
}