package com.netcai.admin.controller.buyer;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.BuyerReceipt;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BuyerReceiptService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.ExportExcelUtil;
import com.netcai.admin.utils.PageUtil;

/**
 */

@Controller
@RequestMapping("/admin/buyerReceipt")
public class BuyerReceiptController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerReceiptController.class);
	
	@Autowired
	private BuyerReceiptService buyerReceiptService;
	
	/**
	 *信息列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("buyerReceipt:query")
	public String list(HttpServletRequest request, HttpServletResponse response,BuyerReceipt buyerReceipt,Model model) 
	{
		try{
			
		int currentPageNum = this.getPageNum(request);
		
		int currentPageSize = this.getPageSize(request);

		PageUtil paginator = buyerReceiptService.getPageResult(buyerReceipt, currentPageNum, currentPageSize);

		model.addAttribute("paginator", paginator);
		
		model.addAttribute("buyerReceipt",buyerReceipt);
		
		}catch(Exception e){
			logger.error("[BuyerReceiptController][list]:", e);
            return "500";
		}
		return "buyer/buyerReceiptList";
	}
	
	/**
	 *修改;
	 */
	@ResponseBody
	@RequestMapping(value = "/updateHSStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult updateHSStatus(HttpServletRequest request, HttpServletResponse response,Integer status,Integer id,Model model) 
	{
		try{
			if(status == null || id == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
			int result = buyerReceiptService.updateHSStatus(status, id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		}catch(Exception e){
			logger.error("[BuyerReceiptController][updateHSStatus]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 *修改入账状态;
	 */
	@ResponseBody
	@RequestMapping(value = "/updateRZStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult updateRZStatus(HttpServletRequest request, HttpServletResponse response,Integer status,Integer id,Model model) 
	{
		try{
			if(status == null || id == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
			int result = buyerReceiptService.updateRZStatus(status, id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		}catch(Exception e){
			logger.error("[BuyerReceiptController][updateHSStatus]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 *修改;
	 */
	@ResponseBody
	@RequestMapping(value = "/updateSSAmt", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult updateSSAmt(HttpServletRequest request, HttpServletResponse response,BigDecimal ssAmt,Integer id,Model model) 
	{
		try{
			if(ssAmt == null || id == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
			int result = buyerReceiptService.updateSSAmt(ssAmt, id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		}catch(Exception e){
			logger.error("[BuyerReceiptController][updateHSStatus]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 *修改;
	 */
	@ResponseBody
	@RequestMapping(value = "/updateSKReamk", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult updateSKReamk(HttpServletRequest request, HttpServletResponse response,String skReamk,Integer id,Model model) 
	{
		try{
			if(skReamk == null || id == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
			int result = buyerReceiptService.updateSKReamk(skReamk, id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		}catch(Exception e){
			logger.error("[BuyerReceiptController][updateSKReamk]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 导出
	 */
	@RequestMapping(value = "/export", method = { RequestMethod.GET, RequestMethod.POST })
	public void exportExcel(HttpServletRequest request, HttpServletResponse response,BuyerReceipt buyerReceipt) {
		//查询需要导出的数据
		List<BuyerReceipt> list = buyerReceiptService.selectList(buyerReceipt);
		//组装导出的数据到list数组中
		List<Object[]>  dataList = new ArrayList<Object[]>(); 
		//excel显示列名称
		String[] rowsName = new String[]{"买家店铺","物流司机","销售人员","订单总金额","实收款金额","信息备注","收款时间","送货时间","核实状态","入账状态"};
		Object[] objs = null;
		
		if(null != list && list.size() > 0){
			for(BuyerReceipt oi : list){
				objs = new Object[rowsName.length];
				objs[0] = oi.getBuyerName();
				objs[1] = oi.getDeliveryName();
				objs[2] = oi.getTrueName();
				objs[3] = oi.getYsAmt();
				objs[4] = oi.getSsAmt();
				objs[5] = oi.getSkReamk();
				objs[6] = DateUtil.dateToString(oi.getSkTime());
				objs[7] = DateUtil.dateToString(oi.getReceiptDate());
				Byte hsStatus = oi.getHsStatus();
				String hs = "";
				if(null != hsStatus){
					if(hsStatus==1){
						hs = "未核实";
					}if (hsStatus==2) {
						hs = "已核实";
					}
				}
				objs[8] = hs;
				Byte rzStatus = oi.getRzStatus();
				String rz = "";
				if(null != rzStatus){
					if(rzStatus==1){
						rz = "未入账";
					}if (rzStatus==2) {
						rz = "已入账";
					}
				}
				objs[9] = rz;
				dataList.add(objs);
			}
		}
		ExportExcelUtil ex = new ExportExcelUtil(response,"线下收款列表", rowsName, dataList);
		try {
			ex.export();
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	
	/**
	 *批量	核实状态;
	 */
	@ResponseBody
	@RequestMapping(value = "/batchUpdateHSStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult batchUpdateHSStatus(HttpServletRequest request, HttpServletResponse response,@RequestParam("ids[]")List<Long> ids,Integer status) 
	{
		try{
			if(ids.size() < 1 || status == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
			int result = buyerReceiptService.batchUpdateHSStatus(ids, status);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		}catch(Exception e){
			logger.error("[BuyerReceiptController][batchUpdateHSStatus]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 *批量	已读状态;
	 */
	@ResponseBody
	@RequestMapping(value = "/batchUpdateRZStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult batchUpdateRZStatus(HttpServletRequest request, HttpServletResponse response,@RequestParam("ids[]")List<Long> ids,Integer status) 
	{
		try{
			if(ids.size() < 1 || status == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
			int result = buyerReceiptService.batchUpdateRZStatus(ids, status);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} 
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
		}catch(Exception e){
			logger.error("[BuyerReceiptController][batchUpdateRZStatus]:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
}