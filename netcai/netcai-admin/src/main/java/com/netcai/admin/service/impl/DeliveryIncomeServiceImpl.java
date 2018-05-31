package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.DeliveryIncomeDao;
import com.netcai.admin.entity.DeliveryIncome;
import com.netcai.admin.service.DeliveryIncomeService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;

/**
 * 配送人员收入serviceImpl
 * @author administrator
 *
 */
@Service
public class DeliveryIncomeServiceImpl implements DeliveryIncomeService{
	
	@Autowired
	private DeliveryIncomeDao deliveryIncomeDao;
	
	/**
	 * 查询全部数据
	 */
	@Override
	public PageUtil getPageResult(DeliveryIncome deliveryIncome, Integer currentPageNum, Integer currentPageSize) {
		int size = deliveryIncomeDao.getCount(deliveryIncome);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<DeliveryIncome> result = deliveryIncomeDao.getAll(deliveryIncome, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);
		return paginator;
	}
	
	/**
	 * 批量新增配送人员收入 （定时器执行）
	 */
	@Override
	public int calculatedDeliveryIncome() {
		//获取昨天的时间
		Date time = DateUtil.addDay(new Date(), -1);
		return deliveryIncomeDao.batchInsertByDate(time);
	}

	@Override
	public List<BuyerVo> getBuyer(DeliveryIncome deliveryIncome) {
		return deliveryIncomeDao.getBuyer(deliveryIncome);
	}

	@Override
	public List<DeliveryIncome> getResult(DeliveryIncome deliveryIncome, Integer currentPageNum, Integer currentPageSize) {
		return deliveryIncomeDao.getAll(deliveryIncome, currentPageNum, currentPageSize);
	}

}
