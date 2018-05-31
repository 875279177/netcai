package com.netcai.admin.dao;

import java.util.List;

import com.netcai.admin.entity.BillItem;
/**
 * 账单明细Dao
 * @author administrator
 *
 */
public interface BillItemDao {
	
	/**
	 * 根据账单id查询账单明细
	 * @param billId
	 * @return
	 */
	public List<BillItem> getAllByBillId(Long billId);
	
	/**
	 * 新增
	 * @param billItem
	 * @return
	 */
	public int insert(BillItem billItem);
	
}
