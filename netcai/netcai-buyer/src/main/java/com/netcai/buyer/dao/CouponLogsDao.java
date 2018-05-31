package com.netcai.buyer.dao;

import com.netcai.buyer.entity.CouponLogs;

/**
 * 优惠券消费记录表Dao
 * @author administrator
 *
 */
public interface CouponLogsDao {
	
	/**
	 * 新增优惠券消费记录表
	 * @param couponLogs
	 * @return
	 */
	public int insert(CouponLogs couponLogs);
	
	/**
	 * 更新日志状态
	 * @param orderNum
	 * @return
	 */
	public int updateStatus(String orderNum);
	
	/**
	 * 根据订单号查询优惠券id
	 * @param orderNum
	 * @return
	 */
	public Long getCouponIdByOrderNum(String orderNum);
	
	/**
	 * 根据订单号查询优惠券消费日志
	 * @param orderNum
	 * @return
	 */
	public CouponLogs getLogByOrderNum(String orderNum);

}