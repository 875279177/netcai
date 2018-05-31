package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.WithdrawalBankDao;
import com.netcai.admin.entity.WithdrawalBank;
import com.netcai.admin.service.WithdrawalBankService;
import com.netcai.admin.utils.PageUtil;

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
	public WithdrawalBank getWithdrawalBankByKey(Long id) {
		return withdrawalBankDao.getWithdrawalBankByKey(id);
	}


	/**
	 * 通过条件查询 
	 */
	@Override
	public PageUtil getPageResult(WithdrawalBank withdrawalBank, int currentPageNum, int currentPageSize) {
		
		int size = withdrawalBankDao.getPageCount(withdrawalBank);
		
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<WithdrawalBank> result = withdrawalBankDao.getWithdrawalBank(withdrawalBank, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}


	@Override
	public void insertWithdrawalBank(WithdrawalBank withdrawalBank) {
		
		if (withdrawalBank != null) {
			
			withdrawalBank.setCreateTime(new Date());
			
			withdrawalBankDao.insertWithdrawalBank(withdrawalBank);
			
		}
	}
	
	
}