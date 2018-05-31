package com.netcai.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.UpgradeDao;
import com.netcai.admin.entity.Upgrade;
import com.netcai.admin.service.UpgradeService;

@Service
public class UpgradeServiceImpl implements UpgradeService {

	@Autowired
	private UpgradeDao upgradeDao;
	
	@Override
	public Upgrade getUpgrade(String name, String type) {
		return upgradeDao.getUpgrade(name, type);
	}
}
