package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.BuyerExpense;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerExpenseVo;

/**
 * 买家消费信息Service
 * 
 * @author administrator
 *
 */
public interface BuyerExpenseService {

	/**
	 * 分页查询买家消费信息
	 * 
	 * @param buyerExpenseVo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(BuyerExpenseVo buyerExpenseVo, int pageNum, int pageSize);

	/**
	 * 根据map查询买家消费信息
	 * 
	 * @param buyers
	 * @return
	 */
	public List<BuyerExpenseVo> getBuyersExpense(List<BuyerExpense> buyers);

}
