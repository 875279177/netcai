package com.netcai.admin.controller.delivery;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Delivery;
import com.netcai.admin.entity.DeliveryRelatedArea;
import com.netcai.admin.entity.DeliveryTask;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.AreaService;
import com.netcai.admin.service.DeliveryAreaService;
import com.netcai.admin.service.DeliveryService;
import com.netcai.admin.service.DeliveryTaskService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.DeliveryAreaVo;
import com.netcai.admin.vo.DeliveryCoordinateVo;

@Controller
@RequestMapping("/admin/delivery")
public class DeliveryController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(DeliveryController.class);

	@Autowired
	private DeliveryService deliveryService;

	@Autowired
	private AreaService areaService;
	
	@Autowired
	private DeliveryTaskService deliveryTaskService;
	
	@Autowired
	private DeliveryAreaService deliveryAreaService;
	
	/**
	 * 查询配送人员列表
	 * 
	 * @param request
	 * @param response
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("delivery:query")
	public String deliveryList(HttpServletRequest request, HttpServletResponse response, Delivery delivery,
			Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = deliveryService.getPageResult(delivery, pageNum, pageSize);
		
		List<Area> regions = areaService.getAllRegion();

		model.addAttribute("paginator", paginator);

		model.addAttribute("delivery", delivery);
		
		model.addAttribute("regions", regions);

		return "delivery/deliveryList";
	}

	/**
	 * 加载添加数据弹窗页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addDelivery", method = { RequestMethod.GET, RequestMethod.POST })
	public String addDelivery(HttpServletRequest request, HttpServletResponse response, Long id, Model model) {
		if (id != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", id);
			// 查询配送人员信息
			Delivery delivery = deliveryService.getDelivery(map);
			if (delivery != null) {
				model.addAttribute("delivery", delivery);
			}
		}
		List<Area> regions = areaService.getAllRegion();
		model.addAttribute("regions", regions);
		return "delivery/addDelivery";
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
	public Object insertAndUpdateDelivery(HttpServletRequest request, HttpServletResponse response, Delivery delivery) {
		try {
			if (StringUtils.isBlank(delivery.getDeliveryPhone())||delivery.getDeliveryPhone().length()!=11) {
				return new JsonResult(JsonResultCode.FAILURE, "请输入正确的手机号", "");
			}
			String message = "修改成功";
			
			// 新增数据时根据手机号查询配送人员的信息是否存在
			if (delivery.getId() == null) {
				Map<String, Object> map = new HashMap<>();
				map.put("deliveryPhone", delivery.getDeliveryPhone());
				Delivery entity = deliveryService.getDelivery(map);
				// 若存在则提示手机号已存在
				if (entity != null) {
					return new JsonResult(JsonResultCode.FAILURE, "该手机号已注册", "");
				}
				message = "添加成功";
			}
			// 插入配送人员信息
			int result = deliveryService.insertDelivery(delivery);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, message, "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "更新数据失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryController][insertAndUpdate] id:", e);
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
			int result = deliveryService.disabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryController][disabled] id:", e);
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
			int result = deliveryService.enabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
			}
		} catch (Exception e) {
			logger.error("[DeliveryController][enabled] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 批量新增订单派送任务;
	 */
	@ResponseBody
	@RequestMapping(value = "/addTask", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult addTask(HttpServletRequest request, HttpServletResponse response,@RequestParam("orderIds[]")List<Long> orderIds,Long deliveryId) {
		if (orderIds == null || deliveryId == null) {
			return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
		}
		try {
			Long loginUserId = this.getLoginUserId(request);
			List<DeliveryTask> deliveryTasks = new ArrayList<>();
			for (int i = 0; i < orderIds.size(); i++) {
				DeliveryTask deliveryTask = new DeliveryTask();
				deliveryTask.setOrderId(orderIds.get(i));
				deliveryTask.setDeliveryId(deliveryId);
				deliveryTask.setCreateTime(new Date());
				deliveryTask.setSysUserId(loginUserId);
				deliveryTasks.add(deliveryTask);
			}
			int result = deliveryTaskService.insertBatch(deliveryTasks);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			}
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			
		} catch (Exception e) {
			logger.error("[DeliveryController][addTask]", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 批量新增订单派送任务;
	 */
	@ResponseBody
	@RequestMapping(value = "/delTask", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delTask(HttpServletRequest request, HttpServletResponse response,Long orderId,Long deliveryId) {
		if (orderId == null || deliveryId == null) {
			return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
		}
		try {
			int result = deliveryTaskService.delByOrderIdByDeliveryId(orderId, deliveryId);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功", "");
			}
				return new JsonResult(JsonResultCode.FAILURE, "删除失败", "");
			
		} catch (Exception e) {
			logger.error("[DeliveryController][delTask]", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 分配配送区域弹窗页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/toDistribute", method = { RequestMethod.GET, RequestMethod.POST })
	public String toDistributeDelivery(HttpServletRequest request, HttpServletResponse response, Long areaId,Long deliveryId, Model model) {
		//查询区下的所有配送区域
		List<DeliveryAreaVo> deliveryAreas = deliveryAreaService.selectByAreaId(areaId);
		//查看配送人员负责的配送区域
		List<DeliveryRelatedArea> list = deliveryService.getDeliveryAreaById(deliveryId);
		for(DeliveryAreaVo deliveryArea :deliveryAreas){
			if(deliveryArea==null){
				continue ;
			}
			for(DeliveryRelatedArea relatedArea:list){
				if(relatedArea==null || relatedArea.getDeliveryAreaId()==null){
					continue ;
				}
				if(relatedArea.getDeliveryAreaId().longValue()==deliveryArea.getId().longValue()){
					deliveryArea.setChecked(1);
					break ;
				}
			}
		}
		model.addAttribute("deliveryAreas", deliveryAreas);
		model.addAttribute("deliveryId", deliveryId);
		return "delivery/distributeDelivery";
	}
	
	/**
	 * 查询配送人员允许轨迹
	 * @param request
	 * @param response
	 * @param deliveryId
	 * @return
	 */
	@RequestMapping(value = "/runing", method = { RequestMethod.GET, RequestMethod.POST })
	public String runing(HttpServletRequest request, HttpServletResponse response, Long deliveryId,Model model) {
		List<DeliveryCoordinateVo> dcList = deliveryService.getDeliveryCoordinate(deliveryId);
		model.addAttribute("coordinates", dcList);
		return "delivery/deliveryTrack";
	}
	
	
	/**
	 * 查询成功
	 */
	@ResponseBody
	@RequestMapping(value = "/getDelivery", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getDelivery(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Delivery> deliverys = deliveryService.getDeliverys();
			if (deliverys.size() > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询成功", deliverys);
			}
				return new JsonResult(JsonResultCode.FAILURE, "查询失败", "");
			
		} catch (Exception e) {
			logger.error("[DeliveryController][getDelivery]", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}