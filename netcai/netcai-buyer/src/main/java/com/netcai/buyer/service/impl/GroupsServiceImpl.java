package com.netcai.buyer.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.constants.BuyerStatus;
import com.netcai.buyer.constants.OrderStatus;
import com.netcai.buyer.constants.PayStatus;
import com.netcai.buyer.constants.SellerStatus;
import com.netcai.buyer.constants.TradeStatus;
import com.netcai.buyer.dao.GroupsDao;
import com.netcai.buyer.dao.OrderInfoDao;
import com.netcai.buyer.dao.OrderItemDao;
import com.netcai.buyer.entity.GroupBuyer;
import com.netcai.buyer.entity.GroupOrder;
import com.netcai.buyer.entity.GroupOrderItem;
import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.entity.OrderItem;
import com.netcai.buyer.service.GroupsService;
import com.netcai.buyer.utils.DateUtil;
import com.netcai.buyer.utils.OrderIDGenerator;
import com.netcai.buyer.vo.GroupsVo;
/**
 * 团购serviceimpl
 * @author administrator
 */
@Service
public class GroupsServiceImpl implements GroupsService{

	@Autowired
	private GroupsDao groupsDao;
	@Autowired
	private OrderInfoDao orderInfoDao;
	@Autowired
	private OrderItemDao orderItemDao;
	
	/**
	 * 团购清单
	 */
	public List<GroupsVo> getGroupsList(Long regionId){
		return groupsDao.getGroupsList(regionId);
	}
	
	/**
	 * 团购详情
	 */
	public GroupsVo getGroupsInfo(Long groupId){
		return groupsDao.getGroupsInfo(groupId);
	}
	
    /**
     * 创建团购订单
     */
	public OrderInfo addOrderInfo(GroupOrder groupOrder){
		Date bestTime = DateUtil.stringToDate(groupOrder.getBestTime(), DateUtil.FMT_YMD_HM);
		Long buyerId = groupOrder.getBuyerId();
		OrderInfo orderInfo = new OrderInfo();
		String orderNumber = OrderIDGenerator.getTgOrderNumber();
		orderInfo.setOrderType((short)1);
		orderInfo.setBestTime(bestTime);
		orderInfo.setOrderNumber(orderNumber);
		orderInfo.setTradeStatus(TradeStatus.TRADE_PROGRESS);
		orderInfo.setPayStatus(PayStatus.PAY_NO);
		orderInfo.setCreateTime(new Date());
		orderInfo.setBuyerId(buyerId);
		
		//订单总金额：
		BigDecimal totalAmount = BigDecimal.ZERO;
        List<GroupOrderItem>  itemList = groupOrder.getItemList();
        //订单明细记录集合
        List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		//统计总金额 设置订单项状态属性;
		for (int i = 0; i < itemList.size(); i++) {
			GroupOrderItem groupOrderItem = itemList.get(i);
			//创建订单明细
			OrderItem orderItem = new OrderItem();
			Long formatId = groupOrderItem.getFormatId();
			BigDecimal groupPrice = groupOrderItem.getGroupPrice();
			BigDecimal groupNum = groupOrderItem.getGroupNum();
			BigDecimal goodsAmount = groupPrice.multiply(groupNum);
            
			orderItem.setItemId(groupOrderItem.getItemId());
			orderItem.setGoodsNumberOld(groupNum);
			orderItem.setGoodsNumber(groupNum);
			orderItem.setBuyerId(buyerId);
			orderItem.setSellerId(groupOrderItem.getSellerId());
			orderItem.setFormatId(formatId);
			orderItem.setSellerStatus(SellerStatus.SELLER_PLAN);
			orderItem.setOrderStatus(OrderStatus.ORDER_SUBMIT);
			orderItem.setBuyerStatus(BuyerStatus.BUYER_WAIT_TAKE);
			orderItem.setCreateTime(new Date());

			//设置商品项总金额;
			orderItem.setGoodsAmount(goodsAmount);
			//设置商品单价;
			orderItem.setGoodsPrice(groupPrice);
			totalAmount = goodsAmount.add(totalAmount);
			orderItemList.add(orderItem);
		}
		//设置订单最终总额;
		orderInfo.setTotalAmount(totalAmount);
		//设置订单计算总额;
		orderInfo.setOrderAmount(totalAmount);
		//增加主表
		orderInfoDao.addOrderInfo(orderInfo);
		orderInfo.setOrderItem(orderItemList);
		//创建订单明细表
		orderItemDao.insertOrderItem(orderInfo);
		//创建买家团购记录表
		List<GroupBuyer> gbList = new ArrayList<GroupBuyer>();
		for (int i = 0; i < orderItemList.size(); i++) {
			OrderItem orderItem = orderItemList.get(i);
			GroupBuyer groupBuyer = new GroupBuyer();
			groupBuyer.setBuyerId(buyerId);
			groupBuyer.setGroupId(groupOrder.getGroupId());
			groupBuyer.setOrderId(orderInfo.getOrderId());
			groupBuyer.setItemId(orderItem.getItemId());
			groupBuyer.setGbNum(orderItem.getGoodsNumber());
			groupBuyer.setGbPrice(orderItem.getGoodsPrice());
			groupBuyer.setGbAmt(orderItem.getGoodsAmount());
			gbList.add(groupBuyer);
		}
		groupsDao.batchInsertGroupBuyer(gbList);
		//返回订单总表信息;
		orderInfo.setOrderItem(null);
		return orderInfo;
	}
	
	/**
	 * 根据订单ID修改买家团购成功标识
	 */
	public int updateGbStatusByOrderId(Long orderId){
		return groupsDao.updateGbStatusByOrderId(orderId);
	}
	
	/**
	 * 根据订单号修改买家团购成功标识
	 */
	public int updateGbStatusByOrderNumber(String orderNumber){
		return groupsDao.updateGbStatusByOrderNumber(orderNumber);
	}
}
