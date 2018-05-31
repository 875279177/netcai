package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SalesPlan;

/**
 * 销售目标Dao
 * @author administrator
 */
public interface SalesPlanDao {

	/**
	 * 分页查询销售目标
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<SalesPlan> getAllSalesPlan(@Param("salesPlan") SalesPlan salesPlan,@Param("offset") int offset,
			@Param("pageSize") int pageSize);
	

	/**
	 * 查询总记录数
	 */
	public int getPageCount(@Param("salesPlan") SalesPlan salesPlan);
	
	
	/**
	 * 新增商品信息
	 */
	public long insertSalesPlan(SalesPlan salesPlan);

	/**
	 * 更新商品信息
	 */
	public int updateSalesPlan(SalesPlan salesPlan);
	
	/**
	 * 根据id查找商品信息
	 */
	public SalesPlan getSalesPlanById(@Param("spId") Long spId);
}
