package com.netcai.admin.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerExpense;

/**
 * 买家消费信息Dao
 * @author administrator
 *
 */
public interface BuyerExpenseDao {
	
	/**
	 * 根据map查询买家消费信息
	 * @param map
	 * @return
	 */
	public List<BuyerExpense> getBuyerExpenses(Map<String, Object> map);
	
	/**
	 * 查询所有有订单的买家信息 
	 * @param map
	 * @return
	 */
	public List<BuyerExpense> getAllBuyers(@Param("buyerPhone") String buyerPhone,@Param("offset") int offset,@Param("pageSize") int pageSize);
	
	/**
	 * 查询总的记录数
	 * @param buyerPhone
	 * @return
	 */
	public int getPageCount(@Param("buyerPhone") String buyerPhone);

}
