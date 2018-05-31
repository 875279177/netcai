package com.netcai.admin.controller.finance;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.FinancialStatistics;
import com.netcai.admin.entity.TodayStatistics;
import com.netcai.admin.service.FinancialStatisticsService;
import com.netcai.admin.service.TodayStatisticsService;
import com.netcai.admin.utils.ExportExcelUtil;

/**
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class StatisticsController extends BaseController {
	

	private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
	
	@Autowired
	private FinancialStatisticsService financialStatisticsService;
	
	@Autowired
	private TodayStatisticsService todayStatisticsService;

	/**
	 * 总财务统计
	 * 信息列表
	 */
	@RequestMapping(value = "/statistics/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("statistics:query")
	public String statisticsList(HttpServletRequest request, HttpServletResponse response,FinancialStatistics financialStatistics,Model model) 
	{
		try{
			
		List<FinancialStatistics> list = financialStatisticsService.getList(financialStatistics);

		model.addAttribute("lists", list);
		
		model.addAttribute("statistics",financialStatistics);
		
		}catch(Exception e){
			logger.error("[StatisticsController][list]:", e);
            return "500";
		}
		return "finance/statisticsList";
	}
	
	
	/**
	 *总财务统计
	 */
	@RequestMapping(value = "/statistics/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportStatistics(HttpServletRequest request, HttpServletResponse response,FinancialStatistics financialStatistics) {
		//查询需要导出的数据
		List<FinancialStatistics> list = financialStatisticsService.getList(financialStatistics);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"时间","所属区","注册用户","月活跃用户","下订单频率"};  
		Object[] objs = null; 
		if(null !=list && list.size()>0){
			for(FinancialStatistics gd :list){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getTime();
			    objs[1] = gd.getNames();
			    objs[2] = gd.getNewUser();
			    objs[3] = gd.getActiveUser();
			    Double hz = (double) 0;
			    DecimalFormat df = new DecimalFormat("#.00");
			    if(gd.getHz() != null & gd.getActiveUser() != null & gd.getActiveUser() != 0){
			    	hz = (double) ((double)gd.getHz()/(double)gd.getActiveUser());
			    }
			    objs[4] = df.format(hz);
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"总财务统计", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * 今日财务统计
	 * 信息列表
	 */
	@RequestMapping(value = "/todayStatistics/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("todayStatistics:query")
	public String todayStatisticsList(HttpServletRequest request, HttpServletResponse response,TodayStatistics todayStatistics,Model model) 
	{
		try{
			
		List<TodayStatistics> list = todayStatisticsService.getList(todayStatistics);

		model.addAttribute("lists", list);
		
		model.addAttribute("statistics",todayStatistics);
		
		}catch(Exception e){
			logger.error("[StatisticsController][list]:", e);
            return "500";
		}
		return "finance/todayList";
	}
	
	/**
	 *今日财务统计
	 */
	@RequestMapping(value = "/statisticsToday/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportStatisticsToday(HttpServletRequest request, HttpServletResponse response,TodayStatistics todayStatistics) {
		//查询需要导出的数据
		List<TodayStatistics> list = todayStatisticsService.getList(todayStatistics);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"时间","所属区","今日订单量","用户量","金额","客单价"};  
		Object[] objs = null; 
		if(null !=list && list.size()>0){
			for(TodayStatistics gd :list){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getTime();
			    objs[1] = gd.getNames();
			    objs[2] = gd.getOrderNum();
			    objs[3] = gd.getUserNum();
			    objs[4] = gd.getMoney();
			    
			    BigDecimal kMoney = BigDecimal.ZERO;
			    if(gd.getUserNum() != null && gd.getMoney() != null ){
			    	kMoney = gd.getMoney().divide(new BigDecimal(gd.getUserNum()),2, BigDecimal.ROUND_HALF_EVEN);
			    }
			    objs[5] = kMoney;
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"今日财务统计", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * 查询总客户分类统计
	 * 信息列表
	 */
	@RequestMapping(value = "/statisticsCustomer/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("statisticsCustomer:query")
	public String getCustomerList(HttpServletRequest request, HttpServletResponse response,FinancialStatistics financialStatistics,Model model) 
	{
		try{
			
		List<FinancialStatistics> list = financialStatisticsService.getCustomerList(financialStatistics);

		model.addAttribute("lists", list);
		
		model.addAttribute("statistics",financialStatistics);
		
		}catch(Exception e){
			logger.error("[StatisticsController][list]:", e);
            return "500";
		}
		return "finance/customerList";
	}
	
	/**
	 *客户分类统计
	 */
	@RequestMapping(value = "/statisticsCustomer/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportStatisticsCustomer(HttpServletRequest request, HttpServletResponse response,FinancialStatistics financialStatistics) {
		//查询需要导出的数据
		List<FinancialStatistics> list = financialStatisticsService.getCustomerList(financialStatistics);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"时间","所属区","买家名称","分类"};  
		Object[] objs = null; 
		if(null !=list && list.size()>0){
			for(FinancialStatistics gd :list){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getTime();
			    objs[1] = gd.getNames();
			    objs[2] = gd.getBuyerName();
			    Integer buyerLevel = gd.getBuyerLevel();
			    String bLevel= "未知";
			    if(buyerLevel != null){
			    	if(buyerLevel ==1){
			    		bLevel = "A";
			    	}if(buyerLevel ==2){
			    		bLevel = "B";
			    	}if(buyerLevel ==3){
			    		bLevel = "C";
			    	}if(buyerLevel ==4){
			    		bLevel = "D";
			    	}
			    }
			    objs[3] = bLevel;
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"客户分类统计", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * SKU财务统计
	 * 信息列表
	 */
	@RequestMapping(value = "/statisticsSku/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("statisticsSku:query")
	public String getStatisticsSkuList(HttpServletRequest request, HttpServletResponse response,FinancialStatistics financialStatistics,Model model) 
	{
		try{
			
		List<FinancialStatistics> list = financialStatisticsService.getSkuList(financialStatistics);

		model.addAttribute("lists", list);
		
		model.addAttribute("statistics",financialStatistics);
		
		}catch(Exception e){
			logger.error("[StatisticsController][list]:", e);
            return "500";
		}
		return "finance/skuListList";
	}
	
	/**
	 *SKU财务统计
	 */
	@RequestMapping(value = "/statisticsSku/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportStatisticsSku(HttpServletRequest request, HttpServletResponse response,FinancialStatistics financialStatistics) {
		//查询需要导出的数据
		List<FinancialStatistics> list = financialStatisticsService.getSkuList(financialStatistics);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"时间","所属区","商品名称","数量","金额"};  
		Object[] objs = null; 
		if(null !=list && list.size()>0){
			for(FinancialStatistics gd :list){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getTime();
			    objs[1] = gd.getNames();
			    objs[2] = gd.getGoodsName();
			    objs[3] = gd.getGoodsNum();
			    objs[4] = gd.getMoney();
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"SKU财务统计", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
}