package com.netcai.buyer.service;

import com.netcai.buyer.entity.CouponLogs;

/**
 * 优惠券消费记录表service
 * @author administrator
 *
 */
public interface CouponLogsService {
	
	/**
	 * 根据订单号查询优惠券消费日志
	 * @param orderNum
	 * @return
	 */
	public CouponLogs getLogByOrderNum(String orderNum);

}
