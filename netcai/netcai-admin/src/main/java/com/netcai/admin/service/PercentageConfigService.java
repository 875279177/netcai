package com.netcai.admin.service;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.admin.entity.PercentageConfig;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.PercentageConfigVo;

/**
 * 平台抽点配置service
 * @author administrator
 *
 */
public interface PercentageConfigService {

	/**
	 * 分页查询账单信息
	 * 
	 * @param percentageConfig
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(PercentageConfigVo percentageConfig, int pageNum, int pageSize);
	
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	public PercentageConfigVo selectById(Long id);
	
	/**
	 * 查询抽点配置表中的所有区
	 * 
	 * @return
	 */
	public List<PercentageConfigVo> getRegions();
	
	/**
	 * 新增(可以是单条数据可以是多条数据)
	 * 
	 * @param percentageConfig
	 * @return
	 */
	public int insertPercentageConfigs(PercentageConfig percentageConfig,String categoryIds);
	
	/**
	 * 修改
	 * 
	 * @param percentageConfig
	 * @return
	 */
	public int update(PercentageConfig percentageConfig);
	
	/**
	 * 批量新增
	 * @param regionId
	 * @param sellerId
	 * @param percentage
	 * @return
	 */
	public int batchInsert(Long regionId,Long sellerId,BigDecimal percentage);

	/**
	 * 禁用
	 * @param id
	 * @return
	 */
	public int disabled(Long id);
	
	/**
	 * 启用
	 * @param id
	 * @return
	 */
	public int enabled(Long id);
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);
}
