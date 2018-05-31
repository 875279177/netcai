package com.netcai.admin.service;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.admin.entity.BuyerReceipt;
import com.netcai.admin.utils.PageUtil;

/**
 *
 */
public interface BuyerReceiptService {
	
	
	public List<BuyerReceipt> selectList(BuyerReceipt buyerReceipt);
	/**
	 * 分页查询所有
	 */
	public PageUtil getPageResult(BuyerReceipt buyerReceipt,Integer pageNum,Integer pageSize);
	/**
	 *  修改核实状态
	 */
	public int updateHSStatus(Integer status,Integer id);
	/**
	 *  修改收款状态
	 */
	public int updateRZStatus(Integer status,Integer id);
	/**
	 *  修改实收金额
	 */
	public int updateSSAmt(BigDecimal ssAmt,Integer id);
	/**
	 *  修改收款状态
	 */
	public int updateSKReamk(String skReamk,Integer id);
	/**
	 * 批量	核实状态
	 */
	public int batchUpdateHSStatus(List<Long> ids,Integer hSStatus);
	/**
	 * 批量	收款状态
	 */
	public int batchUpdateRZStatus(List<Long> ids,Integer rZStatus);
}
