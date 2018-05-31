package com.netcai.admin.controller.bill;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcai.admin.entity.BillExceptionLog;
import com.netcai.admin.service.BillExceptionLogService;
import com.netcai.admin.vo.BillVo;

@Controller
@RequestMapping("/admin/billExceptionLog")
public class BillErrorLogController {
	
	private static final Logger logger = Logger.getLogger(BillErrorLogController.class);
	
	@Autowired
	private BillExceptionLogService billExceptionLogService;
	
	/**
	 * 查询卖家帐单列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("billExceptionLog:query")
	public String getAll(HttpServletRequest request, HttpServletResponse response, Model model, BillVo bill) {
		logger.info("[BillExceptionLogController][getAll] 查询帐单列表:");
		List<BillExceptionLog> billExceptionLogs = billExceptionLogService.getAll();
		model.addAttribute("billExceptionLogs", billExceptionLogs);
		return "seller/bill/errorLogList";
	}
}
