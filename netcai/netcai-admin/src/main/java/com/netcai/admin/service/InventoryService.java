package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Inventory;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.InventoryVo;

public interface InventoryService {
	
	/**
	 * 分页查询
	 * 
	 * @param inventory
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(InventoryVo inventory,int pageNum,int pageSize);
	
	/**
	 * 获取所有的区
	 * @return
	 */
	public List<Area> getRegions();
	
	/**
	 * 获取商品分类节点
	 * @return
	 */
	public Object getTreeNodes();
	
	/**
	 * 批量新增
	 * @param inventoryList
	 * @return
	 */
	public int batchInsert(List<Inventory> inventoryList);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
    public int delete(Long id);
}
