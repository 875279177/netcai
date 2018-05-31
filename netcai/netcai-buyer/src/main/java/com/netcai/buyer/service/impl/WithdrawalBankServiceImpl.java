package com.netcai.buyer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.WithdrawalBankDao;
import com.netcai.buyer.entity.WithdrawalBank;
import com.netcai.buyer.service.WithdrawalBankService;

/**
 * @author administrator
 */

@Service
public class WithdrawalBankServiceImpl implements WithdrawalBankService {

	@Autowired
	private WithdrawalBankDao withdrawalBankDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public WithdrawalBank getWithdrawalBankById(Long id) {
		return withdrawalBankDao.getWithdrawalBankById(id);
	}


	/**
	 * 通过条件查询 
	 */
	@Override
	public List<WithdrawalBank> getResult(WithdrawalBank withdrawalBank) {
		
		return withdrawalBankDao.getWithdrawalBank(withdrawalBank);
	}


	@Override
	public int insertWithdrawalBank(WithdrawalBank withdrawalBank) 
	{
		withdrawalBank.setCreateTime(new Date());
		return withdrawalBankDao.insertWithdrawalBank(withdrawalBank);
	}


	@Override
	public List<WithdrawalBank> getWithdrawalBankByUid(Long id) {
		return withdrawalBankDao.getWithdrawalBankByUid(id);
	}
}