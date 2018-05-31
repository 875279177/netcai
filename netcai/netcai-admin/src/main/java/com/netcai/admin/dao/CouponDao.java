package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Coupon;

public interface CouponDao {

	public int delete(@Param("id")Long id);

	public int insert(@Param("c")Coupon coupon);
	
	public int batchInsert(@Param("c")List<Coupon> coupons);
	
	public int getPageCount(@Param("c")Coupon coupon);

	public List<Coupon> getAll(@Param("c")Coupon coupon,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

	public int update(@Param("c")Coupon coupon);
	
	public int updateStatus(@Param("status")Integer status,@Param("id")Integer id);
}