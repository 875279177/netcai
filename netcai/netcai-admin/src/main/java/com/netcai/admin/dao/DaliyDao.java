package com.netcai.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.SalesDaliy;
import com.netcai.admin.entity.SalesVisit;
import com.netcai.admin.entity.SalesWeekly;

/**
 * 销售日报Dao
 * @author administrator
 */
public interface DaliyDao {
	
	/**
	 * 统计销售日报数量
	 */
	public int getSalesDaliyCount(@Param("saleId")Long saleId,@Param("beginDate")String beginDate,@Param("endDate")String endDate,@Param("lookStatus")Integer lookStatus);

	/**
	 * 销售人员日报列表
	 */
	public List<SalesDaliy> getSalesDaliyList(@Param("saleId")Long saleId,@Param("beginDate")String beginDate,
			@Param("endDate")String endDate,@Param("lookStatus")Integer lookStatus,@Param("offset") int offset,@Param("pageSize") int pageSize);
	
	/**
	 * 统计销售拜访记录
	 */
	public int getSalesVisitCount(@Param("buyerName")String buyerName,@Param("saleId")Long saleId,
			@Param("beginDate")String beginDate,@Param("endDate")String endDate,@Param("svType")Short svType);

	/**
	 * 销售人员拜访记录列表
	 */
	public List<SalesVisit> getSalesVisitList(@Param("buyerName")String buyerName,@Param("saleId")Long saleId,@Param("beginDate")String beginDate,
			@Param("endDate")String endDate,@Param("svType")Short svType,@Param("offset") int offset,@Param("pageSize") int pageSize);
	
	/**
	 * 更新当天销售业绩/线上支付/蔬菜销售
	 */
	public int updateDailyTask();
	
	/**
	 * 更新当天新注册/空降A/维护客户
	 */
	public int updateCustomerTask();
	
	/**
	 * 跟新日拜访量
	 */
	public int updateDayVisitTask();
	
	/**
	 * 统计销售周报数量
	 */
	public int getSalesWeeklyCount(@Param("saleId")Long saleId,@Param("lookStatus")Integer lookStatus);
	
	/**
	 * 销售周报
	 */
	public List<SalesWeekly> getWeeklyList(@Param("saleId")Long saleId,@Param("lookStatus")Integer lookStatus,@Param("offset") int offset,@Param("pageSize") int pageSize);
}
