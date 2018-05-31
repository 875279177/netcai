package com.netcai.admin.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.netcai.admin.service.BillService;
import com.netcai.admin.service.BuyerOrderReportService;
import com.netcai.admin.service.ReportDayService;

/**
 * 统计报表任务;
 */
@Component
public class TaskReport {

	private static final Logger logger=LoggerFactory.getLogger(TaskReport.class);
	
	@Autowired
	private BuyerOrderReportService buyerOrderReportService;
	
	@Autowired
	private ReportDayService reportDayService;
	
	@Autowired
	private BillService billService;
	/**
	 * 计算每天报表;
	 *	每日上午6:00触发
	 */
	@Scheduled(cron="0 0 6 * * ?")
	protected void day(){
		try{
			logger.info("TaskReport.day.start");
			//统计每天订单报表;
			Integer today = 0;//0表示今天	1表示昨天;
			reportDayService.insertBatch(today);
			//统计买家每日订单金额;
			buyerOrderReportService.insertBatch(today);
		}catch(Exception e){
			logger.error("TaskReport.day.exception",e);
		}finally {
			logger.info("TaskReport.day.end");
		}
		
		//纠正金额
		try
		{
			correctAmount();
		}catch(Exception ex)
		{
			logger.error("TaskReport.correctAmount.exception",ex);
		}
	}
	
	/**
	 * 纠正金额
	 */
	public void correctAmount()
	{
		billService.correctAmount();
	}
}