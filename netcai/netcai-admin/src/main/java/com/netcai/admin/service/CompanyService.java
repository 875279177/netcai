package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Company;

public interface CompanyService {
	
	/**
	 */
	public List<Company> getList();
	
	/**
	 */
	public Company getById(Long Id);
	
	/**
	 * 新增
	 */
	public Long insert(Company company);
	
	/**
	 * 修改
	 */
	public int update(Company company);
	
	/**
	 * 更新状态
	 */
	public int updateStatus(Company company);
	
	/**
	 */
	public int delete(Long companyId);
}
