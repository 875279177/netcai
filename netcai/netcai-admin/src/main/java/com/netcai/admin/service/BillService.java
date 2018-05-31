package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillVo;

/**
 * 账单service
 * @author administrator
 *
 */
public interface BillService {
	
	/**
	 * 分页查询账单信息
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(BillVo bill,  int pageNum, int pageSize);
	
	/**
	 * 根据卖家id查询
	 * @param map
	 * @return
	 */
	public List<BillVo> getBillsBySellerId(Map<String, Object> map);
	
	/**
	 * 生成账单
	 */
	public void addBills();
	
	/**
	 * 根据卖家抽点金额更新账单实际金额
	 */
	public int updateRealAmountByPercentage();
	
	/**
	 * 更正卖家的余额
	 */
	public void correctAmount();
	
}
