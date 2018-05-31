package com.netcai.admin.controller.delivery;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
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
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.DeliveryRelatedArea;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.AreaService;
import com.netcai.admin.service.DeliveryAreaService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.DeliveryAreaVo;

@Controller
@RequestMapping("/admin/deliveryArea")
public class DeliveryAreaController extends BaseController{
	
	private static final Logger logger= LoggerFactory.getLogger(DeliveryAreaController.class);
	
	@Autowired
	private DeliveryAreaService deliveryAreaService;
	
	@Autowired
	private AreaService areaService;
	
	/**
	 * 查询配送区域列表
	 * 
	 * @param request
	 * @param response
	 * @param deliveryArea
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("deliveryArea:query")
	public String deliveryList(HttpServletRequest request, HttpServletResponse response, DeliveryAreaVo deliveryArea,
			Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = deliveryAreaService.getAll(deliveryArea, pageNum, pageSize);

		model.addAttribute("paginator", paginator);

		model.addAttribute("deliveryArea", deliveryArea);

		return "deliveryArea/list";
	}

	/**
	 * 加载添加数据弹窗页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/toAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String addDeliveryArea(HttpServletRequest request, HttpServletResponse response, Long id, Model model) {
		if (id != null) {
			// 查询配送人员信息
			DeliveryAreaVo deliveryArea = deliveryAreaService.selectById(id);
			if (deliveryArea != null) {
				model.addAttribute("deliveryArea", deliveryArea);
			}
		}
		List<Area> provice = areaService.getAllProvince();
		model.addAttribute("provice", provice);
		return "deliveryArea/addDeliveryArea";
	}

	/**
	 * 新增或修改配送人员信息
	 * 
	 * @param request
	 * @param response
	 * @param delivery
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public Object insertAndUpdateDelivery(HttpServletRequest request, HttpServletResponse response, DeliveryAreaVo deliveryArea) {
		try {
			String message = "修改成功";
			// 新增数据时根据手机号查询配送人员的信息是否存在
			if (deliveryArea.getId() == null) {
				message = "添加成功";
			}
			//获取当前登录用户id
			Long userId = super.getLoginUserId(request);
			deliveryArea.setUserId(userId);
			// 插入配送人员信息
			int result = deliveryAreaService.insertAndUpdate(deliveryArea);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, message, "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "更新数据失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryAreaController][insertAndUpdate] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}

	}
	
	/**
	 * 获取areaId下所有的配送区域
	 * 
	 * @param request
	 * @param response
	 * @param areaId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getDeliveryAreas", method = { RequestMethod.GET, RequestMethod.POST })
	public Object getDeliveryAreas(HttpServletRequest request, HttpServletResponse response, Long areaId) {
		if (areaId == null) {
			return new JsonResult(JsonResultCode.FAILURE, "参数为空", "");
		}
		try {
			List<DeliveryAreaVo> deliveryAreas = deliveryAreaService.selectByAreaId(areaId);
			if (CollectionUtils.isNotEmpty(deliveryAreas)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询成功", deliveryAreas);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryAreaController][disabled] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 禁用
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/disabled", method = { RequestMethod.GET, RequestMethod.POST })
	public Object disabled(HttpServletRequest request, HttpServletResponse response, Long id) {
		if (id == null) {
			return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
		}
		try {
			int result = deliveryAreaService.disabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryAreaController][disabled] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 启用
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/enabled", method = { RequestMethod.GET, RequestMethod.POST })
	public Object enabled(HttpServletRequest request, HttpServletResponse response, Long id) {
		if (id == null) {
			return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
		}
		try {
			int result = deliveryAreaService.enabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryAreaController][enabled] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 配送人员分配配送区域
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/distributeDelivery", method = { RequestMethod.GET, RequestMethod.POST })
	public Object distributeDelivery(HttpServletRequest request, HttpServletResponse response, DeliveryRelatedArea deliveryRelatedArea,String deliveryAreaIds) {
		try {
			//获取当前登录用户id
			Long userId = super.getLoginUserId(request);
			deliveryRelatedArea.setUserId(userId);
			int result = deliveryAreaService.distributeDelivery(deliveryRelatedArea,deliveryAreaIds);
			if (result >= 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "分配成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "分配失败,配送人员已分配过此配送区域", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryAreaController][enabled] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}