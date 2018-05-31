package com.netcai.buyer.controller.inventory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netcai.buyer.controller.base.BaseController;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;

/**
 * 买家常用清单
 * @author administrator
 */
@RestController
@RequestMapping("/buyer")
public class InventoryController extends BaseController
{
	private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

	@RequestMapping(value = "/inventory/list", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult inventoryList(HttpServletRequest request, HttpServletResponse response,Model model)
	{
		try
		{
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功","");
		}catch(Exception ex)
		{
			logger.error("[InventoryController][inventoryList] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
}