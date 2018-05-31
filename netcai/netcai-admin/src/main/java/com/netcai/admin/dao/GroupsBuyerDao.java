package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.GroupsBuyer;

public interface GroupsBuyerDao {
	
	public List<GroupsBuyer> getList(@Param("g")GroupsBuyer groupsBuyer,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	public int getCount(@Param("g")GroupsBuyer groupsBuyer);
	
	public List<GroupsBuyer> getGroupsSuccessful();
	
	public List<GroupsBuyer> getGroupsFail();
}