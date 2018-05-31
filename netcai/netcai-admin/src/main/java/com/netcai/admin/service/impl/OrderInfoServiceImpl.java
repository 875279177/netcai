package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.ChartTitleEnum;
import com.netcai.admin.constants.PayStatus;
import com.netcai.admin.dao.AreaDao;
import com.netcai.admin.dao.BuyerDao;
import com.netcai.admin.dao.MessageDao;
import com.netcai.admin.dao.OrderCancelLogsDao;
import com.netcai.admin.dao.OrderInfoDao;
import com.netcai.admin.dao.OrderItemDao;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Message;
import com.netcai.admin.entity.OrderCancelLogs;
import com.netcai.admin.entity.OrderInfo;
import com.netcai.admin.service.OrderInfoService;
import com.netcai.admin.utils.ArrayListUtil;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;
import com.netcai.admin.vo.OrderTaskVo;
import com.netcai.admin.vo.PresentOrderVo;

/**
 * @author administrator
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {

	// 订单退款通知
	private static final String MESSAGE = "订单退款通知";

	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private OrderItemDao orderItemDao;

	@Autowired
	private BuyerDao buyerDao;

	@Autowired
	private MessageDao messageDao;

	@Autowired
	private OrderCancelLogsDao orderCancelLogsDao;

	@Autowired
	private AreaDao areaDao;

	/**
	 * 通过Id查询单个
	 */
	@Override
	public OrderInfo getOrderInfoById(Long id) {
		return orderInfoDao.getOrderInfoById(id);
	}

	/**
	 * 通过条件查询
	 */
	@Override
	public PageUtil getPageResult(OrderInfo orderInfo, int currentPageNum, int currentPageSize) {

		int size = orderInfoDao.getPageCount(orderInfo);

		int offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if (size < offset) {
			offset = 0;
		}

		List<OrderInfo> result = orderInfoDao.getOrderInfo(orderInfo, offset, currentPageSize);

		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public int insertOrderInfo(OrderInfo orderInfo) {

		orderInfo.setCreateTime(new Date());

		return orderInfoDao.insertOrderInfo(orderInfo);

	}

	/**
	 * 统计所有的订单数量和消费金额
	 * 
	 */
	@Override
	public Map<String, Object> getCountAndAmount() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", null);
		return orderInfoDao.getCountAndAmountByMap(map);
	}

	/**
	 * 统计今日的订单数量和消费金额
	 * 
	 */
	@Override
	public Map<String, Object> getOrderCountAndAmountByToday() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("time", new Date());
		return orderInfoDao.getCountAndAmountByMap(map);
	}

	/**
	 * 查询当日的订单详情
	 */
	@Override
	public List<OrderInfo> getOrderInfoByDate(OrderInfo orderInfo) {
		Map<String, Object> map = DateUtil.getTradeTime(0);
		return orderInfoDao.getOrderInfoByDate(map, orderInfo);
	}

	/**
	 * 查询统计订单的详细信息每个买家只显示一个
	 */
	@Override
	public List<OrderInfo> getOrderInfoByDateByBuyer(OrderInfo orderInfo) {
		Map<String, Object> map = DateUtil.getTradeTime(0);
		return orderInfoDao.getOrderInfoByDateByBuyer(map, orderInfo);
	}

	/**
	 * 根据时间类型（按天或者按月）统计一个周期内的订单数量根据区域分组
	 * 
	 * @return
	 */
	@Override
	public Map<String, List<Integer>> getCountByTimeType(Integer timeType) {
		if (timeType == null) {
			// 默认是时间类型是按天查询
			timeType = DateUtil.DATE_TYPE_DAY;
		}
		Map<String, List<Integer>> result = new LinkedHashMap<String, List<Integer>>();
		Map<String, Object> map = null;
		List<Integer> totalCount = new ArrayList<Integer>();
		// 根据时间统计全部区域的订单数量
		for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
			// 获取n天前的订单查询时间
			if (DateUtil.DATE_TYPE_DAY == timeType) {
				map = DateUtil.getTradeTime(i);
			} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
				map = DateUtil.getMonthTime(i, DateUtil.TRADE_TIME_TYPE);
			}
			// 根据时间查询全部区域的订单数量
			int totalNum = orderInfoDao.getTotalCountByMap(map);
			// 将订单数量结果添加到集合
			totalCount.add(totalNum);
		}
		result.put(ChartTitleEnum.OrderTotalCount.getName(), totalCount);
		
		// 查询所有区域
		List<Area> areas = areaDao.getRegions();
		if (CollectionUtils.isEmpty(areas)) {
			return result;
		}
		// 遍历所有区
		for (Area area : areas) {
			if (area == null || area.getId() == null) {
				continue;
			}
			Long regionId = area.getId();
			String regionName = area.getAreaName();
			List<Integer> counts = new ArrayList<Integer>();
			for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
				// 获取n天前的订单查询时间
				if (DateUtil.DATE_TYPE_DAY == timeType) {
					map = DateUtil.getTradeTime(i);
				} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
					map = DateUtil.getMonthTime(i, DateUtil.TRADE_TIME_TYPE);
				}
				map.put("regionId", regionId);
				// 根据区域和时间查询订单数量
				int orderNum = orderInfoDao.getTotalCountByMap(map);
				// 将订单数量结果添加到集合
				counts.add(orderNum);
			}
			if (StringUtils.isNotBlank(regionName)) {
				regionName += ChartTitleEnum.OrderCount.getName();
			}
			result.put(regionName, counts);
		}
		return result;
	}

	/**
	 * 根据时间类型（按天或者按月）统计一个周期内各个区域的订单金额
	 * 
	 * @return
	 */
	@Override
	public Map<String, List<BigDecimal>> getAmountByTimeType(Integer timeType) {
		if (timeType == null) {
			// 默认是时间类型是按天查询
			timeType = DateUtil.DATE_TYPE_DAY;
		}
		Map<String, List<BigDecimal>> result = new LinkedHashMap<String, List<BigDecimal>>();
		Map<String, Object> map = null;
		// 根据时间统计所有区域的总金额
		List<BigDecimal> totalAmounts = new ArrayList<BigDecimal>();
		for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
			// 获取n天前的订单查询时间
			if (DateUtil.DATE_TYPE_DAY == timeType) {
				map = DateUtil.getTradeTime(i);
			} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
				map = DateUtil.getMonthTime(i, DateUtil.TRADE_TIME_TYPE);
			}
			// 根据时间查询全部区域的总金额
			BigDecimal totalAmount = orderInfoDao.getTotalAmountByMap(map);
			if (totalAmount == null) {
				totalAmount = BigDecimal.ZERO;
			}
			// 将订单金额结果添加到集合
			totalAmounts.add(totalAmount);
		}
		result.put(ChartTitleEnum.OrderTotalAmount.getName(), totalAmounts);
		// 查询所有区域
		List<Area> areas = areaDao.getRegions();
		if (CollectionUtils.isEmpty(areas)) {
			return result;
		}
		// 遍历所有区
		for (Area area : areas) {
			if (area == null || area.getId() == null) {
				continue;
			}
			Long regionId = area.getId();
			String regionName = area.getAreaName();
			List<BigDecimal> counts = new ArrayList<BigDecimal>();
			// 获取最近7天或者7个月的每个区域订单金额
			for (int i = DateUtil.WEEKCOUNT - 1; i >= 0; i--) {
				if (DateUtil.DATE_TYPE_DAY == timeType) {
					map = DateUtil.getTradeTime(i);
				} else if (DateUtil.DATE_TYPE_MONTH == timeType) {
					map = DateUtil.getMonthTime(i, DateUtil.TRADE_TIME_TYPE);
				}
				map.put("regionId", regionId);
				// 根据区域和时间查询订单金额
				BigDecimal orderAmount = orderInfoDao.getTotalAmountByMap(map);
				if (orderAmount == null) {
					orderAmount = BigDecimal.ZERO;
				}
				// 将订单金额结果添加到集合
				counts.add(orderAmount);
			}
			if (StringUtils.isNotBlank(regionName)) {
				regionName += ChartTitleEnum.OrderAmount.getName();
			}
			result.put(regionName, counts);
		}
		return result;
	}

	/**
	 * 查询一周内消费前十的买家
	 * 
	 */
	@Override
	public List<Map<String, Object>> getTopTenAmount() {
		List<Map<String, Object>> list = orderInfoDao.getTopTenAmount();
		// 将查询的数据按照指定的顺序存取
		return ArrayListUtil.getArrayListByArray(list, ArrayListUtil.TOPTEN_AMOUNT);

	}

	@Override
	public int batchUpdateStatus(List<Long> ids, Integer tradeStatus) {
		int orderStatus = 1;
		if (tradeStatus == 2) {
			orderStatus = 2;
		}
		orderItemDao.batchUpdateStatus(ids, orderStatus);
		return orderInfoDao.batchUpdateStatus(ids, tradeStatus);
	}

	@Override
	public int updateBestTime(Long id, Date bestTime) {
		return orderInfoDao.updateBestTime(id, bestTime);
	}

	@Override
	public List<OrderInfo> getResult(OrderInfo orderInfo, Integer currentPageNum, Integer currentPageSize) {
		return orderInfoDao.getOrderInfo(orderInfo, currentPageNum, currentPageSize);
	}

	@Override
	public ArrayList<OrderTaskVo> getByThatDay() {
		return orderInfoDao.getByThatDay();
	}
	
	/**
	 * 查询今日下单买家数量
	 */
	@Override
	public int getBuyerCountByTodayOrder() {
		return orderInfoDao.getBuyerCountByTodayOrder();
	}

	/**
	 * 根据卖家id和日期查询订单
	 */
	@Override
	public List<PresentOrderVo> getOrdersBySellerIdAndDate(Long sellerId, String time) {
		return orderInfoDao.getOrdersBySellerIdAndDate(sellerId, time);
	}

	@Override
	public int getBuyerNumByThatDay() {
		return orderInfoDao.getBuyerNumByThatDay();
	}

	@Override
	public void deleteOrderInfo(Long buyerId, Long orderId) {
		// TODO Auto-generated method stub
		// 1.取消所有的订单项。
		// 2.把订单的金额退还给买家的余额
		// 3.记录日志
		// 4.发送消息给买家的消息列表中
		orderItemDao.cancelAllOrderItem(orderId);

		orderInfoDao.cancelAllOrderInfo(orderId);

		OrderInfo orderInfo = this.orderInfoDao.getOrderInfoById(orderId);

		// 买家对象
		BuyerVo buyer = buyerDao.getBuyerById(buyerId);

		// 总金额
		BigDecimal totalAmount = orderInfo.getTotalAmount();
		
		BigDecimal balanceMoney = buyer.getBalanceMoney();
		
		if(balanceMoney == null){
			balanceMoney = BigDecimal.ZERO;
		}
		// 最终金额
		BigDecimal finalBalanceMoney = totalAmount.add(balanceMoney);

		// 线下付款
		if (orderInfo.getPayStatus() == PayStatus.PAY_SUCCESS) {

			// 更新金额
			buyerDao.updateBuyerBalance(buyerId, finalBalanceMoney);

			// 发送消息
			List<Message> listMessage = new ArrayList<Message>();

			String content = "订单被你取消，退还到你的账号余额:" + totalAmount + "你的最终余额为：" + finalBalanceMoney;

			Message msg = new Message();
			msg.setMsgName(MESSAGE);
			msg.setUserId(buyerId);
			msg.setMsgContent(content);
			msg.setMsgType(1);
			msg.setStatus(1);
			msg.setCreateTime(new Date());
			listMessage.add(msg);
			this.messageDao.saveBatch(listMessage);

		}

		// 记录日志
		OrderCancelLogs orderCancelLogs = new OrderCancelLogs();

		orderCancelLogs.setBuyerId(buyerId);
		orderCancelLogs.setCreateTime(new Date());
		orderCancelLogs.setOrderSn(orderId);
		orderCancelLogs.setTradeMoney(totalAmount);
		orderCancelLogs.setCurrentMoney(balanceMoney);
		orderCancelLogs.setLastMoney(finalBalanceMoney);
		orderCancelLogs.setRemarks("整个订单取消");
		orderCancelLogsDao.addOrderCancelLogs(orderCancelLogs);

	}

	@Override
	public List<OrderInfo> getRealTimeRevenue(OrderInfo o) {
		return orderInfoDao.getRealTimeRevenue(o);
	}

	@Override
	public Map<String, Object> getRealTimeRevenueCount() {
		return orderInfoDao.getRealTimeRevenueCount();
	}

	/**
	 * 添加线下收款数据
	 */
	public int insertBuyerReceipt() {
		return orderInfoDao.insertBuyerReceipt();
	}
}