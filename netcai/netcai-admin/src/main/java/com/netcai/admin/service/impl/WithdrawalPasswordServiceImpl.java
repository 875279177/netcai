package com.netcai.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.WithdrawalPasswordDao;
import com.netcai.admin.entity.WithdrawalPassword;
import com.netcai.admin.service.WithdrawalPasswordService;
import com.netcai.admin.utils.PageUtil;

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
	public WithdrawalPassword getWithdrawalPasswordByKey(Long id) {
		return withdrawalPasswordDao.getWithdrawalPasswordByKey(id);
	}


	/**
	 * 通过条件查询 
	 */
	@Override
	public PageUtil getPageResult(WithdrawalPassword withdrawalPassword, int currentPageNum, int currentPageSize) {
		
		int size = withdrawalPasswordDao.getPageCount(withdrawalPassword);
		
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		
		List<WithdrawalPassword> result = withdrawalPasswordDao.getWithdrawalPassword(withdrawalPassword,  offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(result);
		
		return paginator;
	}


	@Override
	public void insertWithdrawalPassword(WithdrawalPassword WithdrawalPassword) {
		
		if (WithdrawalPassword != null) {
			
			WithdrawalPassword.setCreateTime(new Date());
			
			withdrawalPasswordDao.insertWithdrawalPassword(WithdrawalPassword);
			
		}
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
	
	
}