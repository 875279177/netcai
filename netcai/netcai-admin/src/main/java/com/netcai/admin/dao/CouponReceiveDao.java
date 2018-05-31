package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.CouponReceive;

public interface CouponReceiveDao {
	
	public int delete(@Param("id")Long id);

	public int insert(@Param("c")CouponReceive couponReceive);

	public CouponReceive getById(@Param("id")Long id);
	
	public List<CouponReceive> getAll(@Param("c")CouponReceive couponReceive);

	public int update(@Param("c")CouponReceive couponReceive);

}