package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.CouponReceive;

/**
 * 优惠券领取记录表Dao
 * @author administrator
 *
 */
public interface CouponReceiveDao {
	
	/**
	 * 根据买家查询其所有优惠券
	 * @return
	 */
	public List<CouponReceive> selectAllByBuyerId(Long buyerId);
	
	/**
	 * 根据买家id查询是否有优惠券可以领取 
	 * @return
	 */
	public CouponReceive selectByBuyerId(@Param("buyerId")Long buyerId,@Param("couponId")Long couponId);
	
	/**
	 * 根据买家和优惠券配置id查询买家优惠券
	 * @param buyerId
	 * @param couponId
	 * @return
	 */
	public CouponReceive selectByBuerIdAndCouponId(@Param("buyerId")Long buyerId,@Param("couponId")Long couponId);
	
	/**
	 * 根据买家id查询可用的优惠券
	 * @param buyerId
	 * @param couponId
	 * @return
	 */
	public CouponReceive getAvailableByBuyerId(@Param("buyerId")Long buyerId,@Param("couponId")Long couponId);
	
	/**
	 * 根据id查询未使用过的优惠券
	 * @param id
	 * @return
	 */
	public CouponReceive selectById(Long id);
	
	/**
	 * 新增数据
	 * @param couponReceive
	 * @return
	 */
	public int insert(CouponReceive couponReceive);
	
	/**
	 * 更新优惠券状态为已用
	 * @param id
	 * @return
	 */
	public int update(Long id);
	
}