package com.netcai.admin.controller.goods;

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

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.GoodsCart;
import com.netcai.admin.service.GoodsCartService;
import com.netcai.admin.utils.PageUtil;

/**
 * 购物车 信息;
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class GoodsCartController extends BaseController {
	

	private static final Logger logger = LoggerFactory.getLogger(GoodsCartController.class);
	
	@Autowired
	private GoodsCartService goodsCartService;

	
	/**
	 * 订单评论 信息列表
	 * @param request
	 * @param response
	 * @param goodsCart 条件查询
	 * @return
	 */
	@RequestMapping(value = "/goodsCart/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("goodsCart:query")
	public String GoodsCartList(HttpServletRequest request, HttpServletResponse response,GoodsCart goodsCart,Model model) 
	{
		try{
			
		int currentPageNum = this.getPageNum(request);
		
		int currentPageSize = this.getPageSize(request);

		PageUtil paginator = goodsCartService.getPageResultList(goodsCart, currentPageNum, currentPageSize);

		model.addAttribute("paginator", paginator);
		
		model.addAttribute("goodsCart",goodsCart);
		
		}catch(Exception e){
			logger.error("[GoodsCartController][list]:", e);
            return "500";
		}
		return "goods/goodsCart/goodsCartList";
	}
}