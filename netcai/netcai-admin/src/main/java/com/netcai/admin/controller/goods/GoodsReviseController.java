package com.netcai.admin.controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.service.GoodsReviseService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsReviseVo;

@Controller
@RequestMapping("/admin")
public class GoodsReviseController extends BaseController {

	@Autowired
	private GoodsReviseService goodsReviseService;
	
	/**
	 * 商品信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/goodsRevise/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("goodsRevise:query")
	public String goodsReviseList(HttpServletRequest request, HttpServletResponse response,@ModelAttribute GoodsReviseVo goodsRevise,Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = goodsReviseService.getAllGoodsRevise(goodsRevise, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("goodsRevise", goodsRevise);
		return "goods/goodsReviseList";
	}
}