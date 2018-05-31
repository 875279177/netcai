package com.netcai.buyer.controller.area;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netcai.buyer.controller.base.BaseController;
import com.netcai.buyer.entity.Area;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.AreaService;

/**
 * 区域信息表
 * 
 * @author 
 */
@RestController
@RequestMapping("/buyer")
public class AreaController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

	@Autowired
	private AreaService areaService;


	/**
	 * 查询所有区
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/region/list", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult regionList(HttpServletRequest request, HttpServletResponse response) {
		try 
		{
			List<Area> areaList = areaService.getAllRegion();
			return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功",areaList);
		} catch (Exception e) {
			logger.error("[AreaController][regionList] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}