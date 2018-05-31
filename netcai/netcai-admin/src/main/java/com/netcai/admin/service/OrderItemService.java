package com.netcai.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.netcai.admin.entity.OrderItem;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.OrderItemQuery;
import com.netcai.admin.vo.OrderItemVo;
import com.netcai.admin.vo.PresentOrderDetailVo;
import com.netcai.admin.vo.SellerOrderVo;
import com.netcai.admin.vo.SellerTransactionDetail;

/**
 * 订单明细service
 * @author Administrator
 *
 */
public interface OrderItemService {
	
	/**
	 * 通过Id查询单个
	 */
	public OrderItem getOrderItemById(Long id);
	
	/**
	 * 添加
	 */
	public int insertOrderItem(OrderItem orderItem);

	/**
	 * 通过条件查询 不分页
	 */
	public List<OrderItem> getResult(OrderItem orderItem);
	
	/**
	 * 通过条件查询 分页
	 */
	public PageUtil getPageResult(OrderItem orderItem, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 通过条件查询 不分页
	 */
	public List<OrderItem> getResult(OrderItem orderItem ,Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 查询缺货和退货的流程未走完的子订单
	 */
	public PageUtil getRedressOrderItems(OrderItem orderItem,Integer statusCode,int currentPageNum,int currentPageSize);
	
	/**
	 * 查询一周内收入前十的卖家  
	 */
	public List<Map<String, Object>> getTonTenIncomes();
	
	/**
	 * 查询一周内收入前十的卖家  
	 */
	public List<Map<String, Object>> getTopTenGoods();
	
	/**
	 * 根据卖家id查询他的所有订单
	 */
	public List<OrderItemVo> getOrderItemBySellerId(OrderItem orderItem);
	
	/**
	 * 修改完成备货状态
	 */
	public void updateOrderItemNumber(Long orderId,Long itemId,Double goodsNumber);
	
	/**
	 * 修改完成备货状态 错误;
	 */
	public void updateOrderItemNumberError(Long orderId,Long itemId,Double goodsNumber);
	
	/**
	 * 查询所有  最终版  分页
	 */
	public PageUtil getPageList(OrderItemQuery orderItemQuery, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 查询所有  最终版  分页
	 */
	public List<OrderItemQuery> getList(OrderItemQuery orderItemQuery, Integer currentPageNum, Integer currentPageSize);
	
	/**
	 * 查询所有  最终版  分页
	 */
	public List<OrderItemQuery> getList(OrderItemQuery orderItemQuery);
	
	/**
	 *  卖家当天订单总额;
	 */
	public ArrayList<SellerOrderVo> getAmountBySellerByDate(SellerOrderVo sellerOrderVo);
	
	/**
	 * 根据卖家id查询卖家今日收益详情结果集
	 */
	public List<SellerTransactionDetail> selectSellerTransactionDetails(Long sellerId,String time);
	
	/**
	 * 根据卖家id查询卖家今日营业金额、抽点金额、及多退少补金额
	 */
	public Map<String, Object> selectSellerTransactionAmount(Long sellerId,String time);
	
	/**
	 * 根据卖家id和订单id查询订单明细
	 */
	public List<PresentOrderDetailVo> selectPresentOrderDetails(Long orderId,Long sellerId);
	/**
	 * 删除订单
	 */
	public void deleteOrderItemById(Long buyerId, Long itemId);
	
	/**
	 * 子订单确认退货
	 */
	public int returnOrderItem(Long itemId);
	
	/**
	 * 根据主订单id查询缺货和退货订单
	 */
	public List<OrderItem> getImproperOrderItems(Long orderId);
	
}
