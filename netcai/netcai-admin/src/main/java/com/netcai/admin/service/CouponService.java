package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Coupon;
import com.netcai.admin.utils.PageUtil;
/**
 *优惠券基础配置表
 *service
 */
public interface CouponService {
	
	/**
	 *删除; 
	 */
	public int delete(Long id);
	/**
	 *新增;
	 */
	public int insert(Coupon coupon);
	/**
	 *批量新增;
	 */
	public int batchInsert(List<Coupon> coupons);
	/**
	 *查询列表; 
	 */
	public PageUtil getPageResult(Coupon coupon, Integer currentPageNum, Integer currentPageSize);
	/**
	 *修改; 
	 */
	public int update(Coupon coupon);
	/**
	 *更改活动状态; 
	 */
	public int updateStatus(Integer status,Integer id);
}
