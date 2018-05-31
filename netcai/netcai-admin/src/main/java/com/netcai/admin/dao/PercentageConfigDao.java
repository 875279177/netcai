package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.PercentageConfig;
import com.netcai.admin.vo.PercentageConfigVo;

/**
 * 平台抽点配置表Dao
 * 
 * @author administrator
 *
 */
public interface PercentageConfigDao {

	/**
	 * 分页查询
	 * 
	 * @param percentageConfig
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<PercentageConfigVo> getAll(@Param("percentageConfig") PercentageConfigVo percentageConfig,
			@Param("offset") int offset, @Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount(@Param("percentageConfig") PercentageConfigVo percentageConfig);

	/**
	 * 根据map查询数据
	 * 
	 * @param map
	 * @return
	 */
	public List<PercentageConfigVo> getByMap(Map<String, Object> map);

	/**
	 * 查询抽点配置表中的所有区
	 * 
	 * @return
	 */
	public List<PercentageConfigVo> getRegions();

	/**
	 * 新增
	 * 
	 * @param percentageConfig
	 * @return
	 */
	public int insert(PercentageConfig percentageConfig);
	
	/**
	 * 批量新增
	 * @param list
	 * @return
	 */
	public int batchInsert(List<PercentageConfig> list);

	/**
	 * 更新抽点率
	 * 
	 * @param percentageConfig
	 * @return
	 */
	public int update(PercentageConfig percentageConfig);

	/**
	 * 更新状态
	 * 
	 * @param configId
	 * @param status
	 * @return
	 */
	public int updateStatus(@Param("id") Long id, @Param("status") Integer status);
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);
	
	/**
	 * 批量删除数据
	 * @param id
	 * @return
	 */
	public int batchDelete(List<PercentageConfig> configs);

}
