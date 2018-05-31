package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SysSystemConfigDao;
import com.netcai.admin.entity.SysSystemConfig;
import com.netcai.admin.service.SysSystemConfigService;
import com.netcai.admin.utils.PageUtil;

/**
 * @author administrator
 */

@Service
public class SysSystemConfigServiceImpl implements SysSystemConfigService {

	@Autowired
	private SysSystemConfigDao sysSystemConfigDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public SysSystemConfig getSysSystemConfigByKey(Long id) {
		return sysSystemConfigDao.getSysSystemConfigByKey(id);
	}

	

	/**
	 * 添加
	 */
	@Override
	public Integer insertSysSystemConfig(SysSystemConfig sysSystemConfig) {
		int size =0;
		if (sysSystemConfig != null) {
			sysSystemConfig.setCreateTime(new Date());
			size = sysSystemConfigDao.insertSysSystemConfig(sysSystemConfig);
		}
		return size;
	}

	/**
	 * 更新
	 */
	@Override
	public Integer updateSysSystemConfig(SysSystemConfig sysSystemConfig) {
		int size =0;
		if (sysSystemConfig != null) {
			size = sysSystemConfigDao.updateSysSystemConfig(sysSystemConfig);
		}
		return size;
	}

	/**
	 * 物理删除  根据Id删除
	 */
	@Override
	public int deleteSysSystemConfig(Long id) {
		
		return sysSystemConfigDao.deleteSysSystemConfig(id);
		
	}

	/**
	 * 通过条件查询 
	 */
	@Override
	public PageUtil getPageResult(SysSystemConfig sysSystemConfig, int currentPageNum, int currentPageSize) {
		
		int size = sysSystemConfigDao.getPageCount(sysSystemConfig);

		int offset = currentPageNum > 1 ? (currentPageNum - 1) * currentPageSize : 0;
		
		List<SysSystemConfig> result = sysSystemConfigDao.getSysSystemConfig(sysSystemConfig, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}
	
	
}