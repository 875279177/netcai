package com.netcai.admin.controller.groups;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.GroupsBuyer;
import com.netcai.admin.service.GroupsBuyerService;
import com.netcai.admin.utils.PageUtil;
/**
 */
@Controller
@RequestMapping("/admin/groupsBuyer")
public class GroupsBuyerController extends BaseController {

	private static final Logger logger = Logger.getLogger(GroupsBuyerController.class);

	@Autowired
	private GroupsBuyerService groupsBuyerService;

	
	/**
	 * 消息;
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("groupsBuyer:query")
	public String list(HttpServletRequest request, HttpServletResponse response,GroupsBuyer groupsBuyer,Model model){
		try{
			
			int currentPageNum = this.getPageNum(request);
			
			int currentPageSize = this.getPageSize(request);
			
			PageUtil pageResult = groupsBuyerService.getPageResult(groupsBuyer, currentPageNum, currentPageSize);
			
			model.addAttribute("pageResult",pageResult);
			
			model.addAttribute("groupsBuyer",groupsBuyer);
		}catch(Exception e){
			logger.error("[GroupsBuyerController][list]:", e);
			return "500";
		}
		return "groups/groupsBuyerList";
	}
}
