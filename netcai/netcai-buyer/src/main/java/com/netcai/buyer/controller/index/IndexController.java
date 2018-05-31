package com.netcai.buyer.controller.index;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netcai.buyer.controller.base.BaseController;
import com.netcai.buyer.entity.Category;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.BannerService;
import com.netcai.buyer.service.CategoryService;
import com.netcai.buyer.service.SellerService;
import com.netcai.buyer.vo.BannerVo;
import com.netcai.buyer.vo.SellerVo;

/*
 *1.广告栏目
 *2.一级分类。
 *3.精选商家
 * @author administrator
 */
@RestController
@RequestMapping("/buyer")
public class IndexController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SellerService sellerService;
	
	@Autowired
	private BannerService bannerService;
	

	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult index(HttpServletRequest request, HttpServletResponse response,Model model,Long regionId)
	{
		try
		{
			model.addAttribute("category",getIndexCategory());
			model.addAttribute("topSeller",getIndexTopSeller(regionId));
			model.addAttribute("banner",getBannerIndex(regionId));
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", model);
		}catch(Exception ex)
		{
			logger.error("[IndexController][index] exception :",ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	public List<BannerVo> getBannerIndex(Long regionId)
	{
		return bannerService.getBannerByRegionId(regionId);
	}
	
	/** 获取一级分类*/
	public List<Category> getIndexCategory()
	{
		String parentId ="0";
		String level = "1";
		List<Category> categoryList = categoryService.getAllCategory(parentId,level);
		return categoryList;
	}
	
	
	//精选TOP10 商家
	public List<SellerVo> getIndexTopSeller(Long regionId)
	{
		List<SellerVo> listResult = sellerService.getTop10Seller(regionId);
		return listResult;
	}
}