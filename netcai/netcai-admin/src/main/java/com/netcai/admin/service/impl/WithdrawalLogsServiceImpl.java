package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.WithdrawalLogsDao;
import com.netcai.admin.entity.WithdrawalLogs;
import com.netcai.admin.service.WithdrawalLogsService;

/**
 * @author administrator
 */

@Service
public class WithdrawalLogsServiceImpl implements WithdrawalLogsService {

	@Autowired
	private WithdrawalLogsDao WithdrawalLogsDao;

	@Override
	public List<WithdrawalLogs> getWithdrawalLogsByWithdrawOrder(String withdrawOrder) {
		
		return WithdrawalLogsDao.getWithdrawalLogsByWithdrawOrder(withdrawOrder);
		
	}

	@Override
	public int insertWithdrawalLogs(WithdrawalLogs withdrawalLogs) {
		return WithdrawalLogsDao.insertWithdrawalLogs(withdrawalLogs);
	}
	


	
	
}