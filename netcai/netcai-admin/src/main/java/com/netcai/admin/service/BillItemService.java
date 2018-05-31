package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.BillItem;

/**
 * 账单明细service
 * @author administrator
 *
 */
public interface BillItemService {
	
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
	
	/**
	 * 新增账单对应的账单明细
	 * @param sellerId
	 * @param billId
	 */
	public void addBills(Long sellerId,Long billId);

}
