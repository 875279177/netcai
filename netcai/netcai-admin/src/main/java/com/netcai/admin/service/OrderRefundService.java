package com.netcai.admin.service;

import java.util.Date;
import java.util.List;

import com.netcai.admin.entity.RefundCause;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.OrderRefundVo;

public interface OrderRefundService {
	
	/**
	 * 分页查询多退少补订单信息
	 * 
	 * @param orderRefund
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAll(OrderRefundVo orderRefund, int offset, int pageSize);
	
	/**
	 * 新增
	 * 
	 * @param orderRefund
	 * @return
	 */
	public int insert(OrderRefundVo orderRefund);
	
	/**
	 * 根据卖家id查询多退少补信息
	 * @param sellerId
	 * @return
	 */
	public List<OrderRefundVo> selectBySellerId(Long sellerId);
	
	/**
	 * 根据卖家id查询某天的多退少补信息
	 * @param sellerId
	 * @param createTime
	 * @return
	 */
	public List<OrderRefundVo> selectBysellerId(Long sellerId,Date createTime);
	
	/**
	 * 获取所有的多退少补原因
	 * @return
	 */
	public List<RefundCause> getAllReasons();

}
