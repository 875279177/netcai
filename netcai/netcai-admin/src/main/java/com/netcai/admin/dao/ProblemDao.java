package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Problem;

public interface ProblemDao {
	/**
	 *  删除
	 */
	public int deleteById(@Param("id")Long id);
	/**
	 *  新增
	 */
	public int insert(@Param("r")Problem record);
	/**
	 *  单个查询
	 */
	public Problem selectById(@Param("id")Long id);
	/**
	 *  分页所有
	 */
	public List<Problem> selectList(@Param("r")Problem problem,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	/**
	 * 计算数量
	 */
	public int getPageCount(@Param("r") Problem problem);
	/**
	 *  修改
	 */
	public int update(@Param("r")Problem problem);
}