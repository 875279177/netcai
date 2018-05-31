package com.netcai.admin.controller.goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Goods;
import com.netcai.admin.entity.GoodsFormat;
import com.netcai.admin.entity.GoodsPicture;
import com.netcai.admin.entity.GoodsSeq;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.GoodsService;
import com.netcai.admin.utils.ExportExcelUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.GoodsListVo;
import com.netcai.admin.vo.GoodsVo;
import com.netcai.admin.vo.SearchGoodsVo;

import net.sf.json.JSONObject;

/**
 * 商品分类Controller
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class GoodsController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	@Autowired
	private GoodsService goodsService;

	/**
	 * 商品信息列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/goods/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("goods:query")
	public String goodsList(HttpServletRequest request, HttpServletResponse response,@ModelAttribute SearchGoodsVo sgv, Model model) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		PageUtil paginator = goodsService.getPageResult(sgv, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
        if(sgv.getType()==0){
        	sgv.setSellerId(null);
        }
		model.addAttribute("sgv", sgv);
		return "goods/goodsList";
	}
	
	/**
	 * 商品信息导出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/goods/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,SearchGoodsVo sgv) {
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = this.getPageSize(request);
		//查询需要导出的数据
		List<GoodsListVo> goodsList = goodsService.getAllGoods(sgv, currentPageNum, currentPageSize);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>();  
		//excel显示列名称
		String[] rowsName = new String[]{"分类","名称","别名","标签","品牌","顺序号"};  
		Object[] objs = null; 
		if(null !=goodsList && goodsList.size()>0){
			for(GoodsListVo gd :goodsList){
				objs = new Object[rowsName.length];  
				objs[0] = gd.getCategoryName();  
			    objs[1] = gd.getGoodsName();  
			    objs[2] = gd.getGoodsAs();  
			    objs[3] = gd.getGoodsLabel();  
			    objs[4] = gd.getGoodsBrand();  
			    objs[5] = gd.getGoodsSeq(); 
			    dataList.add(objs);  
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"商品列表", rowsName, dataList);  
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 * 添加修商品信息跳转
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/goods/addOrEdit", method = { RequestMethod.GET, RequestMethod.POST })
	public String addOrEdit(HttpServletRequest request, HttpServletResponse response,Model model,Integer goodsId,SearchGoodsVo sgv) {
		try {
			if(null != goodsId){
				Goods goods = goodsService.getGoodsById(goodsId);
				model.addAttribute("goods", goods);
			}
			model.addAttribute("sellerId", sgv.getSellerId());
			model.addAttribute("sellerName", sgv.getSellerName());
			model.addAttribute("searchStatus", sgv.getSearchStatus());
			model.addAttribute("searchName", sgv.getSearchName());
			model.addAttribute("categoryName", sgv.getCategoryName());
			model.addAttribute("pageNum", sgv.getPageNum());
			model.addAttribute("pageSize", sgv.getPageSize());
			model.addAttribute("type", sgv.getType());
		} catch (Exception e) {
			logger.error("[GoodsController][addOrEdit]: goodsId="+goodsId, e);
            return "500";
		}
		return "goods/addGoods";
	}
	
	/*
	 *添加、修改商品信息
	 */
	@RequestMapping(value = "/goods/saveOrUpdate", method = {RequestMethod.POST })
	public String saveOrUpGoods(HttpServletRequest request, HttpServletResponse response,Goods goods,SearchGoodsVo sgv,RedirectAttributes attr) {
		try {
			if(null == goods.getGoodsId()){
				//新增
				goodsService.insertGoods(goods);
			} else {
				//修改
				goodsService.updateGoods(goods,getLoginUserId(request));
			}
		} catch (Exception e) {
			logger.error("[GoodsController][saveOrUpGoods]:", e);
            return "500";
		}
        if(sgv.getType()==1){
    		attr.addAttribute("sellerId", goods.getUserId());
        }
		attr.addAttribute("sellerName", sgv.getSellerName());
		attr.addAttribute("searchStatus", sgv.getSearchStatus());
		attr.addAttribute("searchName", sgv.getSearchName());
		attr.addAttribute("categoryName", sgv.getCategoryName());
		attr.addAttribute("pageNum", sgv.getPageNum());
		attr.addAttribute("pageSize", sgv.getPageSize());
		attr.addAttribute("type", sgv.getType());
		return "redirect:/admin/goods/list";
	}
	
	/*
	 * 根据id查找商品信息
	 */
	@RequestMapping(value = "/goods/getGoodsById", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Goods getGoods(HttpServletRequest request, HttpServletResponse response,int goodsId) {
		Goods goods = goodsService.getGoodsById(goodsId);
		return goods;
	}
	
	/*
	 * 更新商品图片顺序
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/updatePictureSeq", method = { RequestMethod.GET, RequestMethod.POST })
	public Object updatePictureSeq(HttpServletRequest request, HttpServletResponse response,GoodsPicture goodsPicture) {
		try{
			int status = goodsService.updatePictureSeq(goodsPicture);
			return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", status);
		} catch (Exception e) {
			logger.error("[GoodsController][updatePictureSeq]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 搜索商品
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/search", method = { RequestMethod.GET, RequestMethod.POST })
	public Object searchGoods(HttpServletRequest request, HttpServletResponse response,GoodsVo goodsVo) {
		try{
			List<GoodsVo> goodsList = goodsService.searchGoods(goodsVo);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("rows", goodsList);
			JSONObject jsonObj = JSONObject.fromObject(map); 
			return jsonObj;
		}catch(Exception e){
			logger.error("[GoodsController][searchGoods] goodsVo:", e);
		}
		return "";
	}
	
	/**
	 * 复制商品
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/copyGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public Object copyGoods(HttpServletRequest request, HttpServletResponse response,String goodsIds,Long sellerId) {
		try{
			if(null != goodsIds && !"".equals(goodsIds)){
				String[] ids = goodsIds.split(",");
				for (int i = 0; i < ids.length; i++) {
					goodsService.copyGoods(Long.valueOf(ids[i]), sellerId,request);
				}
				return new JsonResult(JsonResultCode.SUCCESS, "复制成功", "");
			}else{
				return new JsonResult(JsonResultCode.FAILURE, "复制失败", "");
			}
		} catch (Exception e) {
			logger.error("[GoodsController][copyGoods]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 上架/下架商品
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/updateGoodsStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public Object updateGoodsStatus(HttpServletRequest request, HttpServletResponse response,String goodsIds,Short goodsStatus) {
		try{
			int result = goodsService.updateGoodsStatus(goodsIds, goodsStatus);
			if(result > 0){
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功！", result);
			} else{
				return new JsonResult(JsonResultCode.FAILURE, "更新失败！", result);
			}
		} catch (Exception e) {
			logger.error("[GoodsController][updateGoodsStatus]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 删除商品
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/deleteGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public Object deleteGoods(HttpServletRequest request, HttpServletResponse response,Long goodsId) {
		try{
			int result = goodsService.deleteGoods(goodsId,request);
			if(result == 0){
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功！", result);
			} else{
				return new JsonResult(JsonResultCode.SUCCESS, "该商品已被使用，不能删除！", result);
			}
		} catch (Exception e) {
			logger.error("[GoodsController][deleteGoods]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 删除商品规格
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/deleteGoodsFormat", method = { RequestMethod.GET, RequestMethod.POST })
	public Object deleteGoodsFormat(HttpServletRequest request, HttpServletResponse response,Long formatId) {
		try{
			int result = goodsService.deleteGoodsFormat(formatId);
			if(result == 0){
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功！", result);
			} else{
				return new JsonResult(JsonResultCode.SUCCESS, "该商品规格已被使用，不能删除！", result);
			}
		} catch (Exception e) {
			logger.error("[GoodsController][deleteGoodsFormat]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 删除商品图片
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/deleteGoodsPicture", method = { RequestMethod.GET, RequestMethod.POST })
	public Object deleteGoodsPicture(HttpServletRequest request, HttpServletResponse response,Long picId,String picUrl) {
		try{
			int result = goodsService.deleteGoodsPicture(picId, picUrl, request);
			if(result > 0){
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功！", result);
			} else{
				return new JsonResult(JsonResultCode.SUCCESS, "删除失败！", result);
			}
		} catch (Exception e) {
			logger.error("[GoodsController][deleteGoodsPicture]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 修改商品顺序
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/updateGoodsSeq", method = { RequestMethod.GET, RequestMethod.POST })
	public Object updateGoodsSeq(HttpServletRequest request, HttpServletResponse response,String seqs) {
		try{
			if(null != seqs && !"".equals(seqs)){
				List<GoodsSeq> goodsSeqList = new ArrayList<GoodsSeq>();
				String[] ids = seqs.split(",");
				for (int i = 0; i < ids.length; i++) {
					String id = ids[i];
					if(!"".equals(id)){
						String[] seq = id.split("_");
						GoodsSeq gs = new GoodsSeq();
						gs.setGoodsId(Long.valueOf(seq[0]));
						gs.setGoodsSeq(Integer.valueOf(seq[1]));
						goodsSeqList.add(gs);
					}
				}
				if(goodsSeqList.size()>0){
					goodsService.batchUpdateGoodsSeq(goodsSeqList);
				}
				return new JsonResult(JsonResultCode.SUCCESS, "调整成功", "");
			}else{
				return new JsonResult(JsonResultCode.FAILURE, "调整失败", "");
			}
		} catch (Exception e) {
			logger.error("[GoodsController][updateGoodsSeq]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 根据商家查询商品信息
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/selectBySeller", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selecGoods(HttpServletRequest request, HttpServletResponse response,Long sellerId) {
		try{
			if(null == sellerId){
				return new JsonResult(JsonResultCode.FAILURE, "参数为空", "");
			}
			List<Map<String, Object>> goodsVos= goodsService.selectGoodsByUserId(sellerId);
			return new JsonResult(JsonResultCode.SUCCESS, "查询成功！", goodsVos);
		} catch (Exception e) {
			logger.error("[GoodsController][selecGoods]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 根据商品查询规格信息
	 */
	@ResponseBody
	@RequestMapping(value = "/goods/selecGoodsFormates", method = { RequestMethod.GET, RequestMethod.POST })
	public Object selecGoodsFormates(HttpServletRequest request, HttpServletResponse response,Long goodsId) {
		try{
			if(null == goodsId){
				return new JsonResult(JsonResultCode.FAILURE, "参数为空", "");
			}
			List<GoodsFormat> goodsFormats= goodsService.getGoodsFormats(goodsId);
			return new JsonResult(JsonResultCode.SUCCESS, "查询成功！", goodsFormats);
		} catch (Exception e) {
			logger.error("[GoodsController][selecGoods]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}
