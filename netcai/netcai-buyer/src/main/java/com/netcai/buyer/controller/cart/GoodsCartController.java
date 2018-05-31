package com.netcai.buyer.controller.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netcai.buyer.controller.base.BaseController;
import com.netcai.buyer.entity.GoodsCart;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.GoodsCartService;
import com.netcai.buyer.service.GoodsFormatService;
import com.netcai.buyer.vo.GoodsCartVo;
import com.netcai.buyer.vo.GoodsListVo;
import com.netcai.buyer.vo.ProductVo;

/**
 * 购物车
 * @author administrator
 */

@RestController
@RequestMapping("/buyer/goodsCart")
public class GoodsCartController extends BaseController{
	
private static final Logger logger = LoggerFactory.getLogger(GoodsCartController.class);
	
	@Autowired
	private GoodsCartService goodsCartService;
	
	@Autowired
	private GoodsFormatService goodsFormatService;

	
	/**
	 * 生成购物车;
	 * 1:先删除历史购物车;
	 * 2:新增购物车数据;
	 */
	@RequestMapping(value="/commitCart",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult commitCar(HttpServletRequest request, HttpServletResponse response,@RequestBody GoodsListVo goodsListVo) 
	{
		try
		{
			List<GoodsCart> list = goodsListVo.getList();
			
			if(null == goodsListVo.getUserId() || null == list){
				
				return new JsonResult(JsonResultCode.FAILURE, "请求参数异常", "");
			}
			
			for (int i = 0; i < list.size(); i++) {
				
				if(null ==list.get(i).getBuyerId()  || null == list.get(i).getFormatId()){
					
					return new JsonResult(JsonResultCode.FAILURE, "请求参数异常", "");
				}
			}
			
			int result = goodsCartService.commitCart(list,goodsListVo.getUserId());
			
			//更新购物车为空	则直接返回;
			if(list.size()<1){
				
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", new ArrayList<>());
			}
			
			Long buyerId = list.get(0).getBuyerId();
			
			List<GoodsCartVo> goodsCartBuyers = goodsCartService.getGoodsCartBuyerId(buyerId);
			
			if (result == list.size()) 
			{
				return new JsonResult(JsonResultCode.SUCCESS, "新增成功", goodsCartBuyers);
			} 
				return new JsonResult(JsonResultCode.SUCCESS, "有下架商品", goodsCartBuyers);
				
		}catch(Exception e){
			
			logger.error("[GoodsCartController][commitCart]",e);
			
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	/**
	 * 对单个数据进行修改 新增 删除;
	 * @param request
	 * @param response
	 * @param goodsCart
	 * @return
	 */
	@RequestMapping(value="/updateCart",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult updateCart(HttpServletRequest request, HttpServletResponse response,@RequestBody GoodsCart goodsCart) 
	{
		try
		{
			
			BigDecimal goodsNumber=goodsCart.getGoodsNumber();
			
			Long formartId=goodsCart.getFormatId();
			
			BigDecimal count = goodsFormatService.getGoodsFormatById(formartId).getFormatPrice().multiply(goodsNumber);
			
			goodsCart.setCreateTime(new Date());
			
			int result = goodsCartService.updateGoodsCart(goodsCart);
			
			if (result > 0) 
			{
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", count);
			}
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", count);
		}catch(Exception e){
			
			logger.error("[GoodsCartController][updateCart]",e);
			
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @param goodsCart
	 * @return
	 */
	@RequestMapping(value="/insertCart",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult insertCart(HttpServletRequest request, HttpServletResponse response,@RequestBody GoodsCart goodsCart) 
	{
		try
		{
			BigDecimal goodsNumber=goodsCart.getGoodsNumber();
			
			Long formartId=goodsCart.getFormatId();
			
			BigDecimal count = goodsFormatService.getGoodsFormatById(formartId).getFormatPrice().multiply(goodsNumber);
			
			goodsCart.setCreateTime(new Date());
			
			int result = goodsCartService.insertGoodsCart(goodsCart);
			
			if (result > 0) 
			{
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", count);
			} 
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", count);
		}catch(Exception e){
			
			logger.error("[GoodsCartController][insertCart]",e);
			
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	
	/**
	 * 根据cartId 删除单个购物车项;
	 * @param request
	 * @param response
	 * @param cartId
	 * @return
	 */
	@RequestMapping(value="/deleteCart",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult deleteCar(HttpServletRequest request, HttpServletResponse response, Long cartId) 
	{
		
		try
		{
			if(null == cartId){
				
				return new JsonResult(JsonResultCode.FAILURE, "请求参数异常", "");
			}
			
			int result = goodsCartService.deleteGoodsCart(cartId);
			
			if (result > 0) 
			{
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功", "");
			} else 
			{
				return new JsonResult(JsonResultCode.FAILURE, "数据已不存在", "");
				
			}
		}catch(Exception e){
			
			logger.error("[GoodsCartController][deleteCart]",e);
			
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
	}
	
	@RequestMapping(value="/showCart",method={RequestMethod.GET,RequestMethod.POST})
	public JsonResult showCart(HttpServletRequest request, HttpServletResponse response,@RequestBody GoodsListVo goodsListVo) {
		try
		{
			List<GoodsCart> list = goodsListVo.getList();
			Long buyerId = goodsListVo.getUserId();
			Long sellerId = goodsListVo.getSellerId();
				if(null == buyerId ||null == sellerId){
				
				return new JsonResult(JsonResultCode.FAILURE, "请求参数异常", "");
				}
				goodsCartService.commitCartByBuyerIdSellerId(list,buyerId, sellerId);
				
			List<ProductVo> productVos = goodsCartService.getGoodsCartListBySellerId(buyerId, sellerId);
			
			return new JsonResult(JsonResultCode.SUCCESS, "查询成功", productVos);
		}catch(Exception e){
			logger.error("[GoodsCartController][showCart]",e);
			
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试","");
		}
		}
}