package com.netcai.admin.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netcai.admin.constants.GbStatus;
import com.netcai.admin.constants.GroupsStatus;
import com.netcai.admin.dao.BuyerDao;
import com.netcai.admin.dao.GroupsBuyerDao;
import com.netcai.admin.dao.GroupsDao;
import com.netcai.admin.dao.OrderInfoDao;
import com.netcai.admin.entity.Groups;
import com.netcai.admin.entity.GroupsBuyer;
import com.netcai.admin.entity.OrderInfo;
import com.netcai.admin.jdpush.Jdpush;
import com.netcai.admin.service.GroupsBuyerService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;
import com.netcai.sms.gateway.SmsMessageService;
import com.netcai.sms.gatewayImpl.SmsMessageServiceImpl;
import com.netcai.sms.utils.SmsMessage;

import cn.jpush.api.push.PushResult;

/**
 */
@Service
public class GroupsBuyerServiceImpl implements GroupsBuyerService{
	
	private static final Logger logger = LoggerFactory.getLogger(GroupsBuyerServiceImpl.class);
	
	@Value("#{applicationProperties['environment']}")
	private String environment;
	
	@Autowired 
	private GroupsBuyerDao groupsBuyerDao;
	
	@Autowired
	private GroupsDao groupsDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;

	@Autowired
	private BuyerDao buyerDao;
	
