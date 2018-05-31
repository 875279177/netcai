package com.netcai.buyer.controller.goods;

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
import com.netcai.buyer.service.GoodsService;
import com.netcai.buyer.vo.CategoryGoodsVo;
import com.netcai.buyer.vo.GoodsVo;

/**
 * 商品分类Controller
 * @author administrator
 */
@RestController
@RequestMapping("/buyer")
public class GoodsController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsService goodsService;
	
	/**
	 * (商家店铺)商品信息列表
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/goods/list", method = { RequestMethod.GET })
	public JsonResult goodsList(HttpServletRequest request, HttpServletResponse response,
			SellerCategory sellerCategory) {
		try {
			if (null == sellerCategory.getUserId() || 0 == sellerCategory.getUserId()) {
				return new JsonResult(JsonResultCode.FAILURE, "参数错误，请检查商户ID是否有传", "");
			}
			List<CategoryGoodsVo> cgList = goodsService.getAllGoodsByCategory(sellerCategory.getUserId(),
					sellerCategory.getCategoryId());
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", cgList);
		} catch (Exception ex) {
			logger.error("[GoodsController][goodsList] exception :", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}

	/*
	 * 根据id查找商品信息
	 */
	@RequestMapping(value = "/goods/detail", method = { RequestMethod.GET })
	public JsonResult detailGoods(HttpServletRequest request, HttpServletResponse response, int goodsId) {
		try {
			GoodsVo goods = goodsService.getGoodsById(goodsId);
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", goods);
		} catch (Exception ex) {
			logger.error("[GoodsController][detailGoods] exception :", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}

	/*
	 * 搜索店铺商品
	 */
	@RequestMapping(value = "/goods/search", method = { RequestMethod.GET })
	public JsonResult searchGoods(HttpServletRequest request, HttpServletResponse response, Long userId,
			String keyword) {
		try {
			if (null == userId || 0 == userId) {
				return new JsonResult(JsonResultCode.FAILURE, "参数错误，请检查商户ID是否有传", "");
			}
			List<GoodsVo> goodsList = goodsService.searchGoodsBySellerId(userId, keyword);
			return new JsonResult(JsonResultCode.SUCCESS, "查询信息成功", goodsList);
		} catch (Exception ex) {
			logger.error("[GoodsController][searchGoods] exception :", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}
}