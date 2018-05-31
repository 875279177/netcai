package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Reported;
import com.netcai.admin.utils.PageUtil;

public interface ReportedService {
	
	/**
	 * 消息数量
	 */
	public int getCount(Reported reported);
	/**
	 * 通过条件查询 
	 */
	public PageUtil getPageResult(Reported reported, int currentPageNum, int currentPageSize);
	/**
	 * 通过条件查询 
	 */
	public List<Reported> getList(Reported reported);
	/**
	 *  更改阅读状态
	 */
	public int updateReadStatus(Long id,Long rReadStatus);
	/**
	 *  更改解决状态 
	 */
	public int updateSolveStatus(Long id,Long rSolveStatus);
}