	@Override
	public PageUtil getPageResult(GroupsBuyer groupsBuyer, Integer currentPageNum, Integer currentPageSize) {
		int size = groupsBuyerDao.getCount(groupsBuyer);
		int offset = 0;	
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<GroupsBuyer> list = groupsBuyerDao.getList(groupsBuyer,  offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		
		paginator.setObject(list);

		return paginator;
	}

	/**
	 *团购定时器
	 */
	@Override
	public void schedulingGroups() {
		//推送集合
		String failAlert = "您参与的团购未团成,商品金额已退回余额！";
		String successfulAlert = "您参与的团购已团成,感谢您的参与！";
		
		//存放需要推送的userId
		List<String> fails = new ArrayList<String>();
		List<String> successfuls = new ArrayList<String>();
		
		//存放需要取消的订单id和buyerId
		List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();
		
		//改变团购状态
		Map<Long,Groups> groups = new HashMap<Long,Groups>();
		
		//未团成
		List<GroupsBuyer> groupsFail = groupsBuyerDao.getGroupsFail();
		//已团成
		List<GroupsBuyer> groupsSuccessful = groupsBuyerDao.getGroupsSuccessful();
		
		if(!groupsFail.isEmpty()){
			logger.info("[未团成数量GroupsBuyer：]——>["+groupsFail.size()+"]");
			for (int i = 0; i < groupsFail.size(); i++) {
				Groups group = new Groups();
				GroupsBuyer groupsBuyer = groupsFail.get(i);
				Long orderId = groupsBuyer.getOrderId();
				String bossTel = groupsBuyer.getBuyer().getBossTel();
				Long groupId = groupsBuyer.getGroupId();
				Long buyerId = groupsBuyer.getBuyerId();
				if(!groups.containsKey(groupId)){
					group.setId(groupId);
					group.setGbStatus(GbStatus.CANCEL);
					group.setStatus(GroupsStatus.FAIL);
					groups.put(groupId, group);
				}
				OrderInfo orderInfo = new OrderInfo();
				orderInfo.setId(orderId);
				orderInfo.setBuyerId(buyerId);
				orderInfos.add(orderInfo);
				logger.info("[取消的订单Id：]——>["+orderId+"]");
				
				String title = groupsBuyer.getGroups().getTitle();
				fails.add(buyerId.toString());
				
				//发送短信
				SmsMessage smsMessage = new SmsMessage();
				smsMessage.setAccount(bossTel);
				smsMessage.setContent("["+title+"]"+"未团成,商品金额退还到您的余额！");
				SmsMessageService smsService=new SmsMessageServiceImpl();
				
				boolean result = smsService.groupsFinish(smsMessage, environment);
				logger.info("[短信发送][未团成买家联系方式]——>"+bossTel +"[短信发送结果]——>"+result);
			}
		}
		
		if(!groupsSuccessful.isEmpty()){
			logger.info("[已团成数量GroupsBuyer：]——>["+groupsSuccessful.size()+"]");
			for (int i = 0; i < groupsSuccessful.size(); i++) {
				Groups group = new Groups();
				GroupsBuyer groupsBuyer = groupsSuccessful.get(i);
				String bossTel = groupsBuyer.getBuyer().getBossTel();
				Long groupId = groupsBuyer.getGroupId();
				if(!groups.containsKey(groupId)){
					group.setId(groupId);
					group.setStatus(GroupsStatus.SUCCESS);
					groups.put(groupId, group);
				}
				
				Long buyerId = groupsBuyer.getBuyerId();
				String title = groupsBuyer.getGroups().getTitle();
				successfuls.add(buyerId.toString());
				
				//发送短信
				SmsMessage smsMessage = new SmsMessage();
				smsMessage.setAccount(bossTel);
				smsMessage.setContent("["+title+"]"+"已团成,感谢您再次参与!");
				SmsMessageService smsService=new SmsMessageServiceImpl();
				
				boolean result = smsService.groupsFinish(smsMessage, environment);
				logger.info("[短信发送][已团成买家联系方式]——>"+bossTel +"[短信发送结果]——>"+result);
			}
		}
		
		/**
		 * 1.改变团购状态
		 * 2.未团成则改变groupsBuyer为取消状态;
		 */
		List<Groups> list = new ArrayList<Groups>();
		if(!groups.isEmpty()){
			@SuppressWarnings("rawtypes")
			Iterator it = groups.keySet().iterator();
	        while (it.hasNext()) {
	            Long key = (Long) it.next();
	            list.add(groups.get(key));
	            logger.info("[改变的团购groupsId]——>"+key);
	        }
		}
				
		if(!list.isEmpty()){
			int result = groupsDao.updateBatch(list);
			logger.info("[改变的团购状态]——>"+result+"[改变的团购Id]——>"+list);
		}
		
		/**
		 * 更改余额和订单状态
		 */
		if(!orderInfos.isEmpty()){
			for (int i = 0; i < orderInfos.size(); i++) {
				OrderInfo orderInfo = orderInfos.get(i);
				Long buyerId = orderInfo.getBuyerId();
				BuyerVo buyer = buyerDao.getBuyerById(buyerId);
				String buyerName = buyer.getBuyerName();
				//当前余额
				BigDecimal balanceMoney = buyer.getBalanceMoney();
				if(balanceMoney == null){
					balanceMoney = BigDecimal.ZERO;
				}
				Long id = orderInfo.getId();
				OrderInfo orderInfoById = orderInfoDao.getOrderInfoById(id);
				BigDecimal totalAmount = orderInfoById.getTotalAmount();
				BigDecimal addBalanceMoney = balanceMoney.add(totalAmount);
				int cancelResult = orderInfoDao.cancelOrderInfoAndOrderItem(id);
				int updateResult = buyerDao.updateBalanceMoney(buyerId, addBalanceMoney);
				logger.info("[团购订单Id为：]——>"+id+"[订单金额]——>"+totalAmount+"[订单处理结果]——>"+cancelResult
						+"[买家buyerId]——>"+buyerId+"[买家店铺名称]——>"+buyerName
						+"[买家余额由]——>"+balanceMoney+"[变为]——>"+addBalanceMoney+"[余额处理结果]——>"+updateResult);
			}
		}
		
		/**
		 * 推送
		 */
		if(!fails.isEmpty()){
			PushResult result = Jdpush.pushAlias(fails, failAlert);
			if(result != null && result.isResultOK()){
        		logger.info("[未团成推送信息推送成功！]");
        	}else
        	{
        		logger.info("[未团成推送信息推送失败！]");
        	}
			logger.info("[未团成推送buyerId]——>"+fails.toString()+"[推送信息]——>"+failAlert);
		}
		if(!successfuls.isEmpty()){
			PushResult result = Jdpush.pushAlias(successfuls, successfulAlert);
			
			if(result != null && result.isResultOK()){
				logger.info("[已团成推送信息推送成功！]");
	    	}else
	    	{
	    		logger.info("[已团成推送信息推送失败！]");
	    	}
			logger.info("[已团成推送buyerId]——>"+successfuls.toString()+"[推送信息]——>"+successfulAlert);
		}
	}
}
