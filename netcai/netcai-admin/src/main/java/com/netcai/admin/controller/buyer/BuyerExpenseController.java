package com.netcai.admin.controller.buyer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.service.BuyerExpenseService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerExpenseVo;

@Controller
@RequestMapping("/admin/buyerExpense")
public class BuyerExpenseController extends BaseController {

	@Autowired
	private BuyerExpenseService buyerExpenseService;

	/**
	 * 查询销售人员列表
	 * 
	 * @param request
	 * @param response
	 * @param sales
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("buyerExpense:query")
	public String buyerExpenseList(HttpServletRequest request, HttpServletResponse response, BuyerExpenseVo buyerExpenseVo, Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);
		
		PageUtil paginator = buyerExpenseService.getAll(buyerExpenseVo,pageNum,pageSize);

		model.addAttribute("paginator", paginator);
		
		model.addAttribute("buyerExpenseVo", buyerExpenseVo);

		return "buyer/buyerExpenseList";
	}

}
