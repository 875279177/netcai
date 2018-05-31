package com.netcai.buyer.controller.groups;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netcai.buyer.controller.base.BaseController;
import com.netcai.buyer.entity.GroupOrder;
import com.netcai.buyer.entity.OrderInfo;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.GroupsService;
import com.netcai.buyer.vo.GroupsVo;

/**
 * 团购Controller
 * @author administrator
 */
@RestController
@RequestMapping("/buyer")
public class GroupsController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(GroupsController.class);
	@Autowired
	private GroupsService groupsService;
	
	/**
	 * 团购活动列表
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/groups/list", method = { RequestMethod.GET})
	public JsonResult groupsList(HttpServletRequest request, HttpServletResponse response,Long regionId) {
		try{
			if(null == regionId || 0 == regionId){
				return new JsonResult(JsonResultCode.FAILURE, "参数错误，请检查regionId是否有传","");
			}
			List<GroupsVo> cgList = groupsService.getGroupsList(regionId);
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", cgList);
		}catch(Exception ex){
			logger.error("[GroupsController][groupsList] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	/*
	 * 团购活动详情
	 */
	@RequestMapping(value = "/groups/detail", method = { RequestMethod.GET })
	public JsonResult detailGroups(HttpServletRequest request, HttpServletResponse response,Long groupId) {
		try{
			if(null == groupId || 0 == groupId){
				return new JsonResult(JsonResultCode.FAILURE, "参数错误，请检查groupId是否有传","");
			}
			GroupsVo groupsVo = groupsService.getGroupsInfo(groupId);
			if(groupsVo == null){
				groupsVo = new GroupsVo();
			}
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", groupsVo);
		}catch(Exception ex){
			logger.error("[GroupsController][detailGroups] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	/**
	 * 团购下单
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/groups/createOrder", method = { RequestMethod.POST })
	public JsonResult createOrder(HttpServletRequest request, HttpServletResponse response,
			@RequestBody GroupOrder groupOrder) {
		try {
			String time = groupOrder.getBestTime();
			if (StringUtils.isBlank(time)) {
				return new JsonResult(JsonResultCode.FAILURE, "订单创建失败,收货时间不允许为空", "");
			}
			
			OrderInfo addOrderInfo = groupsService.addOrderInfo(groupOrder);
			if (addOrderInfo == null) {
				return new JsonResult(JsonResultCode.FAILURE, "创建订单失败，订单金额小于起送价", "");
			}
			return new JsonResult(JsonResultCode.SUCCESS, "创建订单成功", addOrderInfo);
		} catch (Exception ex) {
			logger.error("[GroupsController][createOrder] exception :", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}
}
