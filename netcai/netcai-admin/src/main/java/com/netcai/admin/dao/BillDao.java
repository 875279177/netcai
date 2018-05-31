package com.netcai.admin.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Bill;
import com.netcai.admin.vo.BillVo;

/**
 * 卖家账单Dao
 * @author administrator
 *
 */
public interface BillDao {
	
	/**
	 * 分页查询账单信息
	 * 
	 * @param bill
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Bill> getAll(@Param("bill") BillVo bill, @Param("offset") int offset,
			@Param("pageSize") int pageSize);
	

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount(@Param("bill") BillVo bill);
	
	/**
	 * 根据卖家id查询
	 * @param map
	 * @return
	 */
	public List<BillVo> getBillsBySellerId(Map<String, Object> map);
	
	/**
	 * 批量新增
	 * @param bills
	 * @return
	 */
	public int batchInsert(List<Bill> bills);
	
	/**
	 * 根据账单id更新扣款和实收款
	 * @param BillVo
	 * @return
	 */
	public int update(BillVo bill);
	
	/**
	 * 根据卖家分组汇总账单实际金额
	 * @return
	 */
	public List<Map<String, Object>> getRealIncome();
	
	/**
	 *  更正卖家的余额
	 *  @return
	 */
	public List<Map<String, Object>> correctSellerAmount();
	
	/**
	 * 根据时间查询账单实际金额和抽点金额
	 * @param time
	 * @return
	 */
	public List<Map<String, Object>> getRealMoneyAndPercentageAmount(Date time);
	
	/**
	 * 批量更新账单实际金额
	 * @param map
	 * @return
	 */
	public int batchUpdateRealitymoney(List<Map<String, Object>> map);
	
	/**
	 * 根据时间和卖家id查询账单信息
	 */
	public BillVo getBillSellerIdAndByDate(@Param("day")String day,@Param("sellerId")Long sellerId);
}
