package com.netcai.admin.controller.daliy;

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
import com.netcai.admin.entity.SalesDaliy;
import com.netcai.admin.entity.SalesVisit;
import com.netcai.admin.service.DaliyService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.ExportExcelUtil;
import com.netcai.admin.utils.PageUtil;

/**
 * 销售任务Controller
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class DaliyController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(DaliyController.class);
	
	@Autowired
	private DaliyService daliyService;
	/**
	 * 销售日报信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/daliy/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("daliy:query")
	public String daliyList(HttpServletRequest request, HttpServletResponse response,Long saleId,String beginDate,String endDate,Integer lookStatus, Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = daliyService.getPageDaliyResult(saleId, beginDate, endDate,lookStatus, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("saleId", saleId);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "daliy/daliyList";
	}
	
	/**
	 * 销售日报导出
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/daliy/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportDaliy(HttpServletRequest request, HttpServletResponse response,Long saleId,String beginDate,String endDate,Integer lookStatus) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		//查询需要导出的数据
		PageUtil paginator = daliyService.getPageDaliyResult(saleId, beginDate, endDate,lookStatus, currentPageNum, currentPageSize);

		List<SalesDaliy> list = (List<SalesDaliy>)paginator.getObject();
		
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"工作日期","姓名","销售任务","实际完成","拜访量","实际完成","拜访街道","工作总结","提交时间","上级主管","查阅时间","主管回复"};  
		Object[] objs = null; 
		if(null !=list && list.size()>0){
			for(SalesDaliy gd :list){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getSdDate();  
			    objs[1] = gd.getSaleName();  
			    objs[2] = gd.getTask1();  
			    objs[3] = gd.getTaskReal1();  
			    objs[4] = gd.getTask2();  
			    objs[5] = gd.getTaskReal2();  
			    objs[6] = gd.getSdStreet();  
			    objs[7] = gd.getSdSummary(); 
			    if(gd.getSdTime()!=null){
			    	objs[8] = DateUtil.dateToString(gd.getSdTime(), "yyyy-MM-dd HH:mm:ss"); 
			    }else{
			    	objs[8] = ""; 
			    }
			    if(gd.getLookTime()!=null){
			    	objs[9] = DateUtil.dateToString(gd.getLookTime(), "yyyy-MM-dd HH:mm:ss"); 
			    }else{
			    	objs[9] = "";
			    }
			    objs[10] = gd.getSdSummary(); 
			    objs[11] = gd.getLookReply(); 
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"销售日报列表", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			logger.error("[DaliyController][exportDaliy] exception",e);
		}  
	}

	/**
	 * 销售拜访记录列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/visit/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("visit:query")
	public String visitList(HttpServletRequest request, HttpServletResponse response,String buyerName,Long saleId,
			String beginDate,String endDate,Short svType, Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = daliyService.getPageVisitResult(buyerName,saleId, beginDate, endDate,svType, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("buyerName", buyerName);
		model.addAttribute("saleId", saleId);
		model.addAttribute("beginDate", beginDate);
		model.addAttribute("endDate", endDate);
		return "daliy/visitList";
	}
	
	/**
	 * 销售拜访记录导出
	 * @param request
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/visit/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportVisit(HttpServletRequest request, HttpServletResponse response,String buyerName,Long saleId,
			Short svType,String beginDate,String endDate) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		//查询需要导出的数据
		PageUtil paginator = daliyService.getPageVisitResult(buyerName,saleId, beginDate, endDate,svType, currentPageNum, currentPageSize);
		List<SalesVisit> list = (List<SalesVisit>)paginator.getObject();
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"销售姓名","买家店铺","买家姓名","买家电话","拜访地址","拜访感想","拜访时间"};  
		Object[] objs = null; 
		if(null !=list && list.size()>0){
			for(SalesVisit gd :list){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getSaleName();  
			    objs[1] = gd.getBuyerName();  
			    objs[2] = gd.getBossName();  
			    objs[3] = gd.getBossTel(); 
			    objs[4] = gd.getSvAddress(); 
			    objs[5] = gd.getSvRemark(); 
			    if(gd.getSvTime()!=null){
			    	objs[6] = DateUtil.dateToString(gd.getSvTime(), "yyyy-MM-dd HH:mm:ss"); 
			    }else{
			    	objs[6] = ""; 
			    }
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"销售拜访列表", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * 销售周报信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/weekly/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("weekly:query")
	public String weeklyList(HttpServletRequest request, HttpServletResponse response,Long saleId,Integer lookStatus, Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = daliyService.getPageWeeklyResult(saleId, lookStatus, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("saleId", saleId);
		model.addAttribute("lookStatus", lookStatus);
		return "daliy/weeklyList";
	}
}
