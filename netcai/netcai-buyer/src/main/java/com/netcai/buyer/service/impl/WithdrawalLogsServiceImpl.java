package com.netcai.buyer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.WithdrawalLogsDao;
import com.netcai.buyer.entity.WithdrawalLogs;
import com.netcai.buyer.service.WithdrawalLogsService;

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