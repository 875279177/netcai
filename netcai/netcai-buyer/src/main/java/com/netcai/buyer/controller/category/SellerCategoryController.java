package com.netcai.buyer.controller.category;

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
import com.netcai.buyer.entity.SellerCategory;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.SellerCategoryService;

/**
 * 卖家商品分类
 * @author administrator
 */
@RestController
@RequestMapping("/buyer")
public class SellerCategoryController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(SellerCategoryController.class);
	
	@Autowired
	private SellerCategoryService sellerCategoryService;
	
	/**
	 * 卖家商品分类列表
	 * @return
	 */
	@RequestMapping(value = "/sellercategory/list", method = { RequestMethod.GET })
	public JsonResult scList(HttpServletRequest request,HttpServletResponse response,SellerCategory sellerCategory) {
		try{
			if(null == sellerCategory){
				return new JsonResult(JsonResultCode.FAILURE, "参数错误","");
			}
			//判断卖家ID是否有传
			if(null == sellerCategory.getUserId() || 0 == sellerCategory.getUserId()){
				return new JsonResult(JsonResultCode.FAILURE, "参数错误,请检查是否在登录状态","");
			}
			List<SellerCategory> scList = sellerCategoryService.getSellerCategoryList(sellerCategory);
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", scList);
		}catch(Exception ex){
			logger.error("[SellerCategoryController][scList] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
}
