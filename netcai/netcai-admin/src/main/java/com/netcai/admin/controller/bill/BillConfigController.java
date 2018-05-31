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
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.BillSellerConfig;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.AreaService;
import com.netcai.admin.service.BillSellerConfigService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillSellerConfigVo;

@Controller
@RequestMapping("/admin/billSellerConfig")
public class BillConfigController extends BaseController {

	private static final Logger logger = Logger.getLogger(BillConfigController.class);

	@Autowired
	private BillSellerConfigService billSellerConfigService;

	@Autowired
	private AreaService areaService;

	/**
	 * 查询卖家帐单周期配置列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("billSellerConfig:query")
	public String getAll(HttpServletRequest request, HttpServletResponse response, Model model,
			BillSellerConfigVo billSellerConfig) {
		logger.info("[BillSellerConfigController][getAll] 查询卖家帐单周期配置列表:");
		int pageNum = this.getPageNum(request);
		int pageSize = this.getPageSize(request);
		PageUtil paginator = billSellerConfigService.getAll(billSellerConfig, pageNum, pageSize);
		List<Area> areaList = areaService.getAllRegion();
		model.addAttribute("paginator", paginator);
		model.addAttribute("billSellerConfig", billSellerConfig);
		model.addAttribute("areaList", areaList);
		return "seller/bill/configList";
	}

	/**
	 * 根据id卖家帐单周期配置
	 */
	@ResponseBody
	@RequestMapping(value = "/getById", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getBill(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[BillSellerController][getBillSellerById] 查询卖家帐单周期配置id:" + id);
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "id为空", "");
			}
			BillSellerConfig billSeller = billSellerConfigService.getById(id);
			if (null != billSeller) {
				return new JsonResult(JsonResultCode.SUCCESS, "根据id查询数据成功", billSeller);
			}
			return new JsonResult(JsonResultCode.FAILURE, "根据id查询数据失败", "");
		} catch (Exception e) {
			logger.error("[BillSellerConfigController][getBill] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 跳转到新增页面
	 */
	@RequestMapping(value = "/addBillSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(HttpServletRequest request, HttpServletResponse response, Long id, Model model) {
		// 修改数据
		if (id != null) {
			// 根据id查询数据将数据返回到修改页面进行填充
			BillSellerConfig billSeller = billSellerConfigService.getById(id);
			model.addAttribute("billSeller", billSeller);
		} 
		List<Area> areaList = areaService.getAllRegion();
		model.addAttribute("areaList", areaList);
		return "seller/bill/addConfig";
	}

	/**
	 * 新增和修改
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult insert(HttpServletRequest request, HttpServletResponse response,
			BillSellerConfigVo billSeller) {
		logger.info("[BillSellerConfigController][insertAndUpdate] 新增:" + billSeller);
		try {
			if (null == billSeller || null == billSeller.getSellerId()) {
				return new JsonResult(JsonResultCode.FAILURE, "请选择卖家", "");
			}
			int result = billSellerConfigService.insertAndUpdate(billSeller);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "新增数据成功", "");
			} else if (result == 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "该商家帐单周期配置已存在", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "新增数据失败", "");
		} catch (Exception e) {
			logger.error("[BillSellerController][insertAndUpdate] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult update(HttpServletRequest request, HttpServletResponse response,Long id,Integer period) {
		logger.info("[BillSellerConfigController][update] 更新id:" + id);
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "卖家帐单周期配置id为空", "");
			}
			BillSellerConfigVo billSeller = new BillSellerConfigVo();
			billSeller.setId(id);
			billSeller.setPeriod(period);
			int result = billSellerConfigService.insertAndUpdate(billSeller);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		} catch (Exception e) {
			logger.error("[BillSellerConfigController][disabled] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 禁用
	 */
	@ResponseBody
	@RequestMapping(value = "/disabled", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult disabled(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[BillSellerConfigController][disabled] 禁用id:" + id);
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "卖家帐单周期配置id为空", "");
			}
			int result = billSellerConfigService.disabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
		} catch (Exception e) {
			logger.error("[BillSellerConfigController][disabled] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 启用
	 */
	@ResponseBody
	@RequestMapping(value = "/enabled", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult enabled(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[BillSellerConfigController][enabled] 启用id:" + id);
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "卖家帐单周期配置id为空", "");
			}
			int result = billSellerConfigService.enabled(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
		} catch (Exception e) {
			logger.error("[BillSellerConfigController][enabled] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

}
