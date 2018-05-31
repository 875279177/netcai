package com.netcai.buyer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.PayLogsDao;
import com.netcai.buyer.entity.PayLogs;
import com.netcai.buyer.service.PayLogsService;

@Service
public class PayLogsServiceImpl implements PayLogsService{

	@Autowired
	private PayLogsDao payLogsDao;
	
	@Override
	public int addPayLogs(PayLogs payLogs) 
	{
		return this.payLogsDao.addPayLogs(payLogs);
	}

	@Override
	public PayLogs getPayLogsByOrderNumber(String orderNumber) 
	{
		return payLogsDao.getPayLogsByOrderNumber(orderNumber);
	}

	@Override
	public int updatePayLogs(PayLogs payLogs) 
	{
		return payLogsDao.updatePayLogs(payLogs);
	}
}