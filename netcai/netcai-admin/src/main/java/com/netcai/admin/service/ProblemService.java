package com.netcai.admin.service;

import com.netcai.admin.entity.Problem;
import com.netcai.admin.utils.PageUtil;

/**
 *
 */
public interface ProblemService {
	
	/**
	 * 分页查询所有
	 */
	public PageUtil getPageResult(Problem problem,Integer pageNum,Integer pageSize);
	/**
	 *  删除
	 */
	public int deleteById(Long id);
	/**
	 *  新增
	 */
	public int insert(Problem record);
	/**
	 *  单个查询
	 */
	public Problem selectById(Long id);
	/**
	 *  修改
	 */
	public int update(Problem problem);
}
