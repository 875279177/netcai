package com.netcai.buyer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.WithdrawalDao;
import com.netcai.buyer.dao.WithdrawalLogsDao;
import com.netcai.buyer.entity.Withdrawal;
import com.netcai.buyer.entity.WithdrawalLogs;
import com.netcai.buyer.service.WithdrawalService;
import com.netcai.buyer.utils.PageUtil;

/**
 * 提现服务层实现
 * @author administrator
 */
@Service
public class WithdrawalServiceImpl implements WithdrawalService {

	@Autowired
	private WithdrawalDao withdrawalDao;

	@Autowired
	private WithdrawalLogsDao WithdrawalLogsDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public Withdrawal getWithdrawalById(Long id) {
		return withdrawalDao.getWithdrawalByKey(id);
	}
	/**
	 * 通过条件查询
	 */
	@Override
	public PageUtil getPageResult(Withdrawal withdrawal, int currentPageNum, int currentPageSize) {

		int size = withdrawalDao.getPageCount(withdrawal);

		int offset = currentPageNum > 1 ? (currentPageNum - 1) * currentPageSize : 0;

		List<Withdrawal> result = withdrawalDao.getWithdrawal(withdrawal, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public void applyWithdrawal(Withdrawal withdrawal, WithdrawalLogs withdrawalLogs) 
	{
		withdrawalDao.insertWithdrawal(withdrawal);
		WithdrawalLogsDao.insertWithdrawalLogs(withdrawalLogs);
	}
	@Override
	public Withdrawal getWithdrawalByWithdrawOrder(String withdrawOrder) {
		return withdrawalDao.getWithdrawalByWithdrawOrder(withdrawOrder);
	}
}