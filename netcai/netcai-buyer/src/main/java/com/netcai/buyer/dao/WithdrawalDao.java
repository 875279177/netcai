package com.netcai.buyer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Withdrawal;

/**
 * 提现信息DAO
 * @author administrator
 */
public interface WithdrawalDao {

	/**
	 * 通过Id查询单个
	 * @param 
	 * @return
	 */
	public Withdrawal getWithdrawalByKey(Long id);
	
	/**
	 * 通过条件查询 
	 * @param withdrawal 查询条件
	 * @param pageNum 分页参数
	 * @param pageSize 分页参数
	 * @return
	 */
	public List<Withdrawal> getWithdrawal( @Param("w")Withdrawal w  ,@Param("pageNum") int pageNum,
			@Param("pageSize") int pageSize);
	
	/**
	 * @param 
	 * @return 查询总数
	 */
	public int getPageCount( @Param("w") Withdrawal w);
	
	
	/**
	 * 添加
	 * @param withdrawal
	 */
	public int insertWithdrawal(Withdrawal withdrawal);
	
	/**
	 * 通过提现订单WithdrawOrder查询单个对象
	 * @param 
	 * @return
	 */
	public Withdrawal getWithdrawalByWithdrawOrder(String withdrawOrder);
}