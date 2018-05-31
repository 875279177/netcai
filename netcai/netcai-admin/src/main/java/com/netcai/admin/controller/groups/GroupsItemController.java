package com.netcai.admin.controller.groups;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.GroupsItem;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.GroupsItemService;
import com.netcai.admin.vo.GroupsVo;

/**
 * 团购活动明细
 * 
 * @author administrator
 *
 */
@Controller
@RequestMapping("/admin/groupsItem")
public class GroupsItemController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(GroupsItemController.class);

	@Autowired
	private GroupsItemService groupsItemService;
	
	/**
	 * 跳转到团购明细
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @param model
	 * @return
	 */
	@RequestMapping("/getDetails")
	public String getDetails(HttpServletRequest request, HttpServletResponse response, Model model, Long groupsId) {
		List<GroupsItem> groupsItems = groupsItemService.getByGroupsId(groupsId);
		model.addAttribute("groupsItems", groupsItems);
		return "groups/groupsItems";
	}
	
	/**
	 * 新增或修改团购详情
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addGroupsItems", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult addGroupsItems(HttpServletRequest request, HttpServletResponse response, GroupsVo groups) {
		logger.info("[GroupsController][insertAndUpdate] 新增和更新:");
		try {
			if (null == groups) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入数据", "");
			}
			if (null == groups.getGoodsId()) {
				return new JsonResult(JsonResultCode.FAILURE, "请选择商品", "");
			}
			if (StringUtils.isBlank(groups.getFormatIds())) {
				return new JsonResult(JsonResultCode.FAILURE, "请选择规格", "");
			}
			if (null == groups.getGroupPrice() && groups.getGroupPrice().compareTo(BigDecimal.ZERO) != 1) {
				return new JsonResult(JsonResultCode.FAILURE, "请输合理的入团购价", "");
			}
			if (null == groups.getCount() && groups.getCount().intValue() <= 0) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入正确格式的团购数量", "");
			}
			// 获取当用用户id
			Long userId = this.getLoginUserId(request);
			groups.setCreateUserId(userId);

			// 通过id来判断是新增还是修改
			int result = groupsItemService.add(groups);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
			}
		} catch (Exception e) {
			logger.error("[GroupsController][insertAndUpdate] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 更新团购明细
	 * 
	 * @param request
	 * @param response
	 * @param groups
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult disabled(HttpServletRequest request, HttpServletResponse response, GroupsVo groups) {
		logger.info("[GroupsController][disabled] 新增和更新:");
		try {
			if (null == groups.getItemId()) {
				return new JsonResult(JsonResultCode.SUCCESS, "该数据不存在", "");
			}
			if (null != groups.getGroupPrice() && groups.getGroupPrice().compareTo(BigDecimal.ZERO) != 1) {
				return new JsonResult(JsonResultCode.SUCCESS, "团购价格必须大于0", "");
			}
			if (null != groups.getCount() && groups.getCount().intValue() <= 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "团购数量必须大于0", "");
			}
			int result = groupsItemService.update(groups);
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
	
	/**
	 * 启用
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
			int result = groupsItemService.enabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
			}
		} catch (Exception e) {
			logger.error("[GroupsController][enabled] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 禁用
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
			int result = groupsItemService.disabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
			}
		} catch (Exception e) {
			logger.error("[GroupsController][disabled] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

}
