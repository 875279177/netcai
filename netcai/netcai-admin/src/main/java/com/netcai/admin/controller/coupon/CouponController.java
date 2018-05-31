package com.netcai.admin.controller.coupon;

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

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Area;
import com.netcai.admin.entity.Coupon;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.AreaService;
import com.netcai.admin.service.CouponService;
import com.netcai.admin.utils.DateUtil;
import com.netcai.admin.utils.PageUtil;

/**
 * 优惠券基础配置表
 * @author administrator
 */
@Controller
@RequestMapping("/admin/coupon")
public class CouponController extends BaseController {
	
	private static final Logger logger=LoggerFactory.getLogger(CouponController.class);
	
	@Autowired
	private CouponService couponService;
	@Autowired
	private AreaService areaService;
	/**
	 * 查询列表
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("coupon:query")
	public String deliveryList(HttpServletRequest request, HttpServletResponse response, Coupon coupon,
			Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = couponService.getPageResult(coupon, pageNum, pageSize);
		
		model.addAttribute("paginator", paginator);
		
		model.addAttribute("coupon", coupon);

		return "coupon/couponList";
	}
	
	/**
	 *去新增页面
	 */
	@RequestMapping(value = "/toAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public String toAdd(HttpServletRequest request, HttpServletResponse response, 
			Model model) {
		List<Area> areas = areaService.getAllRegion();
		model.addAttribute("areas", areas);
		return "coupon/addCoupon";
	}
	
	/**
	 * 新增优惠券
	 */
	@ResponseBody
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult add(HttpServletRequest request, HttpServletResponse response, Coupon coupon,@RequestParam(value = "regionIds[]", required = false) List<Long> regionIds) {
		try {
			coupon.setStatus(0);
			coupon.setCreateTime(new Date());
			coupon.setStartTime(DateUtil.stringToDate(coupon.getCreateTimeStart()));
			coupon.setEndTime(DateUtil.stringToDate(coupon.getCreateTimeStop()));
			if(regionIds.size()<1){
				return new JsonResult(JsonResultCode.FAILURE, "参数有误！", "");
			}
			List<Coupon> list = new ArrayList<>();
			for (int i = 0; i < regionIds.size(); i++) {
				Long regionId = regionIds.get(i);
				 Coupon c = new Coupon();
				 c.setCreateTime(coupon.getCreateTime());
				 c.setType(coupon.getType());
				 c.setName(coupon.getName());
				 c.setImg(coupon.getImg());
				 c.setStartTime(coupon.getStartTime());
				 c.setEndTime(coupon.getEndTime());
				 c.setMoney(coupon.getMoney());
				 c.setStatus(coupon.getStatus());
				 c.setRemarks(coupon.getRemarks());
				 c.setFullMoney(coupon.getFullMoney());
				 c.setRegionId(regionId);
				 list.add(c);
			}
			int result = couponService.batchInsert(list);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "新增成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "新增失败", "");
			}
		} catch (Exception e) {
			logger.error("[CouponController][add] coupon:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 修改活动状态
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult updateStatus(HttpServletRequest request, HttpServletResponse response, Integer status, Integer id) {
		try {
			if(status == null || id == null){
				return new JsonResult(JsonResultCode.FAILURE, "参数有误", "");
			}
			int result = couponService.updateStatus(status,id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "更新成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "更新失败", "");
			}
		} catch (Exception e) {
			logger.error("[CouponController][updateStatus] status:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

}