package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Withdrawal;

/**
 * 提现信息DAO
 * @author administrator
 */
public interface WithdrawalDao {

	/**
	 * 通过Id查询单个
	 */
	public Withdrawal getWithdrawalByKey(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<Withdrawal> getWithdrawal( @Param("w")Withdrawal w  ,@Param("pageNum") int pageNum,@Param("pageSize") int pageSize);

	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("w")Withdrawal w);
	
	/**
	 * 修改Status
	 */
	public int updateStatus(@Param("w")Withdrawal w);
	
	/**
	 * 添加
	 */
	public int insertWithdrawal(Withdrawal withdrawal);
	
	/**
	 * 通过订单id查询多个
	 */
	public List<Withdrawal> getWithdrawalByWithdrawOrder(String withdrawOrder);
	
	/**
	 * 根据id更新实际提现金额和手续费
	 * @param withdrawal
	 * @return
	 */
	public int updateRealityTotalAndCharge(Withdrawal withdrawal);
}