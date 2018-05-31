package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.ChartTitleEnum;
import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.dao.OrderPercentageDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.OrderPercentage;
import com.netcai.admin.service.OrderPercentageService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.OrderPercentageVo;

/**
 * 卖家抽点serviceImpl
 * 
 * @author administrator
 *
 */
@Service
public class OrderPercentageServiceImpl implements OrderPercentageService {

	@Autowired
	private OrderPercentageDao orderPercentageDao;

	@Autowired
	private AreaDao areaDao;

	/**
	 * 根据时间查询卖家的抽点金额
	 */
	@Override
	public List<OrderPercentage> getOrderPercentagesByDate(OrderPercentage percentage) {
		return orderPercentageDao.getOrderPercentagesByDate(percentage);
	}

	/**
	 * 根据时间统计卖家的抽点金额
	 */
	@Override
	public List<OrderPercentageVo> getAmountByDate(OrderPercentageVo percentage) {
		return orderPercentageDao.getAmountByDate(percentage);
	}

	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的抽成金额
	 */
	@Override
	public Map<String, List<BigDecimal>> getAmountByTimeType(Integer timeType) {
		if (timeType == null) {
			// 默认是时间类型是按天查询
			timeType = DateUtil.DATE_TYPE_DAY;
		}
		Map<String, List<BigDecimal>> result = new HashMap<String, List<BigDecimal>>();
		Map<String, Object> map = null;
		// 统计总的抽成金额
		List<BigDecimal> totalAmount = new ArrayList<BigDecimal>();
		for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
			// 获取n天前的订单查询时间
			if (DateUtil.DATE_TYPE_DAY == timeType) {
				map = DateUtil.getNormalTime(i);
			} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
				map = DateUtil.getMonthTime(i, DateUtil.NORMAL_TIME_TYPE);
			}
			// 根据时间统计总的抽成金额
			BigDecimal percentAmount = orderPercentageDao.getAmountByTimeType(map);
			if (percentAmount == null) {
				percentAmount = BigDecimal.ZERO;
			}
			// 将抽成金额结果添加到集合
			totalAmount.add(percentAmount);
		}
		result.put(ChartTitleEnum.PercentageTotalAmount.getName(), totalAmount);
		
		// 查询所有区域
		List<Area> areas = areaDao.getRegions();
		if (CollectionUtils.isEmpty(areas)) {
			return result;
		}
		// 遍历所有区
		for (Area area : areas) {
			if (area == null || area.getId() == null) {
				continue;
			}
			Long regionId = area.getId();
			String regionName = area.getAreaName();
			List<BigDecimal> counts = new ArrayList<BigDecimal>();
			for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
				// 获取n天前的订单查询时间
				if (DateUtil.DATE_TYPE_DAY == timeType) {
					map = DateUtil.getNormalTime(i);
				} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
					map = DateUtil.getMonthTime(i, DateUtil.NORMAL_TIME_TYPE);
				}
				map.put("regionId", regionId);
				// 根据区域和时间查询抽成金额
				BigDecimal percentAmount = orderPercentageDao.getAmountByTimeType(map);
				if (percentAmount == null) {
					percentAmount = BigDecimal.ZERO;
				}
				// 将抽成金额结果添加到集合
				counts.add(percentAmount);
			}
			if (StringUtils.isNotBlank(regionName)) {
				regionName += ChartTitleEnum.PercentageAmount.getName();;
			}
			result.put(regionName, counts);
		}
		return result;
	}

	/**
	 * 根据区域查询平台抽点的总金额
	 */
	@Override
	public BigDecimal getPercentageAmount(Long areaId) {
		return orderPercentageDao.getPercentageAmount(areaId);
	}

	@Override
	public PageUtil getPageResult(OrderPercentageVo percentage, Integer currentPageNum, Integer currentPageSize) {
		int size = orderPercentageDao.getAmountByDateCount(percentage);

		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if (size < offset) {
			offset = 0;
		}
		List<OrderPercentageVo> result = orderPercentageDao.getAmountByDate(percentage, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public List<OrderPercentageVo> getAmountByDate(OrderPercentageVo percentage, Integer currentPageNum,
			Integer currentPageSize) {
		return orderPercentageDao.getAmountByDate(percentage, currentPageNum, currentPageSize);
	}

	/**
	 * 根据id删除数据
	 */
	@Override
	public int deleteById(Long id) {
		return orderPercentageDao.deleteById(id);
	}
}
