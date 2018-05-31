package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.BillExceptionLog;

/**
 * 卖家余额异常日志
 * 
 * @author administrator
 *
 */
public interface BillExceptionLogService {

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	public List<BillExceptionLog> getAll();

}
