package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.PriceReviseDao;
import com.netcai.admin.service.PriceReviseService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.PriceReviseVo;

/**
 * 商品价格调整ServiceImpl
 * 
 * @author administrator
 *
 */
@Service
public class PriceReviseServiceImpl implements PriceReviseService {

	@Autowired
	private PriceReviseDao priceReviseDao;

	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAllPriceRevise(PriceReviseVo priceRevise, int pageNum, int pageSize) {
		// 查询总的记录数
		int size = priceReviseDao.getPageCount( priceRevise);

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		if (size < offset) {
			offset = 0;
		}

		String startTime = priceRevise.getStartTimeStr();
		String endTime = priceRevise.getEndTimeStr();
		Date start_time = null;
		Date end_time = null;
		if (StringUtils.isNotBlank(startTime)) {
			// 开始时间设置为当天的00：00：00
			startTime += DateUtil.NOMAL_START;
			start_time = DateUtil.stringToDate(startTime, DateUtil.FMT_DATETIME);
			priceRevise.setStartTime(start_time);
			// 先设置结束时间为今天
			priceRevise.setEndTime(new Date());
		}

		if (StringUtils.isNotBlank(endTime)) {
			// 结束时间设置为当天的23:59:59
			endTime += DateUtil.NOMAL_END;
			end_time = DateUtil.stringToDate(endTime, DateUtil.FMT_DATETIME);
			if (start_time != null) {
				long result = DateUtil.getMillisecondDifference(start_time, end_time);
				// 如果结束时间早于开始时间，就查询当天的数据
				if (result <= 0) {
					// 设置结束时间为开始时间的23:59:59
					endTime = priceRevise.getStartTimeStr() + DateUtil.NOMAL_END;
					end_time = DateUtil.stringToDate(endTime, DateUtil.FMT_DATETIME);
					priceRevise.setEndTime(end_time);
				}
			}else {
				// 开始时间设置为结束时间的00：00：00
				startTime = priceRevise.getEndTimeStr()+DateUtil.NOMAL_START;
				start_time = DateUtil.stringToDate(startTime, DateUtil.FMT_DATETIME);
				priceRevise.setStartTime(start_time);
			}

			priceRevise.setEndTime(end_time);
		} 

		List<PriceReviseVo> result = priceReviseDao.getAllPriceRevise(priceRevise, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

}
