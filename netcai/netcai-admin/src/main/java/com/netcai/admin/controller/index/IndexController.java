package com.netcai.admin.controller.index;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Buyer;
import com.netcai.admin.entity.OrderInfo;
import com.netcai.admin.entity.Reported;
import com.netcai.admin.entity.Seller;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BuyerService;
import com.netcai.admin.service.OrderInfoService;
import com.netcai.admin.service.OrderItemService;
import com.netcai.admin.service.ReportedService;
import com.netcai.admin.service.SalesService;
import com.netcai.admin.service.SellerService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.vo.BuyerVo;

@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private OrderInfoService orderInfoService;

	@Autowired
	private OrderItemService orderItemService;

	@Autowired
	private SalesService salesService;

	@Autowired
	private BuyerService buyerService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private ReportedService reportedService;

	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(HttpServletRequest request, HttpServletResponse response, Model model, Long areaId) {

		logger.info("[IndexController][index] :查询订单统计数据");
		try {

			// 查询订单总数量和金额
			Map<String, Object> totalMap = orderInfoService.getCountAndAmount();
			int totalCount = (int) totalMap.get("count");
			BigDecimal totalAmount = (BigDecimal) totalMap.get("amount");
			if (totalAmount == null) {
				totalAmount = BigDecimal.ZERO;
			}
			// 查询今日的订单总数量和金额
			Map<String, Object> todayMap = orderInfoService.getOrderCountAndAmountByToday();
			int todayOrderCount = (int) todayMap.get("count");
			BigDecimal todayOrderAmount = (BigDecimal) todayMap.get("amount");
			if (todayOrderAmount == null) {
				todayOrderAmount = BigDecimal.ZERO;
			}

			// 查询实时的订单总数量和金额
			Map<String, Object> realTimeRevenueMap = orderInfoService.getRealTimeRevenueCount();
			int realTimeOrderCount = (int) realTimeRevenueMap.get("count");
			BigDecimal realTimeOrderAmount = (BigDecimal) realTimeRevenueMap.get("amount");
			if (realTimeOrderAmount == null) {
				realTimeOrderAmount = BigDecimal.ZERO;
			}

			// 入驻买家数量
			int totalBuyerCount = buyerService.getBuyerCount(null);
			// 当日注册买家数量
			int todayBuyercount = buyerService.getDailyBuyerCount();
			// 当日入驻卖家数量
			int todaySellerCount = sellerService.getDailySellerCount();

			model.addAttribute("totalCount", totalCount);
			model.addAttribute("totalAmount", totalAmount);
			model.addAttribute("todayOrderCount", todayOrderCount);
			model.addAttribute("todayOrderAmount", todayOrderAmount);
			model.addAttribute("totalBuyerCount", totalBuyerCount);
			model.addAttribute("todayBuyercount", todayBuyercount);
			model.addAttribute("todaySellerCount", todaySellerCount);
			model.addAttribute("realTimeOrderAmount", realTimeOrderAmount);
			model.addAttribute("realTimeOrderCount", realTimeOrderCount);

			// 查询今儿下单买家数量和空降A;
			int order_buyerCount = orderInfoService.getBuyerCountByTodayOrder();
			int newBuyerNum = orderInfoService.getBuyerNumByThatDay();
			model.addAttribute("order_buyerCount", order_buyerCount);
			model.addAttribute("newBuyerNum", newBuyerNum);
			Reported reported = new Reported();
			reported.setrSolveStatus(1);
			int count = reportedService.getCount(reported);
			model.addAttribute("count", count);
		} catch (Exception ex) {
			logger.error("[IndexController][index] :exception", ex);
		}
		return "index";
	}

	/**
	 * 根据时间统计一个周期内各个区域的订单数量
	 */
	@RequestMapping(value = "/index/getOrderNum", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getOrderNum(HttpServletRequest request, HttpServletResponse response, Integer timeType) {
		logger.info("[IndexController][getOrderNum] :根据时间类型统计各个区域的订单数量");
		// 根据时间类型统计各个区域的订单数量
		Map<String, List<Integer>> countResult = orderInfoService.getCountByTimeType(timeType);
		return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", countResult);
	}

	/**
	 * 根据时间统计一个周期内各个区域的订单金额
	 */
	@RequestMapping(value = "/index/getOrderAmount", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getOrderAmount(HttpServletRequest request, HttpServletResponse response, Model model,
			Integer timeType) {
		logger.info("[IndexController][getOrderAmount] :根据时间类型统计各个区域的订单总金额");
		// 根据时间类型统计各个区域的订单总金额
		Map<String, List<BigDecimal>> countResult = orderInfoService.getAmountByTimeType(timeType);
		return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", countResult);
	}

	/**
	 * 根据时间统计一个周期内各个区域的买家数量
	 */
	@RequestMapping(value = "/index/getBuyerCount", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getBuyerCount(HttpServletRequest request, HttpServletResponse response, Model model,
			Integer timeType) {
		logger.info("[IndexController][getBuyerCount] :根据时间类型统计各个区域的买家数量");
		// 根据时间类型统计各个区域的买家数量
		Map<String, List<Integer>> countResult = buyerService.getBuyerCountByTimeType(timeType);
		return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", countResult);
	}

	/**
	 * 查询当天订单详情 显示所有
	 */
	@RequestMapping(value = "/index/orderList", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrders(HttpServletRequest request, HttpServletResponse response, Model model,
			OrderInfo orderInfo) {
		logger.info("[IndexController][getOrders] :查询今日订单详情");
		try {
			List<OrderInfo> orderList = orderInfoService.getOrderInfoByDate(orderInfo);
			if (CollectionUtils.isEmpty(orderList)) {
				orderList = new ArrayList<OrderInfo>();
			}
			model.addAttribute("orderList", orderList);
			model.addAttribute("orderInfo", orderInfo);
		} catch (Exception ex) {
			logger.error("[IndexController][getOrders] :exception", ex);
		}
		return "stat/orderView";
	}

	/**
	 * 查询统计订单的详细信息每个买家只显示一个
	 */
	@RequestMapping(value = "/index/ordersBybuyer", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrdersByDay(HttpServletRequest request, HttpServletResponse response, Model model,
			OrderInfo orderInfo) {
		logger.info("[IndexController][getOrdersByDay] :查询今日订单详情");
		try {
			String time = orderInfo.getTime();
			if (StringUtils.isBlank(time)) {
				orderInfo.setTime(DateUtil.dateToString(new Date(), DateUtil.FMT_DATE));
			}

			Map<Long, OrderInfo> map = new HashMap<>();
			List<OrderInfo> orderList = orderInfoService.getOrderInfoByDateByBuyer(orderInfo);
			for (int i = 0; i < orderList.size(); i++) {
				OrderInfo oi = orderList.get(i);
				Long buyerId = oi.getBuyerId();
				map.put(buyerId, oi);
			}

			Buyer buyer = new Buyer();
			List<BuyerVo> buyers = buyerService.getBuyerByDateYesterday(buyer);

			for (int i = 0; i < buyers.size(); i++) {
				Long buyerId = buyers.get(i).getBuyerId();
				if (map.containsKey(buyerId)) {
					map.get(buyerId).setNewOrder(1);
				}
			}

			List<OrderInfo> list = new ArrayList<OrderInfo>(map.values());

			Collections.sort(list);

			model.addAttribute("list", list);

			model.addAttribute("map", map);

			model.addAttribute("orderInfo", orderInfo);

		} catch (Exception ex) {
			logger.error("[IndexController][getOrdersByDay] :exception", ex);
		}
		return "stat/orderBuyerView";
	}

	/**
	 * 当天订单总额
	 */
	@RequestMapping(value = "/index/todayOrders", method = { RequestMethod.GET, RequestMethod.POST })
	public String getOrdersByToday(HttpServletRequest request, HttpServletResponse response, Model model,
			OrderInfo orderInfo) {
		logger.info("[IndexController][getOrdersBySellerByDay] :查询订单详情");
		try {
			List<OrderInfo> realTimeRevenue = orderInfoService.getRealTimeRevenue(orderInfo);
			model.addAttribute("orderList", realTimeRevenue);
			model.addAttribute("orderInfo", orderInfo);
		} catch (Exception ex) {
			logger.error("[IndexController][getOrdersByToday] :exception", ex);
		}
		return "stat/orderSellerView";
	}

	/**
	 * 查询入驻买家详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index/buyers", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBuyers(HttpServletRequest request, HttpServletResponse response, Buyer buyer, Model model) {
		logger.info("[IndexController][getBuyers] :查询入驻买家详情");
		try {
			String createTime = buyer.getCreateTime();
			if (StringUtils.isBlank(createTime)) {
				buyer.setCreateTime(DateUtil.dateToString(new Date(), DateUtil.FMT_DATE));
			}
			List<BuyerVo> buyerList = buyerService.getBuyerBySalesIdAndTime(buyer);
			model.addAttribute("buyerList", buyerList);
			model.addAttribute("buyer", buyer);
		} catch (Exception ex) {
			logger.error("[IndexController][getBuyers]exception", ex);
		}
		return "stat/buyerView";
	}

	/**
	 * 查询入驻卖家详情
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/index/sellers", method = { RequestMethod.GET, RequestMethod.POST })
	public String getSellers(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getSellers] :查询今日入驻卖家详情");
		try {
			List<Seller> sellerList = sellerService.getSellerByDate();
			model.addAttribute("sellerList", sellerList);
		} catch (Exception ex) {
			logger.error("[IndexController][getSellers]exception", ex);
		}
		return "stat/sellerView";
	}

	/**
	 * 查询消费前十的买家
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/getTopTenCost", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenCost(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenIncomes] :查询收入前十的卖家");
		try {
			// 消费前十的买家
			List<Map<String, Object>> topTenBuyers = orderInfoService.getTopTenAmount();
			if (CollectionUtils.isNotEmpty(topTenBuyers)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenBuyers);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenIncomes]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询收入前十的卖家
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenIncomes", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenIncomes(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenIncomes] :查询收入前十的卖家");
		try {
			// 收入前十的卖家
			List<Map<String, Object>> topTenIncomes = orderItemService.getTonTenIncomes();
			if (CollectionUtils.isNotEmpty(topTenIncomes)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenIncomes);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenIncomes]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询销售量前十的菜品
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenGoods", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenGoods(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenGoods] :查询销售量前十的菜品");
		try {
			// 销售量前十的菜品
			List<Map<String, Object>> topTenGoods = orderItemService.getTopTenGoods();
			if (CollectionUtils.isNotEmpty(topTenGoods)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenGoods);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenGoods]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询业绩前十的销售
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenSales", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenSales(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenSales] :查询业绩前十的销售");
		try {
			// 业绩前十的销售
			List<Map<String, Object>> topTenSales = salesService.getTopTenSales();
			if (CollectionUtils.isNotEmpty(topTenSales)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenSales);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenSales]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 查询订单项前十的买家
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/index/topTenWidelyBuyers", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getTopTenWidelyBuyers(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("[IndexController][getTopTenWidelyBuyers] :查询订单项前十的买家");
		try {
			// 订单项前十的买家
			List<Map<String, Object>> topTenWidelyBuyers = buyerService.getTopTenWidelyBuyer();
			if (CollectionUtils.isNotEmpty(topTenWidelyBuyers)) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", topTenWidelyBuyers);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
			}
		} catch (Exception ex) {
			logger.error("[IndexController][getTopTenWidelyBuyers]exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

}