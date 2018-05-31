package com.netcai.admin.service;

import com.netcai.admin.entity.Supplier;
import com.netcai.admin.utils.PageUtil;

/**
 */
public interface SupplierService {
	
	public int deleteById(Long supplierId);

	public int insert(Supplier supplier);

	public Supplier selectById( Long supplierId);

	public int updateById(Supplier supplier);
	
	public PageUtil getList(Supplier supplier, Integer pageNum, Integer pageSize);
	
	public int updateStatus(Supplier supplier);
}
