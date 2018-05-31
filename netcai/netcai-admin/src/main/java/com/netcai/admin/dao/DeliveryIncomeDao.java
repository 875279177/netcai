package com.netcai.admin.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.DeliveryIncome;
import com.netcai.admin.vo.BuyerVo;

/**
 * 配送人员收入Dao
 * @author administrator
 *
 */
public interface DeliveryIncomeDao {
	
	/**
	 * 查询全部数据
	 */
	public List<DeliveryIncome> getAll( @Param("d")DeliveryIncome d, @Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);
	
	/**
	 * 查询数量
	 */
	public int getCount( @Param("d")DeliveryIncome d);
	
	/**
	 * 批量新增配送人员收入 （定时器执行）
	 */
	public int batchInsertByDate(Date time);
	
	/**
	 * 查询配送人员送到的买家;
	 */
	public List<BuyerVo> getBuyer( @Param("d")DeliveryIncome d);
}
