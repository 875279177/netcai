package com.netcai.admin.dao;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Upgrade;

public interface UpgradeDao {

	public Upgrade getUpgrade(@Param("name")String name,@Param("type") String type);
}
