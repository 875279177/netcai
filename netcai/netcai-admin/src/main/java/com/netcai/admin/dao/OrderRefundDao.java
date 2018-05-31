package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.vo.OrderRefundVo;

public interface OrderRefundDao {

	/**
	 * 分页查询多退少补订单信息
	 * 
	 * @param orderRefund
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<OrderRefundVo> getAll(@Param("orderRefund") OrderRefundVo orderRefund, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @return
	 */
	public int getPageCount(@Param("orderRefund") OrderRefundVo orderRefund);

	/**
	 * 根据map查询
	 * 
	 * @param map
	 * @return
	 */
	public List<OrderRefundVo> selectByMap(Map<String, Object> map);

	/**
	 * 新增
	 * 
	 * @param orderRefund
	 * @return
	 */
	public int insert(OrderRefundVo orderRefund);
	
	/**
	 * 根据卖家id查询某天的多退少补信息
	 * @param sellerId
	 * @param createTime
	 * @return
	 */
	public List<OrderRefundVo> selectBysellerId(@Param("sellerId")Long sellerId,@Param("createTime")Date createTime);
	
	/**
	 * 根据卖家id查询某天的多退少补总金额
	 * @param sellerId
	 * @param time
	 * @return
	 */
	public BigDecimal selectTotalSellerMoney(@Param(value="sellerId")Long sellerId,@Param(value="time")String time);
	
}
