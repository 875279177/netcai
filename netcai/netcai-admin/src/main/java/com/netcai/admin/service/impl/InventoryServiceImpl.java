package com.netcai.admin.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.dao.InventoryDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Inventory;
import com.netcai.admin.service.InventoryService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.InventoryVo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private AreaDao areaDao;

	@Autowired
	private InventoryDao inventoryDao;

	/**
	 * 分页查询
	 */
	@Override
	public PageUtil getAll(InventoryVo inventory, int pageNum, int pageSize) {
		int size = inventoryDao.getPageCount();

		int offset = pageNum > 1 ? (pageNum - 1) * pageSize : 0;

		List<InventoryVo> result = inventoryDao.getAll(inventory, offset, pageSize);

		PageUtil paginator = new PageUtil(pageSize, size, pageNum);

		paginator.setObject(result);

		return paginator;
	}
	
	/**
	 * 获取区域
	 */
	@Override
	public List<Area> getRegions() {
		return areaDao.getRegions();
	}

	/**
	 * 获取所有的树节点
	 */
	@SuppressWarnings("unused")
	@Override
	public Object getTreeNodes() {
		List<Area> regions = areaDao.getRegions();
		// 所有节点的Json数组
		JSONArray treeNodes = null;
		if (CollectionUtils.isEmpty(regions)) {
			return treeNodes;
		}
		treeNodes = new JSONArray();
		for (Area area : regions) {
			JSONObject areaObject = JSONObject.fromObject(area);
			Long regionId = areaObject.getLong("id");
			if (regionId == null) {
				continue;
			}
			//将所有节点添加到JSON数组中
			treeNodes.add(areaObject);
		}
		return treeNodes;
	}
	
	/**
	 * 批量插入数据
	 */
	@Override
	public int batchInsert(List<Inventory> inventoryList) {
		return inventoryDao.batchInsert(inventoryList);
	}
	
	/**
	 * 删除
	 */
	@Override
	public int delete(Long id) {
		return inventoryDao.delete(id);
	}
	
}
