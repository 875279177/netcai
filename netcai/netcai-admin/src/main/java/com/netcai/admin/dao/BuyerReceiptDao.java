package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerReceipt;

public interface BuyerReceiptDao {

	/**
	 * 查询所有 不分页
	 */
	public List<BuyerReceipt> selectList(@Param("b")BuyerReceipt buyerReceipt,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	/**
	 * 总数
	 */
	public int getPageCount(@Param("b")BuyerReceipt buyerReceipt);
	/**
	 * 更新	核实状态
	 */
	public int updateHSStatus(@Param("status")Integer status,@Param("id")Integer id);
	/**
	 * 更新	收款状态
	 */
	public int updateRZStatus(@Param("status")Integer status,@Param("id")Integer id);
	/**
	 * 更新	实收金额
	 */
	public int updateSSAmt(@Param("ssAmt")BigDecimal ssAmt,@Param("id")Integer id);
	/**
	 * 更新	收款状态
	 */
	public int updateSKReamk(@Param("skReamk")String skReamk,@Param("id")Integer id);
	/**
	 * 批量	核实状态
	 */
	public int batchUpdateHSStatus(@Param("ids")List<Long> ids,@Param("hSStatus")Integer hSStatus);
	/**
	 * 批量	收款状态
	 */
	public int batchUpdateRZStatus(@Param("ids")List<Long> ids,@Param("rZStatus")Integer rZStatus);
}
