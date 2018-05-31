package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.WithdrawalConstant;
import com.netcai.admin.dao.SellerDao;
import com.netcai.admin.dao.WithdrawalDao;
import com.netcai.admin.dao.WithdrawalLogsDao;
import com.netcai.admin.entity.Seller;
import com.netcai.admin.entity.Withdrawal;
import com.netcai.admin.entity.WithdrawalLogs;
import com.netcai.admin.service.WithdrawalService;
import com.netcai.admin.utils.PageUtil;

/**
 * @author administrator
 */
@Service
public class WithdrawalServiceImpl implements WithdrawalService {

	private static final Logger logger = LoggerFactory.getLogger(WithdrawalServiceImpl.class);

	@Autowired
	private WithdrawalDao withdrawalDao;

	@Autowired
	private WithdrawalLogsDao WithdrawalLogsDao;

	@Autowired
	private SellerDao sellerDao;
	
	/**
	 * 通过Id查询单个
	 */
	@Override
	public Withdrawal getWithdrawalByKey(Long id) {
		return withdrawalDao.getWithdrawalByKey(id);
	}

	/**
	 * 通过条件查询
	 */
	@Override
	public PageUtil getPageResult(Withdrawal withdrawal, int currentPageNum, int currentPageSize) {
		int size = withdrawalDao.getPageCount(withdrawal);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if (size < offset) {
			offset = 0;
		}
		List<Withdrawal> result = withdrawalDao.getWithdrawal(withdrawal, offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}

	@Override
	public int insertWithdrawal(Withdrawal withdrawal) {
		withdrawal.setCreateTime(new Date());
		return withdrawalDao.insertWithdrawal(withdrawal);
	}

	@Override
	public List<Withdrawal> getWithdrawalByWithdrawOrder(String withdrawOrder) {
		return withdrawalDao.getWithdrawalByWithdrawOrder(withdrawOrder);
	}

	@Override
	public void updateStatus(Withdrawal withdrawal, WithdrawalLogs withdrawalLogs, Long sellerId,
			BigDecimal withdrawApplyTotal) {

		int status = withdrawal.getStatus();
		// 如果交易完成
		if (status == WithdrawalConstant.FINISH_WITHDRAWAL) {
			Seller seller = sellerDao.getSellerByKey(sellerId).get(0);
			// 卖家余额
			BigDecimal balanceMoney = seller.getBalanceMoney();
			// 可提现金额;
			BigDecimal billMoney = seller.getBillMoney();

			// 获取最终的余额
			BigDecimal subtractBalanceMoney = balanceMoney.subtract(withdrawApplyTotal);

			// 获取最终的可提现金额
			BigDecimal subtractBillMoney = billMoney.subtract(withdrawApplyTotal);

			logger.info("[WithdrawalServiceImpl]操作完成更新卖家的余额以及可提现金额");
			logger.info("当前的余额为：balanceMoney=" + balanceMoney + " 处理后的余额为：" + subtractBalanceMoney);
			logger.info("当前的可提现余额为：billMoney=" + billMoney + " 处理后的可提现余额为：" + subtractBillMoney);
			// 改变余额和可提现金额;
			int result = sellerDao.updateBalanceMoneyAndBillMoney(sellerId, subtractBalanceMoney, subtractBillMoney);
			logger.info("操作结果为：" + (result > 0));
		}
		// 更新提现状态
		withdrawalDao.updateStatus(withdrawal);
		// 插入提现日志记录
		WithdrawalLogsDao.insertWithdrawalLogs(withdrawalLogs);
	}
}