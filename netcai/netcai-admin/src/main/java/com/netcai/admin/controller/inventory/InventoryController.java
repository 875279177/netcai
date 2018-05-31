package com.netcai.admin.controller.inventory;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.BuyerType;
import com.netcai.admin.entity.Inventory;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BuyerTypeService;
import com.netcai.admin.service.GoodsService;
import com.netcai.admin.service.InventoryService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.InventoryVo;
import com.netcai.admin.vo.SearchGoodsVo;

@Controller
@RequestMapping("/admin/inventory")
public class InventoryController extends BaseController {
	
	private static final Logger logger = Logger.getLogger(InventoryController.class);

	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private BuyerTypeService buyerTypeService;

	/**
	 * 系统清单列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param inventory
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("inventory:query")
	public String categoryList(HttpServletRequest request, HttpServletResponse response, Model model,
			InventoryVo inventory) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = inventoryService.getAll(inventory, pageNum, pageSize);
		//获取所有的区
		List<Area> areaList = inventoryService.getRegions();
		//获取所有的餐厅类型
		List<BuyerType> buyerTypeList = buyerTypeService.getAllBuyerType();

		model.addAttribute("paginator", paginator);
		model.addAttribute("areaList", areaList);
		model.addAttribute("inventory", inventory);
		model.addAttribute("buyerTypeList", buyerTypeList);
		return "inventory/inventoryList";
	}

	/**
	 * 商品分类树
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/tree", method = { RequestMethod.GET, RequestMethod.POST })
	public Object categoryTree(HttpServletRequest request, HttpServletResponse response, Model model) {
		return inventoryService.getTreeNodes();
	}

	/**
	 * 加载添加数据弹窗页面
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/addInventory", method = { RequestMethod.GET, RequestMethod.POST })
	public String addBuyer(HttpServletRequest request, HttpServletResponse response, SearchGoodsVo goods, Model model,Long id) {
		// if(id!=null){
		// Buyer buyer = buyerService.getBuyerById(id);
		// model.addAttribute("buyer", buyer);
		// }
		//获取所有的餐厅类型
		List<BuyerType> buyerTypeList = buyerTypeService.getAllBuyerType();
		// 获取分页当前的页码
		int currentPageNum = this.getPageNum(request);
		// 获取分页的大小
		int currentPageSize = 5;
		PageUtil paginator = goodsService.getPageResult(goods, currentPageNum, currentPageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("goods", goods);
		model.addAttribute("buyerTypeList", buyerTypeList);
		return "inventory/addInventory";
	}
	
	/**
	 * 新增数据
	 * 
	 * @param request
	 * @param response
	 * @param inventoryVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult insertInventorys(HttpServletRequest request, HttpServletResponse response,InventoryVo inventoryVo) {
		try {
			List<Inventory> inventoryList = new ArrayList<Inventory>();
			if(StringUtils.isBlank(inventoryVo.getBuyerTypeIds())){
				return new JsonResult(JsonResultCode.FAILURE, "餐厅类型为空", "");
			}
			//获取餐厅类型id字符串
			String buyerTypeIds = inventoryVo.getBuyerTypeIds();
			//将拼接字符串分割
			List<Long> buyerTypeIdList = getBuyerTypeIds(buyerTypeIds);
			if(CollectionUtils.isEmpty(buyerTypeIdList)){
				return new JsonResult(JsonResultCode.FAILURE, "餐厅类型为空", "");
			}
			//获取sellerId和goodsId拼接的字符串
			String goods_seller_ids = inventoryVo.getGoodsIds();
			//将拼接字符串分割
			List<Map<String, Long>> list = getGoodsAndSellerIds(goods_seller_ids);
			if(CollectionUtils.isEmpty(list)){
				return new JsonResult(JsonResultCode.FAILURE, "餐厅类型为空", "");
			}
			Inventory inventory;
			//遍历餐厅类型id
			for(Long typeId : buyerTypeIdList){
				for(Map<String, Long> map:list){
					inventory=new Inventory();
					inventory.setRegionId(inventoryVo.getRegionId());
					inventory.setBuyerTypeId(typeId);
					inventory.setSellerId(map.get("sellerId"));
					inventory.setGoodsId(map.get("goodsId"));
					inventory.setSequence(0);
					inventory.setCreateTime(new Date());
					inventoryList.add(inventory);
				}
			}
			int result = inventoryService.batchInsert(inventoryList);	
			if(result>0){
				return new JsonResult(JsonResultCode.SUCCESS, "新增数据成功", "");
			}else {
				return new JsonResult(JsonResultCode.FAILURE, "新增数据失败", "");
			}
		} catch (Exception e) {
			logger.error("[InventoryController][insertInventorys] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	/**
	 * 删除数据
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteInventorys(HttpServletRequest request, HttpServletResponse response,Long id) {
		try {
			int result = inventoryService.delete(id);	
			if(result>0){
				return new JsonResult(JsonResultCode.SUCCESS, "删除数据成功", "");
			}else {
				return new JsonResult(JsonResultCode.FAILURE, "删除数据失败", "");
			}
		}catch (Exception e) {
			logger.error("[InventoryController][deleteInventorys] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	
	}

	/**
	 * 将拼接的字符串分割返回Long类型集合(分割一次)
	 * @param ids
	 * @param separator
	 * @return
	 */
	private List<Long> getBuyerTypeIds(String ids){
		if(StringUtils.isBlank(ids)){
			return null;
		}
		ids = ids.trim();
		List<Long> ids_list = new ArrayList<Long>();
		//判断字符串是否包含分隔符separator
		if(ids.indexOf(",")==-1){
			return null;
		}
		String[] idsArrary= ids.split(",");
		for(String id:idsArrary){
			id=id.trim();
			if(StringUtils.isBlank(id)){
				continue;
			}
			ids_list.add(Long.parseLong(id));
		}
		return ids_list;
	}
	
	/**
	 * 将拼接的字符串分割返回Long类型集合(分割两次)
	 * @param ids
	 * @param separator
	 * @return
	 */
	private List<Map<String, Long>> getGoodsAndSellerIds(String ids){
		if(StringUtils.isBlank(ids)){
			return null;
		}
		ids = ids.trim();
		List<Map<String, Long>> list = new ArrayList<Map<String, Long>>();
		//判断字符串是否包含分隔符separator
		if(ids.indexOf(";")==-1){
			return null;
		}
		String[] ids_array= ids.split(";");
		for(String id_array:ids_array){
			id_array=id_array.trim();
			if(StringUtils.isBlank(id_array)||id_array.indexOf(",")==-1){
				continue;
			}
			String[] id = id_array.split(",");
			Map<String, Long> map=new HashMap<String, Long>();
			map.put("sellerId", Long.parseLong(id[0].trim()));
			map.put("goodsId", Long.parseLong(id[1].trim()));
			list.add(map);
		}
		return list;
	}

}
