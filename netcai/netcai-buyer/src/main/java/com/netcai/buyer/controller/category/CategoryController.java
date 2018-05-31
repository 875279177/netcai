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
import com.netcai.buyer.entity.Category;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.CategoryService;

/**
 * 卖家商品分类
 * @author administrator
 */
@RestController
@RequestMapping("/buyer/category")
public class CategoryController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 卖家商品分类列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public JsonResult categoryList(HttpServletRequest request,HttpServletResponse response) {
		try{
			String parentId = request.getParameter("parentId");
			String level = request.getParameter("level");
			List<Category> categoryList = categoryService.getAllCategory(parentId,level);
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", categoryList);
		}catch(Exception ex){
			logger.error("[CategoryController][categoryList] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}

}
