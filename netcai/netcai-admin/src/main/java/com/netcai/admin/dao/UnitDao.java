package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Unit;

/**
 * 计量单位Dao
 * @author administrator
 */
public interface UnitDao {
	
	/**
	 * 分页查询计量单位
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Unit> getAllUnit(@Param("unitCode") String unitCode,@Param("unitName") String unitName,@Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * @return total
	 */
	public int getPageCount(@Param("unitCode") String unitCode,@Param("unitName") String unitName);

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
	public Unit getUnitById(@Param("unitId") int unitId);
	
	/**
	 * 取得所有在用的计量单位
	 */
	public List<Unit> getAllUnitByStatus();
}
