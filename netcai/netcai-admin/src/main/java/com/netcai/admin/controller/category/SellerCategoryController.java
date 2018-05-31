package com.netcai.admin.controller.category;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.SellerCategory;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.SellerCategoryService;

/**
 * 卖家商品分类
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class SellerCategoryController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(SellerCategoryController.class);
	
	@Autowired
	private SellerCategoryService sellerCategoryService;
	
	/**
	 * 设置商家分类
	 * @return
	 */
	@RequestMapping(value = "/sellercategory/add", method = { RequestMethod.GET })
	public String editSellerCategory(HttpServletRequest request,HttpServletResponse response,Model model,Long sellerId) {
		model.addAttribute("sellerId", sellerId);
		//已选择的商品分类
		List<SellerCategory> scList = sellerCategoryService.getSellerCategoryList(sellerId,null);
		model.addAttribute("scList", scList);
		return "seller/sellerCategory"; 
	}
	
	/**
	 * 卖家商品分类树
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sellercategory/tree", method = { RequestMethod.GET })
	public Object scTree(HttpServletRequest request,HttpServletResponse response,Long userId) {
		try{
			List<SellerCategory> secondList = sellerCategoryService.getSellerCategoryList(userId,(short)2);
			List<SellerCategory> threeList = sellerCategoryService.getSellerCategoryList(userId,(short)3);
			JSONArray all = new JSONArray();
			JSONArray sencond = null;
			if (null != secondList){
				for (SellerCategory second : secondList) {
		            JSONObject one = JSONObject.fromObject(second);
		            int categoryId = second.getCategoryId();
		            if (null != threeList){
		            	sencond = new JSONArray();
		            	for (SellerCategory three : threeList) {
		            		if(categoryId == three.getParentId()){
		            			sencond.add(three);
		            		} 
		            	}
            			one.put("children", sencond);
		            }
		            all.add(one);
		        }
			}
	        return all;
		}catch(Exception ex){
			logger.error("[SellerCategoryController][scTree] exception :",ex);
			return "";
		}
	}
	

	/**
	 * 添加卖家的商品分类
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/sellercategory/save", method = { RequestMethod.POST })
	public JsonResult addSellerCategory(HttpServletRequest request,HttpServletResponse response,Long userId,String categoryIds) {
		try{
			if(null == categoryIds || "".equals(categoryIds)){
				return new JsonResult(JsonResultCode.FAILURE, "请选择商品分类","");
			}
			String[] ids = categoryIds.split(",");
			List<SellerCategory> scList = new ArrayList<SellerCategory>();
			for(int i=0;i<ids.length;i++){
				SellerCategory sc = new SellerCategory();
				sc.setUserId(userId);
				sc.setCategoryId(Integer.valueOf(ids[i]));
				sc.setScSeq(i+1);
				scList.add(sc);
			}
			int result = sellerCategoryService.batchInsertSellerCategory(userId, scList);
			if(result > 0){
				return new JsonResult(JsonResultCode.SUCCESS, "添加分类成功","");
			}else{
				return new JsonResult(JsonResultCode.FAILURE, "该分类失败了","");
			}
		}catch(Exception ex){
			logger.error("[SellerCategoryController][addSellerCategory] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
}
