package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerReceiptDao;
import com.netcai.admin.entity.BuyerReceipt;
import com.netcai.admin.service.BuyerReceiptService;
import com.netcai.admin.utils.PageUtil;

/**
 */
@Service
public class BuyerReceiptServiceImpl implements BuyerReceiptService{

	@Autowired
	private BuyerReceiptDao buyerReceiptDao;
	/**
	 * 分页查询所有
	 */
	@Override
	public PageUtil getPageResult(BuyerReceipt buyerReceipt, Integer pageNum, Integer pageSize) {
		int size = buyerReceiptDao.getPageCount(buyerReceipt);
		int offset = 0;
		if (pageNum > 1) {
			offset = (pageNum - 1) * pageSize;
		}
		if (size < offset) {
			offset = 0;
		}
		List<BuyerReceipt> result = buyerReceiptDao.selectList(buyerReceipt, offset, pageSize);
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);
		paginator.setObject(result);
		return paginator;
	}
	/**
	 *  修改核实状态
	 */
	@Override
	public int updateHSStatus(Integer status, Integer id) {
		return buyerReceiptDao.updateHSStatus(status, id);
	}
	/**
	 *  修改收款状态
	 */
	@Override
	public int updateRZStatus(Integer status, Integer id) {
		return buyerReceiptDao.updateRZStatus(status, id);
	}
	/**
	 *  修改实收金额
	 */
	@Override
	public int updateSSAmt(BigDecimal ssAmt, Integer id) {
		return buyerReceiptDao.updateSSAmt(ssAmt, id);
	}
	/**
	 *  修改收款状态
	 */
	@Override
	public int updateSKReamk(String skReamk, Integer id) {
		return buyerReceiptDao.updateSKReamk(skReamk, id);
	}
	/**
	 * 查询所有 不分页
	 */
	@Override
	public List<BuyerReceipt> selectList(BuyerReceipt buyerReceipt) {
		return buyerReceiptDao.selectList(buyerReceipt, null, null);
	}
	/**
	 * 批量	核实状态
	 */
	@Override
	public int batchUpdateHSStatus(List<Long> ids, Integer hSStatus) {
		return buyerReceiptDao.batchUpdateHSStatus(ids, hSStatus);
	}
	/**
	 * 批量	收款状态
	 */
	@Override
	public int batchUpdateRZStatus(List<Long> ids, Integer rZStatus) {
		return buyerReceiptDao.batchUpdateRZStatus(ids, rZStatus);
	}
	
}
