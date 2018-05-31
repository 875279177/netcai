package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.CouponLogs;

public interface CouponLogsDao {
	
	public int deleteById(@Param("id") Long id);
	
	public int insert(@Param("c") CouponLogs couponLogs);

	public CouponLogs getById(@Param("id") Long id);
	
	public List<CouponLogs> getAll(@Param("c") CouponLogs couponLogs);

	public int update(@Param("c") CouponLogs couponLogs);

}