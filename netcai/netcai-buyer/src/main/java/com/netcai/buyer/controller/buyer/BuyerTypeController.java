package com.netcai.buyer.controller.buyer;

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
import com.netcai.buyer.entity.BuyerType;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.BuyerTypeService;

/**
 * 买家类型维护
 * @author administrator
 */

@RestController
@RequestMapping("/buyer")
public class BuyerTypeController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerTypeController.class);
	
	@Autowired
	private BuyerTypeService buyerTypeService;

	@RequestMapping(value="/type/list",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult buyerTypeList(HttpServletRequest request, HttpServletResponse response) 
	{
		try
		{
			List<BuyerType> result = buyerTypeService.getAllBuyerType();
		    return new JsonResult(JsonResultCode.SUCCESS, "查询成功",result);
		}catch(Exception ex){
			logger.error("[BuyerTypeController][buyerTypeList] exception",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
}