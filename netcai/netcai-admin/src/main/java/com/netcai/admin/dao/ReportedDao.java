package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Reported;

public interface ReportedDao {
	
	/**
	 * 计算数量
	 */
	public int getPageCount(@Param("r") Reported reported);
	/**
	 *  分页所有
	 */
	public List<Reported> getPageList(@Param("r") Reported reported,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	/**
	 *  更改阅读状态
	 */
	public int updateReadStatus(@Param("id") Long id,@Param("rReadStatus") Long rReadStatus);
	/**
	 *  更改解决状态 
	 */
	public int updateSolveStatus(@Param("id") Long id,@Param("rSolveStatus") Long rSolveStatus);
}