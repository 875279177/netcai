package com.netcai.admin.controller.groups;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.GroupsService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动Controller
 * 
 * @author administrator
 *
 */
@Controller
@RequestMapping("/admin/groups")
public class GroupsController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(GroupsController.class);

	@Autowired
	private GroupsService groupsService;

	/**
	 * 分页查询团购活动
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	@RequiresPermissions("groups:query")
	public String getGoupsList(HttpServletRequest request, HttpServletResponse response, GroupsVo groups, Model model) {
		try {

			int currentPageNum = this.getPageNum(request);

			int pageSize = this.getPageSize(request);

			PageUtil paginator = groupsService.getAllByPage(groups, currentPageNum, pageSize);

			model.addAttribute("paginator", paginator);

			model.addAttribute("groups", groups);

		} catch (Exception e) {
			logger.error("[GroupsController][getGoupsList]:", e);
			return "500";
		}
		return "groups/groupsList";
	}

	/**
	 * 跳转到新增页面
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @param model
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAddGroups(HttpServletRequest request, HttpServletResponse response, Long id, Model model) {
		if (null != id) {
			GroupsVo groups = groupsService.getById(id);
			model.addAttribute("groups", groups);
		}
		return "groups/addGroups";
	}

	/**
	 * 跳转到选择商品页面
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectGoods")
	public String selectGoods(HttpServletRequest request, HttpServletResponse response, Model model, Long id) {
		model.addAttribute("groupsId", id);
		return "groups/selectGoods";
	}

	/**
	 * 新增或修改团购活动信息
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult addGroups(HttpServletRequest request, HttpServletResponse response, GroupsVo groups) {
		logger.info("[GroupsController][addGroups] 新增和更新:");
		try {
			int result = 0;
			if (null == groups) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
			}
			if (StringUtils.isBlank(groups.getRegionIds())) {
				return new JsonResult(JsonResultCode.FAILURE, "请选择团购获取区域", "");
			}
			if (StringUtils.isBlank(groups.getTitle())) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入团购活动主题", "");
			}
			if (StringUtils.isBlank(groups.getBeginTimeStr())) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入团购开始时间", "");
			}
			if (StringUtils.isBlank(groups.getEndTimeStr())) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入团购结束时间", "");
			}
			if (null == groups.getGroupsAmount()) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入团购金额", "");
			}
			if (null == groups.getMinGroupsAmount()) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入买家起团价", "");
			}
			// 转换时间格式
			Date beginTime = DateUtil.stringToDate(groups.getBeginTimeStr(), DateUtil.FMT_DATETIME);
			Date endTime = DateUtil.stringToDate(groups.getEndTimeStr(), DateUtil.FMT_DATETIME);
			groups.setBeginTime(beginTime);
			groups.setEndTime(endTime);
			// 获取当用用户id
			Long userId = this.getLoginUserId(request);
			groups.setCreateUserId(userId);

			// 通过id来判断是新增还是修改
			if (null != groups.getId()) {
				result = groupsService.update(groups);
			} else {
				result = groupsService.insert(groups);
			}
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
			}
		} catch (Exception e) {
			logger.error("[GroupsController][addGroups] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 状态更新为开团
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/enabled", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult enabled(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[GroupsController][enabled] 新增和更新:");
		try {
			if(null == id){
				return new JsonResult(JsonResultCode.SUCCESS, "该数据不存在", "");
			}
			int result = groupsService.enabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
		} catch (Exception e) {
			logger.error("[GroupsController][enabled] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 状态更新为不开团
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/disabled", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult disabled(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[GroupsController][disabled] 新增和更新:");
		try {
			if(null == id){
				return new JsonResult(JsonResultCode.SUCCESS, "该数据不存在", "");
			}
			int result = groupsService.disabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
		} catch (Exception e) {
			logger.error("[GroupsController][disabled] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
}
