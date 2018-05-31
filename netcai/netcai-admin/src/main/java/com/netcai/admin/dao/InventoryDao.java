package com.netcai.admin.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Inventory;
import com.netcai.admin.vo.InventoryVo;

public interface InventoryDao {

	/**
	 * 分页查询
	 * 
	 * @param inventory
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<InventoryVo> getAll(@Param("inventory") InventoryVo inventory, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount();
	
	/**
	 * 批量新增
	 * @param inventoryList
	 * @return
	 */
	public int batchInsert(@Param("inventoryList")List<Inventory> inventoryList);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
    public int delete(Long id);
}
