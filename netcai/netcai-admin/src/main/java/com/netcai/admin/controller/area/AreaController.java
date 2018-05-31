package com.netcai.admin.controller.area;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Area;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.AreaService;

/**
 * 区域信息表
 * 
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class AreaController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	private AreaService areaService;

	/**
	 * 查询所有的省
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/province/list", method = { RequestMethod.GET, RequestMethod.POST })
	public Object provinceList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Area> areaList = areaService.getAllProvince();

			if (CollectionUtils.isNotEmpty(areaList)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", areaList);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception e) {
			log.error("[AreaController][provinceList]exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 查询省下面的所有市
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/city/list", method = { RequestMethod.GET, RequestMethod.POST })
	public Object cityList(HttpServletRequest request, HttpServletResponse response, Long provinceId) {
		try {
			List<Area> areaList = areaService.getAllCity(provinceId);

			if (CollectionUtils.isNotEmpty(areaList)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", areaList);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception e) {
			log.error("[AreaController][cityList] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 查询市下面的所有区
	 */
	@ResponseBody
	@RequestMapping(value = "/region/list", method = { RequestMethod.GET, RequestMethod.POST })
	public Object regionList(HttpServletRequest request, HttpServletResponse response, Long cityId) {
		try 
		{
			List<Area> areaList = areaService.getAllRegion(cityId);
			if (CollectionUtils.isNotEmpty(areaList)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功",areaList);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception e) {
			log.error("[AreaController][regionList] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 查询所有区
	 */
	@ResponseBody
	@RequestMapping(value = "/region/Alllist", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult regionAll(HttpServletRequest request, HttpServletResponse response) {
		try 
		{
			List<Area> areaList = areaService.getAllRegion();
			if (CollectionUtils.isNotEmpty(areaList)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功",areaList);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception e) {
			log.error("[AreaController][regionList] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}