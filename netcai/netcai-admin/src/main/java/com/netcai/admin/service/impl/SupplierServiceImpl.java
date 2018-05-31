package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SupplierDao;
import com.netcai.admin.entity.Supplier;
import com.netcai.admin.service.SupplierService;
import com.netcai.admin.utils.PageUtil;

/**
 */
@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	private SupplierDao supplierDao;

	@Override
	public int deleteById(Long supplierId) {
		return supplierDao.deleteById(supplierId);
	}

	@Override
	public int insert(Supplier supplier) {
		return supplierDao.insert(supplier);
	}

	@Override
	public Supplier selectById(Long supplierId) {
		return supplierDao.selectById(supplierId);
	}

	@Override
	public int updateById(Supplier supplier) {
		return supplierDao.updateById(supplier);
	}

	@Override
	public PageUtil getList(Supplier supplier, Integer pageNum, Integer pageSize) {
		
		int size = supplierDao.getCount(supplier);
		
		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;
		if (size < offset) {
			offset = 0;
		}
		List<Supplier> result = supplierDao.getList(supplier, offset, pageSize);
		
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public int updateStatus(Supplier supplier) {
		return supplierDao.updateStatus(supplier);
	}
}