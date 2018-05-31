package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.CompanyDao;
import com.netcai.admin.entity.Company;
import com.netcai.admin.service.CompanyService;

/**
 */
@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired 
	private CompanyDao companyDao;

	@Override
	public List<Company> getList() {
		return companyDao.getList();
	}

	@Override
	public Long insert(Company company) {
		return companyDao.insert(company);
	}

	@Override
	public int update(Company company) {
		return companyDao.update(company);
	}

	@Override
	public int updateStatus(Company company) {
		return companyDao.updateStatus(company);
	}

	@Override
	public Company getById(Long Id) {
		return companyDao.getById(Id);
	}

	@Override
	public int delete(Long companyId) {
		return companyDao.delete(companyId);
	}
}
