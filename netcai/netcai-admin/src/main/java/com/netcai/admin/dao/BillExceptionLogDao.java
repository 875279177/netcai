package com.netcai.admin.dao;

import java.util.List;

import com.netcai.admin.entity.BillExceptionLog;

public interface BillExceptionLogDao {

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	public List<BillExceptionLog> getAll();

	/**
	 * 批量新增数据
	 * 
	 * @param list
	 * @return
	 */
	public int batchInsert(List<BillExceptionLog> list);

}
