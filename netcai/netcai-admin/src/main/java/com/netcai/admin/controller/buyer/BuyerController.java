package com.netcai.admin.controller.buyer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.constants.BuyerLevelEnum;
import com.netcai.admin.constants.BuyerTypeEnum;
import com.netcai.admin.constants.SalesStatus;
import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Buyer;
import com.netcai.admin.entity.BuyerConfig;
import com.netcai.admin.entity.BuyerSellerRelation;
import com.netcai.admin.entity.BuyerType;
import com.netcai.admin.entity.Sales;
import com.netcai.admin.entity.Seller;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.AreaService;
import com.netcai.admin.service.BuyerConfigService;
import com.netcai.admin.service.BuyerSellerRelationService;
import com.netcai.admin.service.BuyerService;
import com.netcai.admin.service.BuyerTypeService;
import com.netcai.admin.service.DeliveryAreaService;
import com.netcai.admin.service.SalesService;
import com.netcai.admin.service.SellerService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.ExportExcelUtil;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;
import com.netcai.admin.vo.DeliveryAreaVo;

@Controller
@RequestMapping("/admin/buyer")
public class BuyerController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerController.class);

	@Autowired
	private BuyerService buyerService;
	@Autowired
	private SalesService saleService;
	@Autowired
	private BuyerTypeService buyerTypeService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private BuyerConfigService buyerConfigService;
	@Autowired
	private AreaService areaService;
	@Autowired
	private DeliveryAreaService deliveryAreaService;
	@Autowired
	private BuyerSellerRelationService buyerSellerRelationService;

	/**
	 * 查询买家列表
	 * 
	 * @param request
	 * @param response
	 * @param buyer
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("buyer:query")
	public String buyerList(HttpServletRequest request, HttpServletResponse response, BuyerVo buyer, Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = buyerService.getAllBuyer(buyer, pageNum, pageSize);
		
		//查询所有的销售人员信息
		List<Sales> sales = saleService.getListSales(SalesStatus.ON,2);
		
		//查询所有的配送区域信息
		List<DeliveryAreaVo> deliveryAreas = deliveryAreaService.selectDeliveryAreas();
		
		model.addAttribute("paginator", paginator);
		
		model.addAttribute("sales", sales);
		
		model.addAttribute("deliveryAreas", deliveryAreas);

		model.addAttribute("buyer", buyer);	
		
		return "buyer/buyerList";
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
	@RequestMapping(value = "/addBuyer", method = { RequestMethod.GET, RequestMethod.POST })
	public String addBuyer(HttpServletRequest request, HttpServletResponse response, Model model, Long id) {
		if (id != null) {
			BuyerVo buyer = buyerService.getBuyerById(id);
			model.addAttribute("buyer", buyer);
			
			if(buyer.getProvinceId()!=null){
				List<Area> cities = areaService.getAllCity(buyer.getProvinceId());
				model.addAttribute("cities", cities);
			}
			if(buyer.getCityId()!=null){
				List<Area> regions = areaService.getAllRegion(buyer.getCityId());
				model.addAttribute("regions", regions);
			}
			if(buyer.getRegionId()!=null){
				List<DeliveryAreaVo> deliveryAreas = deliveryAreaService.selectByAreaId(buyer.getRegionId());
				model.addAttribute("deliveryAreas", deliveryAreas);
			}
		}
		List<Sales> salesList = saleService.getListSales(SalesStatus.ON,2);
		List<BuyerType> buyerTypesList = buyerTypeService.getAllBuyerType();
		List<Area> provice = areaService.getAllProvince();
		model.addAttribute("salesList", salesList);
		model.addAttribute("buyerTypesList", buyerTypesList);
		model.addAttribute("provice", provice);
		return "buyer/addBuyer";
	}

	/**
	 * 买家拒看商家
	 */
	@RequestMapping(value = "/selectSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public String selectSeller(HttpServletRequest request, HttpServletResponse response, Model model, Long id) {
		List<Seller> sellers = sellerService.getSellerByBuyerId(id,null);
		List<Long> sellerIds = buyerConfigService.getAllSellerIdByBuyerId(id);

		for (int i = 0; i < sellers.size(); i++) {
			Seller seller = sellers.get(i);
			if (sellerIds.contains(seller.getSellerId())) {
				seller.setSelect(1);
			} else {
				seller.setSelect(-1);
			}
		}
		model.addAttribute("sellers", sellers);
		model.addAttribute("buyerId", id);
		return "buyer/selectSeller";
	}
	

	/**
	 * 去绑定卖家
	 */
	@RequestMapping(value = "/toBoundSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public String toBoundSeller(HttpServletRequest request, HttpServletResponse response, Model model, Long id) {
		List<Seller> sellers = sellerService.getSellerByBuyerId(id,3);
		BuyerSellerRelation buyerSellerRelation = buyerSellerRelationService.selectByBuyerId(id);
		if(buyerSellerRelation != null){
			Long sellerId = buyerSellerRelation.getSellerId();
			for (int i = 0; i < sellers.size(); i++) {
				Seller seller = sellers.get(i);
				if (sellerId.intValue() == seller.getSellerId().intValue()) {
					seller.setSelect(1);
				} else {
					seller.setSelect(-1);
				}
			}
		}
		model.addAttribute("sellers", sellers);
		model.addAttribute("buyerId", id);
		return "buyer/boundSeller";
	}

	/**
	 * 新增买家拒看商家
	 */
	@ResponseBody
	@RequestMapping(value = "/saveSeller", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult saveSeller(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "sellerIds[]", required = false) List<Long> sellerIds, Model model, Long buyerId) {
		try {
			if (buyerId == null) {
				return new JsonResult(JsonResultCode.FAILURE, "buyerId有误或sellerIds为空", "");
			}
			List<BuyerConfig> list = new ArrayList<BuyerConfig>();
			if (sellerIds != null) {
				for (int i = 0; i < sellerIds.size(); i++) {
					BuyerConfig buyerConfig = new BuyerConfig();
					buyerConfig.setBuyerId(buyerId);
					buyerConfig.setSellerId(sellerIds.get(i));
					buyerConfig.setCreateTime(new Date());
					list.add(buyerConfig);
				}
			}
			buyerConfigService.batchSave(list, buyerId);
			return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
		} catch (Exception e) {
			logger.error("[BuyerController][saveSeller]", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}

	/**
	 * 新增或修改买家信息
	 */
	@ResponseBody
	@RequestMapping(value = "/insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult insertAndUpdate(HttpServletRequest request, HttpServletResponse response, Buyer buyer) {

		try {
			int result = buyerService.insertAndUpdate(buyer);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "该账号已存在", "");
			}
		} catch (Exception e) {
			logger.error("[BuyerController][insertAndUpdate] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 启用
	 */
	@ResponseBody
	@RequestMapping(value = "/enabledBuyer", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult enabledBuyer(HttpServletRequest request, HttpServletResponse response, Long id) {

		try {
			int result = buyerService.enabledBuyer(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
			}
		} catch (Exception e) {
			logger.error("[BuyerController][enabledBuyer] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 禁用
	 */
	@ResponseBody
	@RequestMapping(value = "/disabledBuyer", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult disabledBuyer(HttpServletRequest request, HttpServletResponse response, Long id) {
		try {
			int result = buyerService.disabledBuyer(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
			}
		} catch (Exception e) {
			logger.error("[BuyerController][disabledBuyer] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 审核通过
	 */
	@ResponseBody
	@RequestMapping(value = "/auditThrough", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult auditThrough(HttpServletRequest request, HttpServletResponse response, Long id) {
		try {
			int result = buyerService.auditThrough(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
			}
		} catch (Exception e) {
			logger.error("[BuyerController][auditThrough] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 审核不通过
	 */
	@ResponseBody
	@RequestMapping(value = "/auditNotThrough", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult auditNotThrough(HttpServletRequest request, HttpServletResponse response, Long id) {
		try {
			int result = buyerService.auditNotThrough(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
			}
		} catch (Exception e) {
			logger.error("[BuyerController][auditNotThrough] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 买家信息导出
	 */
	@RequestMapping(value = "/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, BuyerVo buyer) {
		logger.error("[BuyerController][exportExcel] :买家信息开始导出");
		List<BuyerVo> buyerList = buyerService.getAll(buyer);
		// 组装导出的数据到list数组中
		List<Object[]> dataList = new ArrayList<Object[]>();
		// excel显示列名称
		String[] rowsName = new String[] { "配送区域", "餐馆名称", "餐馆地址", "老板名称", "老板手机号", "销售人员", "餐馆的类型", "客户级别", "开门时间",
				"关门时间", "最晚送达时间", "创建时间" };
		Object[] objs = null;
		if (null != buyerList && buyerList.size() > 0) {
			for (BuyerVo entity : buyerList) {
				objs = new Object[rowsName.length];
				objs[0] = entity.getDeliveryAreaName();
				objs[1] = entity.getBuyerName();
				objs[2] = entity.getBuyerAddress();
				objs[3] = entity.getBossName();
				objs[4] = entity.getBossTel();
				objs[5] = entity.getSalesName();
				objs[6] = entity.getBuyerType() == null ? "" : BuyerTypeEnum.getName(entity.getBuyerType());
				objs[7] = entity.getBuyerLevel() == null ? "" : BuyerLevelEnum.getName(entity.getBuyerLevel());
				objs[8] = entity.getOpenTime();
				objs[9] = entity.getEndTime();
				objs[10] = entity.getDeliveryTime();
				objs[11] =DateUtil.dateToString(entity.getCreateTime());
				dataList.add(objs);
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response, "买家信息列表", rowsName, dataList);
		try {
			ex.export();
			logger.error("[BuyerController][exportExcel] :买家信息导出完成");
		} catch (Exception e) {
			logger.error("[BuyerController][exportExcel] :", e);
			e.printStackTrace();
		}
	}
}
