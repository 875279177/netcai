package com.netcai.buyer.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.WithdrawalPasswordDao;
import com.netcai.buyer.entity.WithdrawalPassword;
import com.netcai.buyer.service.WithdrawalPasswordService;
import com.netcai.buyer.utils.PageUtil;

/**
 * @author administrator
 */

@Service
public class WithdrawalPasswordServiceImpl implements WithdrawalPasswordService {

	@Autowired
	private WithdrawalPasswordDao withdrawalPasswordDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public WithdrawalPassword getWithdrawalPasswordById(Long id) {
		return withdrawalPasswordDao.getWithdrawalPasswordById(id);
	}


	/**
	 * 通过条件查询 
	 */
	@Override
	public PageUtil getPageResult(WithdrawalPassword withdrawalPassword, int currentPageNum, int currentPageSize) {
		
		int size = withdrawalPasswordDao.getPageCount(withdrawalPassword);
		
		List<WithdrawalPassword> result = withdrawalPasswordDao.getWithdrawalPassword(withdrawalPassword,  currentPageNum, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}


	@Override
	public int insertWithdrawalPassword(WithdrawalPassword WithdrawalPassword) {
		
		if (WithdrawalPassword != null) {
			
			WithdrawalPassword.setCreateTime(new Date());
			
			return withdrawalPasswordDao.insertWithdrawalPassword(WithdrawalPassword);
			
		}
		return 0;
	}

	/**
	 * 初始化密码
	 * @param withdrawalPassword
	 * @return
	 */
	@Override
	public int updatePasswordWithdrawalPassword(WithdrawalPassword withdrawalPassword) {
		return withdrawalPasswordDao.updatePasswordWithdrawalPassword(withdrawalPassword);
	}


	@Override
	public WithdrawalPassword getWithdrawalPasswordByUid(Long id) {
		return withdrawalPasswordDao.getWithdrawalPasswordByUid(id);
	}
	
	
}