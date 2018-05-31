package com.netcai.buyer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.CouponLogsDao;
import com.netcai.buyer.entity.CouponLogs;
import com.netcai.buyer.service.CouponLogsService;

/**
 * 优惠券消费记录表serviceImpl
 * @author administrator
 *
 */

@Service
public class CouponLogsServiceImpl implements CouponLogsService{
	
	@Autowired
	private CouponLogsDao couponLogsDao;
	
	/**
	 * 根据订单号查询优惠券消费日志
	 */
	@Override
	public CouponLogs getLogByOrderNum(String orderNum) {
		return couponLogsDao.getLogByOrderNum(orderNum);
	}

}
