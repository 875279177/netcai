package com.netcai.admin.controller.bill;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.BillItem;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BillItemService;
import com.netcai.admin.service.BillService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BillVo;

@Controller
@RequestMapping("/admin/bill")
public class BillController extends BaseController{
	
	private static final Logger logger = Logger.getLogger(BillController.class);

	@Autowired
	private BillService billService;
	@Autowired
	private BillItemService billItemService;
	
	/**
	 * 查询卖家帐单列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("bill:query")
	public String getAll(HttpServletRequest request, HttpServletResponse response, Model model, BillVo bill) {
		logger.info("[BillController][getAll] 查询帐单列表:");
		int pageNum = this.getPageNum(request);
		int pageSize = this.getPageSize(request);
		PageUtil paginator = billService.getAll(bill, pageNum, pageSize);
		model.addAttribute("paginator", paginator);
		model.addAttribute("bill", bill);
		return "seller/bill/billList";
	}

	/**
	 * 根据卖家id查询帐单
	 */
	@ResponseBody
	@RequestMapping(value = "/getBills", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getBillsBySellerId(HttpServletRequest request, HttpServletResponse response, Long sellerId) {
		logger.info("[BillController][getBillsBySellerId] 根据卖家id查询帐单id:" + sellerId);
		try {
			if (null == sellerId) {
				return new JsonResult(JsonResultCode.FAILURE, "id为空", "");
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sellerId", sellerId);
			List<BillVo> billList = billService.getBillsBySellerId(map);
			if (CollectionUtils.isEmpty(billList)) {
				return new JsonResult(JsonResultCode.FAILURE, "根据id查询数据失败", "");
			}
			return new JsonResult(JsonResultCode.SUCCESS, "根据id查询数据成功", billList);
		} catch (Exception e) {
			logger.error("[BillController][getBillsBySellerId] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 跳转到账单详情页
	 */
	@RequestMapping(value = "/billItems", method = { RequestMethod.GET, RequestMethod.POST })
	public String getBillItems(HttpServletRequest request, HttpServletResponse response ,Long billId,Model model) {
		logger.info("[BillController][getBillItems] 查询帐单详情，账单id:" + billId);
		if(billId!=null){
			List<BillItem> billItems= billItemService.getAllByBillId(billId);
			model.addAttribute("billItems", billItems);
		}
		return "seller/bill/billItemList";
	}
	
}
