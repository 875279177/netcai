package com.netcai.admin.service;

import com.netcai.admin.entity.SysSystemConfig;
import com.netcai.admin.utils.PageUtil;

public interface SysSystemConfigService {
	
	/**
	 * 通过Id查询单个
	 */
	public SysSystemConfig getSysSystemConfigByKey(Long id);
	
	/**
	 * 添加
	 */
	public Integer insertSysSystemConfig(SysSystemConfig sysSystemConfig);
	
	
	/**
	 * 更新
	 */
	public Integer updateSysSystemConfig(SysSystemConfig sysSystemConfig);
	
	/**
	 * 物理删除  根据Id删除
	 */
	public int deleteSysSystemConfig(Long id);

	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(SysSystemConfig sysSystemConfig, int currentPageNum, int currentPageSize);
}
