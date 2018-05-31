package com.netcai.buyer.controller.coupon;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netcai.buyer.constants.UserStatus;
import com.netcai.buyer.controller.base.BaseController;
import com.netcai.buyer.entity.Coupon;
import com.netcai.buyer.entity.CouponReceive;
import com.netcai.buyer.entity.Users;
import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.CouponReceiveService;
import com.netcai.buyer.service.UsersService;

/**
 * 优惠券controller
 * @author administrator
 *
 */
@RestController
@RequestMapping("/buyer/coupon")
public class CouponController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(CouponController.class);

	@Autowired
	private CouponReceiveService couponReceiveService;

	@Autowired
	private UsersService usersService;

	/**
	 * 查询买家所有优惠券
	 * 
	 * @param request
	 * @param response
	 * @param buyerId
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getCouponList(HttpServletRequest request, HttpServletResponse response, Long buyerId) {
		try {
			if (buyerId == null) {
				return new JsonResult(JsonResultCode.FAILURE, "买家不存在", "");
			}
			List<CouponReceive> result = couponReceiveService.selectAllByBuyerId(buyerId);
			return new JsonResult(JsonResultCode.SUCCESS, "查询成功", result);
		} catch (Exception ex) {
			logger.error("[CouponController][getCouponList] exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}

	/**
	 * 判断买家是否可以领取优惠券
	 * 
	 * @param request
	 * @param response
	 * @param buyerId
	 * @return
	 */
	@RequestMapping(value = "/judge", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult judgeReceive(HttpServletRequest request, HttpServletResponse response, Long buyerId) {
		try {
			// 判断当前用户是否可用
			Users users = usersService.getUsersById(buyerId);
			if (users == null) {
				logger.info("OrderController.judgeReceive.buyerId " + buyerId);
				return new JsonResult(JsonResultCode.FAILURE, "你的账号有误，请重新登录", "");
			}
			int status = users.getStatus();
			if (UserStatus.FORBIDDEN == status) {
				return new JsonResult(JsonResultCode.FAILURE, "你的账号已经被禁用了,请联系公司客服", "");
			}
			List<Coupon> result = couponReceiveService.selectByBuyerId(buyerId);
			if (CollectionUtils.isEmpty(result)) {
				result = new ArrayList<Coupon>();
			}
			return new JsonResult(JsonResultCode.SUCCESS, "查询成功", result);
		} catch (Exception ex) {
			logger.error("[CouponController][judgeReceive] exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}

	/**
	 * 买家领取优惠券
	 * 
	 * @param request
	 * @param response
	 * @param buyerId
	 * @return
	 */
	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult saveCoupon(HttpServletRequest request, HttpServletResponse response, Long buyerId,
			Long couponId) {
		try {
			// 判断当前用户是否可用
			Users users = usersService.getUsersById(buyerId);
			if (users == null) {
				logger.info("OrderController.saveCoupon.buyerId " + buyerId);
				return new JsonResult(JsonResultCode.FAILURE, "你的账号有误，请重新登录", "");
			}
			//判断当前用户的状态是否可用
			int status = users.getStatus();
			if (UserStatus.FORBIDDEN == status) {
				return new JsonResult(JsonResultCode.FAILURE, "你的账号已经被禁用了,请联系公司客服", "");
			}
			if (couponId == null) {
				return new JsonResult(JsonResultCode.SUCCESS, "活动已经结束", "");
			}
			//新增
			int result = couponReceiveService.insert(buyerId, couponId);
			if (result == -1) {
				return new JsonResult(JsonResultCode.SUCCESS, "领取失败,已经领取过优惠券了", "");
			} else if (result == 0) {
				return new JsonResult(JsonResultCode.FAILURE, "领取失败,活动已经结束", "");
			} else {
				return new JsonResult(JsonResultCode.SUCCESS, "领取成功", "");
			}
		} catch (Exception ex) {
			logger.error("[CouponController][saveCoupon] exception", ex);
			return new JsonResult(JsonResultCode.FAILURE, "系统错误,请稍后重试", "");
		}
	}
}
