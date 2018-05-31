package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SysSystemConfig;

/**
 * 系统配置文件DAO
 * @author administrator
 */
public interface SysSystemConfigDao {

	/**
	 * 通过Id查询单个
	 */
	public SysSystemConfig getSysSystemConfigByKey(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<SysSystemConfig> getSysSystemConfig(@Param(value="sys") SysSystemConfig sys ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount(@Param(value="sys") SysSystemConfig sys);
	
	/**
	 * 添加
	 */
	public int insertSysSystemConfig(SysSystemConfig sysSystemConfig);
	
	/**
	 * 更新
	 */
	public int updateSysSystemConfig(SysSystemConfig sysSystemConfig);
	
	/**
	 * 物理删除  根据Id删除
	 */
	public int deleteSysSystemConfig(Long id);
}