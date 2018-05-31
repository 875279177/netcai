package com.netcai.admin.controller.delivery;

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
import com.netcai.admin.entity.DeliveryIncome;
import com.netcai.admin.service.DeliveryIncomeService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.ExportExcelUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;

@Controller
@RequestMapping("/admin/deliveryIncome")
public class DeliveryIncomeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(DeliveryIncomeController.class);

	@Autowired
	private DeliveryIncomeService deliveryIncomeService;
	
	/**
	 * 查询配送人员收入
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("deliveryIncome:query")
	public String deliveryIncomeList(HttpServletRequest request, HttpServletResponse response, DeliveryIncome deliveryIncome,
			Model model) {
		
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = deliveryIncomeService.getPageResult(deliveryIncome, pageNum, pageSize);
		
		model.addAttribute("paginator", paginator);
		
		model.addAttribute("deliveryIncome", deliveryIncome);

		logger.info("[DeliveryIncomeController][list]:");
		
		return "delivery/deliveryIncomeList";
	}
	
	/**
	 * 查询配送人员收入
	 */
	@RequestMapping(value = "/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void export(HttpServletRequest request, HttpServletResponse response, DeliveryIncome deliveryIncome,
			Model model) {
		
		List<DeliveryIncome> deliveryIncomes = deliveryIncomeService.getResult(deliveryIncome, null, null);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>(); 
		//excel显示列名称
		String[] rowsName = new String[]{"配送日期","配送人员名称","配送人员电话","送达金额","送达数量","提成收入","创建时间","配送区域"};
		Object[] objs = null;
		
		if(deliveryIncomes != null && deliveryIncomes.size() > 0){
			for (DeliveryIncome di : deliveryIncomes) {
				objs = new Object[rowsName.length];
				objs[0] = DateUtil.dateToString(di.getDiDate(),"YYYY-MM-dd");
				objs[1] = di.getDeliveryName();
				objs[2] = di.getDeliveryPhone();
				objs[3] = di.getDiAmt();
				objs[4] = di.getDiCount();
				objs[5] = di.getDiIncome();
				objs[6] = DateUtil.dateToString(di.getCreateTime(),"YYYY-MM-dd");
				objs[7] = di.getDiArea();
				dataList.add(objs);
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"配送人员績效", rowsName, dataList);
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		logger.info("[DeliveryIncomeController][export]:");
		
	}
	
	/**
	 * 查询配送人员送到的买家;
	 */
	@RequestMapping(value = "/getBuyer", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBuyer(HttpServletRequest request, HttpServletResponse response, DeliveryIncome deliveryIncome,
			Model model) {
		
		List<BuyerVo> buyers = deliveryIncomeService.getBuyer(deliveryIncome);
		
		model.addAttribute("buyers", buyers);
		
		model.addAttribute("time", deliveryIncome.getTime());

		logger.info("[DeliveryIncomeController][getBuyer]:");
		
		return "delivery/deliveryBuyer";
	}
}