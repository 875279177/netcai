package com.netcai.admin.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderInfo;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.OrderTaskVo;
import com.netcai.admin.vo.PresentOrderVo;

public interface OrderInfoService {

	/**
	 * 通过Id查询单个
	 */
	public OrderInfo getOrderInfoById(Long id);

	/**
	 * 添加
	 */
	public int insertOrderInfo(OrderInfo orderInfo);

	/**
	 * 通过条件查询
	 */
	public PageUtil getPageResult(OrderInfo orderInfo, int currentPageNum, int currentPageSize);

	/**
	 * 通过条件查询
	 */
	public List<OrderInfo> getResult(OrderInfo orderInfo, Integer currentPageNum, Integer currentPageSize);

	/**
	 * 根据区域统计所有的订单数量和消费金额
	 */
	public Map<String, Object> getCountAndAmount();

	/**
	 * 统计今日的订单数量和总金额
	 */
	public Map<String, Object> getOrderCountAndAmountByToday();

	/**
	 * 查询当天的订单详情
	 */
	public List<OrderInfo> getOrderInfoByDate(OrderInfo orderInfo);

	/**
	 * 查询统计订单的详细信息每个买家只显示一个
	 */
	public List<OrderInfo> getOrderInfoByDateByBuyer(OrderInfo orderInfo);

	/**
	 * 查询今日下单买家数量
	 */
	public int getBuyerCountByTodayOrder();

	/**
	 * 查询所有买家当天购买买家总数 不分区域;
	 */
	public int getBuyerNumByThatDay();

	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的订单数量根据区域分组
	 */
	public Map<String, List<Integer>> getCountByTimeType(Integer timeType);

	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的订单金额根据区域分组
	 */
	public Map<String, List<BigDecimal>> getAmountByTimeType(Integer timeType);

	/**
	 * 查询一周内消费前十的买家
	 */
	public List<Map<String, Object>> getTopTenAmount();

	/**
	 * 批量修改订单状态
	 */
	public int batchUpdateStatus(List<Long> ids, Integer tradeStatus);

	/**
	 * 修改最佳送货时间
	 */
	public int updateBestTime(Long id, Date bestTime);

	/**
	 * 查询当天送货订单
	 */
	public ArrayList<OrderTaskVo> getByThatDay();

	/**
	 * 根据卖家id和时间（年月日）查询订单
	 */
	public List<PresentOrderVo> getOrdersBySellerIdAndDate(@Param(value = "sellerId") Long sellerId,
			@Param(value = "time") String time);

	/**
	 * 删除单个订单,则把所有对应的订单项都取消
	 */
	public void deleteOrderInfo(Long buyerId, Long orderId);

	/**
	 * 查询今天业绩中午12点到晚上24点
	 */
	public List<OrderInfo> getRealTimeRevenue(OrderInfo o);

	/**
	 * 查询今天业绩中午12点到晚上24点 总计
	 */
	public Map<String, Object> getRealTimeRevenueCount();

	/**
	 * 添加线下收款数据
	 */
	public int insertBuyerReceipt();
}
