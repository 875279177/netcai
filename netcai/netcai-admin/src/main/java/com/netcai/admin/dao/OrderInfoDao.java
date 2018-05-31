package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.BuyerOrderReport;
import com.netcai.admin.entity.OrderInfo;
import com.netcai.admin.entity.ReportDay;
import com.netcai.admin.vo.OrderTaskVo;
import com.netcai.admin.vo.PresentOrderVo;

/**
 * @author administrator
 */
public interface OrderInfoDao {

	/**
	 * 通过Id查询单个
	 */
	public OrderInfo getOrderInfoById(Long id);
	
	/**
	 * 通过条件查询 
	 */
	public List<OrderInfo> getOrderInfo( @Param("o")OrderInfo o  ,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("o")OrderInfo o);
	
	/**
	 * 添加
	 */
	public int insertOrderInfo(OrderInfo orderInfo);
	
	/**
	 * 统计订单数量和总金额
	 */
	public Map<String, Object> getCountAndAmountByMap(Map<String, Object> map);
	
	/**
	 * 根据时间和区域统计订单数量
	 */
	public int getTotalCountByMap(Map<String, Object> map);
	
	/**
	 * 根据时间和区域统计订单总金额
	 */
	public BigDecimal getTotalAmountByMap(Map<String, Object> map);
	
	/**
	 * 查询当天的订单详情
	 */
	public List<OrderInfo> getOrderInfoByDate(@Param("map")Map<String,Object> map,@Param("o")OrderInfo o);
	
	/**
	 * 查询统计订单的详细信息每个买家只显示一个
	 */
	public List<OrderInfo> getOrderInfoByDateByBuyer(@Param("map")Map<String,Object> map,@Param("o")OrderInfo o);
	
	/**
	 * 查询今日下单买家数量
	 */
	public int getBuyerCountByTodayOrder();
	
	/**
	 * 查询一周内消费前十的买家 
	 */
	public List<Map<String, Object>> getTopTenAmount();
	
	/**
	 * 批量修改订单状态
	 */
	public int batchUpdateStatus(@Param("ids")List<Long> ids,@Param("tradeStatus")Integer tradeStatus);
	
	/**
	 * 修改最佳送货时间
	 */
	public int updateBestTime(@Param("id")Long id,@Param("bestTime")Date bestTime);
	
	/**
	 * 修改商品数量;
	 */
	public Integer updateGoodsNumber(@Param("totalAmount")BigDecimal totalAmount,@Param("orderId")Long orderId);
	
	/**
	 * 查询当天送货的所有订单
	 */
	public ArrayList<OrderTaskVo> getByThatDay();
	
	/**
	 * 查询所有买家所产生订单信息;
	 */
	public ArrayList<BuyerOrderReport> getByThatDayByBuyer(@Param("map")Map<String,Object> map);
	
	/**
	 * 查询所有买家当天购买买家总数;
	 */
	public ArrayList<ReportDay> getBuyerNumByThatDayByArea(@Param("map")Map<String,Object> map);
	
	/**
	 * 查询所有买家当天购买买家总数 不分区域;
	 */
	public int getBuyerNumByThatDay();
	
	/**
	 * 订单总金额;
	 */
	public ArrayList<ReportDay> getOrderAmountByThatDayByArea(@Param("map")Map<String,Object> map);
	
	/**
	 * 查询昨天注册，今天下单的买家数量;分区域;
	 */
	public ArrayList<ReportDay> getCountByThatDayByArea(@Param("map")Map<String,Object> map);
	
	/**
	 * 根据卖家id查询今日订单
	 * @param sellerId
	 * @return
	 */
	public List<PresentOrderVo> getOrdersBySellerIdAndDate(@Param(value="sellerId")Long sellerId,@Param(value="time")String time);

	/**
	 * 更新订单的总金额
	 * @param orderId
	 */
	public void updateOrderInfoTotalAmount(@Param("orderId") Long orderId,@Param("totalAmount") BigDecimal totalAmount);

	/**
	 * 取消单个订单,则把所有对应的订单项都取消
	 */
	public void cancelAllOrderInfo(@Param("orderId") Long orderId);
	
	/**
	 * 查询今天业绩中午12点到晚上24点 
	 */
	public List<OrderInfo> getRealTimeRevenue(@Param("o")OrderInfo o);
	
	/**
	 * 查询今天业绩中午12点到晚上24点总计
	 */
	public Map<String, Object> getRealTimeRevenueCount();
	
	/**
	 * 添加线下收款数据
	 */
	public int insertBuyerReceipt();
	
	/**
	 * 取消团购订单
	 */
	public int cancelOrderInfoAndOrderItem(Long orderId);
}