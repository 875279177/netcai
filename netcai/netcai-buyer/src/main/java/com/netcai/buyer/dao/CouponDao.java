package com.netcai.buyer.dao;

import java.util.List;

import com.netcai.buyer.entity.Coupon;

/**
 * 优惠券配置Dao
 * @author administrator
 *
 */
public interface CouponDao {
    
	/**
	 * 查询买家可以参与的正在进行活动中的优惠券配置
	 * @param buyerId
	 * @return
	 */
	public List<Coupon> selectCoupon(Long buyerId);
	
	/**
	 * 根据id和买家id正在进行活动中的优惠券配置
	 * @param id
	 * @return
	 */
	public Coupon selectCouponById(Long id);
}