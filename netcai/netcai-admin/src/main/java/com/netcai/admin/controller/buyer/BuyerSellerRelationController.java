package com.netcai.admin.controller.buyer;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.netcai.admin.entity.BuyerSellerRelation;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BuyerSellerRelationService;
import com.netcai.admin.utils.PageUtil;

@Controller
@RequestMapping("/admin/buyerSellerRelation")
public class BuyerSellerRelationController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerSellerRelationController.class);

	@Autowired
	private BuyerSellerRelationService buyerSellerRelationService;
	
	/**
	 * 查询列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("buyerSellerRelation:query")
	public String BuyerSellerRelationList(HttpServletRequest request, HttpServletResponse response, BuyerSellerRelation buyerSellerRelation, Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = buyerSellerRelationService.findList(buyerSellerRelation, pageNum, pageSize);
		
		model.addAttribute("buyerSellerRelation", buyerSellerRelation);
		
		model.addAttribute("paginator", paginator);		

		return "buyer/buyerSellerRelationList";
	}
	
	/**
	 * 解绑
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(HttpServletRequest request, HttpServletResponse response, Long id) {
		try {
			if(id == null){
				return new JsonResult(JsonResultCode.FAILURE, "参数不能为空!", "");
			}
			int result = buyerSellerRelationService.deleteById(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
		} catch (Exception e) {
			logger.error("[BuyerSellerRelationController][delete] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	
	/**
	 * 绑定卖家 
	 */
	@ResponseBody
	@RequestMapping(value = "/boundSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult boundSeller(HttpServletRequest request, HttpServletResponse response,BuyerSellerRelation buyerSellerRelation) {
		try {
			Long buyerId = buyerSellerRelation.getBuyerId();
			Long sellerId = buyerSellerRelation.getSellerId();
			buyerSellerRelation.setCreateTime(new Date());
			if(sellerId == null || buyerId == null){
				return new JsonResult(JsonResultCode.FAILURE, "参数不能为空!", "");
			}
			int result = buyerSellerRelationService.insert(buyerSellerRelation);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "绑定成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "绑定失败", "");
		} catch (Exception e) {
			logger.error("[BuyerSellerRelationController][boundSeller] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}
