package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Supplier;

public interface SupplierDao {
	
	public int deleteById(@Param("supplierId")Long supplierId);

	public int insert(Supplier supplier);

	public Supplier selectById(@Param("supplierId") Long supplierId);

	public int updateById(Supplier supplier);
	
	public int getCount(@Param("s") Supplier supplier);
	
	public List<Supplier> getList(@Param("s") Supplier supplier,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	public int updateStatus(@Param("s") Supplier supplier);
}