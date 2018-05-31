package com.netcai.admin.service;

import java.util.List;

import com.netcai.admin.entity.Unit;
import com.netcai.admin.utils.PageUtil;

/**
 * 计量单位service
 * @author administrator
 */
public interface UnitService {
	
	/**
	 * 分页查询计量单位
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<Unit> getAllUnit(String unitCode, String unitName,int currentPageNum,int currentPageSize);

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(String unitCode, String unitName,int currentPageNum,int currentPageSize);

	/**
	 * 添加计量单位
	 */
	public int insertUnit(Unit unit);

	/**
	 * 更新计量单位
	 */
	public int updateUnit(Unit unit);
	
	/**
	 * 根据id查找计量单位
	 */
	public Unit getUnitById(int unitId);
	
	/**
	 * 取得所有在用的计量单位
	 */
	public List<Unit> getAllUnitByStatus();
}
