package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.SysStatus;
import com.netcai.admin.dao.PercentageConfigDao;
import com.netcai.admin.dao.SellerCategoryDao;
import com.netcai.admin.entity.PercentageConfig;
import com.netcai.admin.entity.SellerCategory;
import com.netcai.admin.service.PercentageConfigService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.PercentageConfigVo;

/**
 * 平台抽点配置serviceImpl
 * 
 * @author administrator
 *
 */
@Service
public class PercentageConfigServiceImpl implements PercentageConfigService {

	@Autowired
	private PercentageConfigDao percentageConfigDao;

	@Autowired
	private SellerCategoryDao sellerCategoryDao;

	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAll(PercentageConfigVo percentageConfig, int pageNum, int pageSize) {
		int size = percentageConfigDao.getPageCount(percentageConfig);
		int offset = 0;
		if (pageNum > 0) {
			offset = (pageNum - 1) * pageSize;
		}
		if (offset >= size) {
			offset = 0;
		}
		List<PercentageConfigVo> list = percentageConfigDao.getAll(percentageConfig, offset, pageSize);
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);
		paginator.setObject(list);
		return paginator;
	}

	/**
	 * 根据id查询数据
	 */
	@Override
	public PercentageConfigVo selectById(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		List<PercentageConfigVo> list = percentageConfigDao.getByMap(map);
		if (CollectionUtils.isEmpty(list) || list.size() != 1) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 查询抽点配置表中的所有区
	 */
	@Override
	public List<PercentageConfigVo> getRegions() {
		return percentageConfigDao.getRegions();
	}

	/**
	 * 新增和修改，新增时可以单条记录也可以是多条
	 */
	@Override
	public int insertPercentageConfigs(PercentageConfig percentageConfig, String categoryIds) {
		Date time = new Date();
		// 判断字符串是否包含",",包含则表示多条记录，不然则为单条
		if (categoryIds.indexOf(",") != -1) {
			List<PercentageConfig> configs = new ArrayList<PercentageConfig>();
			String[] ids = categoryIds.split(",");
			for (String id : ids) {
				if (StringUtils.isBlank(id)) {
					continue;
				}
				PercentageConfig config = new PercentageConfig();
				config.setRegionId(percentageConfig.getRegionId());
				config.setSellerId(percentageConfig.getSellerId());
				config.setPercentage(percentageConfig.getPercentage());
				Long categoryId = Long.valueOf(id);
				config.setCategoryId(categoryId);
				// 设置状态为可用
				config.setStatus(SysStatus.UN_FORBIDDEN);
				config.setCreateTime(time);
				configs.add(config);
			}
			if (CollectionUtils.isEmpty(configs)) {
				return 0;
			}
			//新增之前删除
			percentageConfigDao.batchDelete(configs);
			// 批量新增
			return percentageConfigDao.batchInsert(configs);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("regionId", percentageConfig.getRegionId());
			map.put("sellerId", percentageConfig.getSellerId());
			map.put("categoryId", percentageConfig.getCategoryId());
			//根据区id、卖家id、商品二级分类查询抽点配置是否存在
			List<PercentageConfigVo> list = percentageConfigDao.getByMap(map);
			//若存在返回0，若不存在则新增数据
			if (CollectionUtils.isNotEmpty(list)) {
				return 0 ;
			} 
			// 设置状态为可用
			percentageConfig.setStatus(SysStatus.UN_FORBIDDEN);
			percentageConfig.setCreateTime(time);
			return percentageConfigDao.insert(percentageConfig);
		}
	}

	/**
	 * 批量新增
	 */
	@Override
	public int batchInsert(Long regionId, Long sellerId, BigDecimal percentage) {
		// 根据商家的获取商品二级分类
		List<SellerCategory> sellerCategoryList = sellerCategoryDao.getSellerCategoryList(sellerId, (short) 2);
		if (CollectionUtils.isEmpty(sellerCategoryList)) {
			return 0;
		}
		List<PercentageConfig> configs = new ArrayList<PercentageConfig>();
		Date time = new Date();
		for (SellerCategory category : sellerCategoryList) {
			if (category == null || category.getCategoryId() == null) {
				continue;
			}
			PercentageConfig percentageConfig = new PercentageConfig();
			percentageConfig.setSellerId(sellerId);
			percentageConfig.setRegionId(regionId);
			percentageConfig.setCategoryId((long) category.getCategoryId());
			percentageConfig.setPercentage(percentage);
			percentageConfig.setCreateTime(time);
			// 设置状态为可用
			percentageConfig.setStatus(SysStatus.UN_FORBIDDEN);
			configs.add(percentageConfig);
		}
		if (CollectionUtils.isEmpty(configs)) {
			return 0;
		}
		// 新增之前删除之前的配置（不允许重复存在）
		percentageConfigDao.batchDelete(configs);
		// 批量新增
		return percentageConfigDao.batchInsert(configs);
	}

	/**
	 * 修改
	 * 
	 * @param percentageConfig
	 * @return
	 */
	@Override
	public int update(PercentageConfig percentageConfig) {
		// 修改数据
		if (percentageConfig.getId() != null) {
			percentageConfig.setUpdateTime(new Date());
			return percentageConfigDao.update(percentageConfig);
		}
		return 0;
	}

	/**
	 * 禁用
	 */
	@Override
	public int disabled(Long id) {
		return percentageConfigDao.updateStatus(id, SysStatus.FORBIDDEN);
	}

	/**
	 * 启用
	 */
	@Override
	public int enabled(Long id) {
		return percentageConfigDao.updateStatus(id, SysStatus.UN_FORBIDDEN);
	}

	/**
	 * 删除
	 */
	@Override
	public int deleteById(Long id) {
		return percentageConfigDao.deleteById(id);
	}

}
