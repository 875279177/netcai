package com.netcai.admin.dao;

import java.util.List;

import com.netcai.admin.entity.Company;

/**
 * 公司信息Dao
 */
public interface CompanyDao {
	
	/**
	 */
	public List<Company> getList();
	
	/**
	 */
	public Company getById(Long id);
	
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

	
	public int delete(Long companyId);
}
