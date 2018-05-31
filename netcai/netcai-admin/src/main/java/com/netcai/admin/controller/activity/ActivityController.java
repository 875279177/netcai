package com.netcai.admin.controller.activity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Activity;
import com.netcai.admin.service.ActivityService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.ActivityVo;

/**
 * 促销活动Controller
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class ActivityController extends BaseController{
	
	private static final Logger logger = LoggerFactory.getLogger(ActivityController.class);
	@Autowired
	private ActivityService activityService;

	/**
	 * 商品信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/activity/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("activity:query")
	public String activityList(HttpServletRequest request, HttpServletResponse response,@ModelAttribute Activity activity, Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = activityService.getPageResult(activity, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("activity", activity);
		return "activity/activityList";
	}

	/**
	 * 添加修商品信息跳转
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/activity/addOrEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String addOrEdit(HttpServletRequest request, HttpServletResponse response,Model model,Short activityType,Integer activityId) {
		try {
			if(null != activityId){
				ActivityVo activity = activityService.getActivityInfo(activityId);
				model.addAttribute("activity", activity);
			} else {
				model.addAttribute("activityType", activityType);
			}
			if(1 == activityType){
				return "activity/addFullDownActivity";
			} else if (2 == activityType){
				return "activity/addFullGiftActivity";
			} else if (3 == activityType){
				return "activity/addSpecialOfferActivity";
			}
		} catch (Exception e) {
			logger.error("[ActivityController][addOrEdit]: activityId="+activityId, e);
            return "500";
		}
		return "";
	}
	
	/*
	 *添加、修改商品信息
	 */
	@RequestMapping(value = "/activity/saveOrUpdate", method = {RequestMethod.POST })
	public String saveOrUpActivity(HttpServletRequest request, HttpServletResponse response,Activity activity) {
		try {
			if(null == activity.getActivityId()){
				//新增
				activityService.insertActivity(activity);
			} else {
				//修改
				activityService.updateActivity(activity);
			}
		} catch (Exception e) {
			logger.error("[ActivityController][saveOrUpActivity]:", e);
            return "500";
		}
		return "redirect:/admin/activity/list";
	}
}