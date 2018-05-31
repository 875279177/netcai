package com.netcai.admin.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.netcai.admin.service.BillService;
import com.netcai.admin.service.BuyerService;
import com.netcai.admin.service.DeliveryIncomeService;
import com.netcai.admin.service.GroupsBuyerService;
import com.netcai.admin.service.OrderInfoService;
import com.netcai.admin.service.SellerService;

/**
 * 任务工作
 * @author administrator
 */
@Component
public class TasksQuartz{
	
	private static final Logger logger=LoggerFactory.getLogger(TasksQuartz.class);
	
	@Autowired
	private BillService billService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private DeliveryIncomeService deliveryIncomeService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private GroupsBuyerService groupsBuyerService;
	
	/**
	 * 计算每天账单
	 * 每天23点执行
	 */
	@Scheduled(cron="0 0 23 * * ?")
	protected void makeBill(){
		try
		{
			logger.info("TasksQuartz.execute.start");
			//统计当天的交易完成的订单生成账单
			billService.addBills();
			logger.info("账单数据更新完成");
			//根据卖家抽点金额更新账单实际金额
			billService.updateRealAmountByPercentage();
			logger.info("根据卖家抽点金额更新账单实际金额完成");
			//更新卖家余额
			sellerService.updateBalanceByBill();
			logger.info("卖家余额数据更新完成");
			logger.info("TasksQuartz.execute.end");
		}catch(Exception ex)
		{
			logger.error("TasksQuartz.execute.exception",ex);
		}
	}
	
	/**
	 * 核对卖家余额
	 * 每天早上3点执行
	 */
	@Scheduled(cron="0 0 3 * * ?")
	protected void checkedSellerBalance(){
		try
		{
			logger.info("TasksQuartz.execute.checkedSellerBalance.start");
			//核对卖家余额是否异常并记录日志
			sellerService.verifySellerBalance();
			logger.info("TasksQuartz.execute.checkedSellerBalance.end");
		}catch(Exception ex)
		{
			logger.error("TasksQuartz.execute.exception",ex);
		}
	}
	
	/**
	 * 统计配送人员收入并新增数据到配送人员收入表中
	 * 每天晚上九点执行
	 */
	@Scheduled(cron="0 0 21 * * ?")
	protected void calculatedDeliveryIncome () {
		logger.info("TasksQuartz.execute.calculatedDeliveryIncome.start");
		//计算出配送人员的收入并新增数据
		deliveryIncomeService.calculatedDeliveryIncome();
		logger.info("TasksQuartz.execute.calculatedDeliveryIncome.end");
	}
	
	/**
	 * 更新买家类别
	 * 早上7点执行执行
	 */
	@Scheduled(cron="0 0 7 * * ?")
	protected void updateBuyerLevel () {
		logger.info("TasksQuartz.execute.updateBuyerLevel.start");
		//更新买家类别为5 前5天下5单
		buyerService.updateBuyerLevel(5);
		//更新买家类别为4 前5天下4单
		buyerService.updateBuyerLevel(4);
		//更新买家类别为3 前5天下3单
		buyerService.updateBuyerLevel(3);
		//更新买家类别为2 前5天下2单
		buyerService.updateBuyerLevel(2);
		//更新买家类别为1 前5天下1单
		buyerService.updateBuyerLevel(1);
		//更新买家类别为0 5天未下单
		buyerService.updateBuyerLevel0();
		logger.info("TasksQuartz.execute.updateBuyerLevel.end");
	}
	
	/**
	 * 买家 线下收款计量
	 * 每天早上6点执行
	 */
	@Scheduled(cron="0 0 7 * * ?")
	protected void insertBuyerReceipt(){
		try
		{
			logger.info("TasksQuartz.execute.insertBuyerReceipt.start");
			orderInfoService.insertBuyerReceipt();
			logger.info("TasksQuartz.execute.insertBuyerReceipt.end");
		}catch(Exception ex)
		{
			logger.error("TasksQuartz.execute.exception",ex);
		}
	}
	
	/**
	 * 更新当天销售业绩/线上支付/蔬菜销售
	 * 更新当天新注册/空降A/维护客户/更新日拜访量
	 */
	@Scheduled(cron="0 30 8 * * ?")
	protected void updateDailyTask(){
		try
		{
			logger.info("TasksQuartz.execute.updateDailyTask.start");
			//更新当天销售业绩/线上支付/蔬菜销售
			//daliyService.updateDailyTask();
			//更新当天新注册/空降A/维护客户
			//daliyService.updateCustomerTask();
			//更新日拜访量
			//daliyService.updateDayVisitTask();
			logger.info("TasksQuartz.execute.updateDailyTask.end");
		}catch(Exception ex)
		{
			logger.error("TasksQuartz.execute.exception",ex);
		}
	}
	
	/**
	 * 定时调度团购结束时执行
	 */
	@Scheduled(cron="0 0/5 *  * * ? ")   //每5分钟执行一次
    public void finishGroupTask(){
		try
		{
		  logger.info("TasksQuartz.execute.finishGroupTask.start");
		  groupsBuyerService.schedulingGroups();
          logger.info("TasksQuartz.execute.finishGroupTask.end");
		}catch(Exception ex)
		{
			logger.error("TasksQuartz.execute.exception",ex);
		}
    }    
}