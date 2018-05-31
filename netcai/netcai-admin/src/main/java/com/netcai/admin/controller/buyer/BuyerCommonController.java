package com.netcai.admin.controller.buyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.BuyerCommon;
import com.netcai.admin.entity.BuyerCommon.GoodId;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BuyerCommonService;
import com.netcai.admin.service.BuyerService;
import com.netcai.admin.service.GoodsService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerCommonVo;
import com.netcai.admin.vo.BuyerVo;
import com.netcai.admin.vo.SearchGoodsVo;

@Controller
@RequestMapping("/admin/buyerCommon")
public class BuyerCommonController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerCommonController.class);

	@Autowired
	private BuyerCommonService buyerCommonService;
	@Autowired
	private BuyerService buyerService;
	@Autowired
	private GoodsService goodsService;
	/**
	 * 查询列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("buyerCommon:query")
	public String buyerCommonList(HttpServletRequest request, HttpServletResponse response, BuyerCommonVo buyerCommonVo, Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = buyerCommonService.getBuyerCommon(buyerCommonVo, pageNum, pageSize);
		
		model.addAttribute("buyerCommonVo", buyerCommonVo);
		
		model.addAttribute("paginator", paginator);		

		return "buyer/buyerCommonList";
	}
	
	/**
	 * 去选择买家; 
	 */
	@RequestMapping(value = "/toSelect", method = { RequestMethod.GET, RequestMethod.POST })
	public String toSelect(HttpServletRequest request, HttpServletResponse response, Model model,BuyerVo buyer) {
		
		List<BuyerVo> list = buyerService.getAll(buyer);
		
		for (Iterator<BuyerVo> iterator = list.iterator(); iterator.hasNext();) {
			BuyerVo buyerVo = (BuyerVo) iterator.next();
			if(buyerVo.getBuyerName()==null){
				iterator.remove();
			}
		}
		model.addAttribute("list", list);
		
		return "buyer/toSelect";
	}
	
	/**
	 * 到新增页面;
	 */
	@RequestMapping(value = "/toAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String toAdd(HttpServletRequest request, HttpServletResponse response, Model model,BuyerVo buyer,@ModelAttribute SearchGoodsVo sgv) {
		
		Long regionId = buyer.getRegionId();
		Long buyerId = buyer.getBuyerId();
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		
		sgv.setAreaId(regionId);
		sgv.setSearchStatus((short) 1);
		sgv.setFormatStatus((short)1);
		sgv.setSellerStatus((short)3);
		
		List<BuyerCommonVo> buyerCommonVo = buyerCommonService.getAllByBuyerId(buyerId);
		StringBuffer sb = new StringBuffer();
		
		if(buyerCommonVo.size()>0){
			for (int i = 0; i < buyerCommonVo.size(); i++) {
				if(i != buyerCommonVo.size()-1){
					BuyerCommonVo sc = buyerCommonVo.get(i);
					sb.append(sc.getGoodsId());
					sb.append(",");
				}else {
					BuyerCommonVo sc = buyerCommonVo.get(i);
					sb.append(sc.getGoodsId());
				}
			}
		}
		sgv.setGoodIds(new String(sb));
		PageUtil paginator = goodsService.getPageResultByCommon(sgv, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("sgv", sgv);
		model.addAttribute("buyer",buyer);
		return "buyer/addBuyerCommon";
	}

	/**
	 * 批量新增;
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult add(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam("goodsIds[]")List<Long> goodsIds,Long buyerId) {
		try{
			if( buyerId == null){
				return new JsonResult(JsonResultCode.FAILURE, "参数有误","");
			}if(goodsIds.size()<1){
				return new JsonResult(JsonResultCode.FAILURE, "未选取商品","");
			}
			
			List<BuyerCommon> list = new ArrayList<BuyerCommon>();
			
			for (int i = 0; i < goodsIds.size(); i++) {
				Long goodsId = goodsIds.get(i);
				BuyerCommon b = new BuyerCommon();
				b.setBuyerId(buyerId);
				b.setCreateTime(new Date());
				b.setGoodsId(goodsId);
				list.add(b);
			}
			int result = buyerCommonService.batchSave(list);
			if (result < 1) {
				return new JsonResult(JsonResultCode.FAILURE, "新增失败","");
			}
			return new JsonResult(JsonResultCode.SUCCESS, "新增成功","");
		}catch(Exception e){
			logger.error("[BuyerCommonController][add]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误","");
		}
	}
	
	/**
	 * 批量删除;
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(HttpServletRequest request, HttpServletResponse response, Model model,@RequestParam("bcIds[]")List<Long> bcIds) {
		try {
			if(bcIds.size() < 1){
				return new JsonResult(JsonResultCode.FAILURE, "参数有误,请重试!","");
			}
			int result = buyerCommonService.delete(bcIds);
			if (result < 1) {
				return new JsonResult(JsonResultCode.FAILURE, "删除失败","");
			}
			return new JsonResult(JsonResultCode.SUCCESS, "删除成功","");
		} catch (Exception e) {
			logger.error("[BuyerCommonController][delete]:");
			return new JsonResult(JsonResultCode.FAILURE, "系统错误","");
		}
	}
	
	/**
	 * 批量替换常用清单
	 */
	@RequestMapping(value = "/update/goodsId", method = { RequestMethod.GET, RequestMethod.POST })
	public void updateGoodsId(HttpServletRequest request, HttpServletResponse response, Model model,Long sellerId,Long sellerIdOld) {
		try {
			List<GoodId> goodId = buyerCommonService.getGoodsIdAndGoodsIdOld(sellerId, sellerIdOld);
			BuyerCommon buyerCommon = new BuyerCommon();
			buyerCommon.setGoodIds(goodId);
			int updateGoodsId = buyerCommonService.updateGoodsId(buyerCommon);
			logger.info("[BuyerCommonController][updateGoodsId]:"+updateGoodsId);
		} catch (Exception e) {
			logger.error("[BuyerCommonController][updateGoodsId]:"+e);
		}
	}
}
