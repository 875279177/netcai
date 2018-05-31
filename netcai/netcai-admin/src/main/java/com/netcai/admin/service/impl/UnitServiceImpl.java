package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.UnitDao;
import com.netcai.admin.entity.Unit;
import com.netcai.admin.service.UnitService;
import com.netcai.admin.utils.PageUtil;

/**
 * 计量单位serviceimpl
 * @author administrator
 */
@Service
public class UnitServiceImpl implements UnitService{
	
	@Autowired
	private UnitDao unitDao;
	
	/**
	 * 分页查询计量单位
	 * @param currentPageNum
	 * @param currentPageSize
	 * @return
	 */
	public List<Unit> getAllUnit(String unitCode, String unitName,int currentPageNum,int currentPageSize){
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		return unitDao.getAllUnit(unitCode, unitName,offset, currentPageSize);
	}

	/**
	 * 查询总记录数
	 * @return PageUtil
	 */
	public PageUtil getPageResult(String unitCode, String unitName,int currentPageNum,int currentPageSize){
		int size = unitDao.getPageCount(unitCode, unitName);
		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<Unit> result = unitDao.getAllUnit(unitCode, unitName,offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}

	/**
	 * 添加计量单位
	 */
	@Override
	public int insertUnit(Unit unit) {
		return unitDao.insertUnit(unit);
	}

	/**
	 * 更新计量单位
	 */
	@Override
	public int updateUnit(Unit unit) {
		return unitDao.updateUnit(unit);
	}

	
	/**
	 * 根据id查找计量单位
	 */
	@Override
	public Unit getUnitById(int unitId){
		return unitDao.getUnitById(unitId);
	}
	
	/**
	 * 取得所有在用的计量单位
	 */
	@Override
	public List<Unit> getAllUnitByStatus(){
		return unitDao.getAllUnitByStatus();
	}
}
