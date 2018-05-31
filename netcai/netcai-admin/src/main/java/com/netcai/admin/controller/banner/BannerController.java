package com.netcai.admin.controller.banner;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Banner;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.BannerService;
import com.netcai.admin.utils.PageUtil;

@Controller
@RequestMapping("/admin/banner")
public class BannerController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(BannerController.class);

	@Autowired
	private BannerService bannerService;

	/**
	 * 分页查询销售人员列表
	 * 
	 * @param request
	 * @param response
	 * @param banner
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("banner:query")
	public String salesList(HttpServletRequest request, HttpServletResponse response, Banner banner, Model model) {
		// 获取分页当前的页码
		int pageNum = this.getPageNum(request);
		// 获取分页的大小
		int pageSize = this.getPageSize(request);

		PageUtil paginator = bannerService.getAllBanners(banner, pageNum, pageSize);

		model.addAttribute("paginator", paginator);
		
		model.addAttribute("banner", banner);

		return "banner/bannerList";
	}

	/**
	 * 根据id查询数据
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult queryBannerById(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[BannerController][queryBannerById] 根据id查询:");
		try {
			Banner banner = bannerService.getBannerById(id);
			if (banner != null) {
				return new JsonResult(JsonResultCode.SUCCESS, "查询成功", banner);
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "查询失败", "");
			}
		} catch (Exception e) {
			logger.error("[BannerController][queryBannerById] :", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}

	}

	/**
	 * 加载添加数据弹窗页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addBanner", method = { RequestMethod.GET, RequestMethod.POST })
	public String addBanner(HttpServletRequest request, HttpServletResponse response,Model model,Long id) {
		logger.info("[BannerController][queryBannerById] 根据id查询:");
		Banner banner = null;
		if(id!=null){
			banner = bannerService.getBannerById(id);
		}
		model.addAttribute("banner", banner);
		return "banner/addBanner";
	}

	/**
	 * 新增或修改销售人员信息
	 * 
	 * @param request
	 * @param response
	 * @param banner
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/insertAndUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult insertAndUpdate(HttpServletRequest request, HttpServletResponse response, Banner banner) {
		logger.info("[BannerController][insertAndUpdate] 新增和更新:");
		try {

			int result = bannerService.insertAndUpdate(banner);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "操作成功", "");
			} else {
				return new JsonResult(JsonResultCode.FAILURE, "操作失败", "");
			}
		} catch (Exception e) {
			logger.error("[BannerController][insertAndUpdate] exception", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 * 禁用
	 */
	@ResponseBody
	@RequestMapping(value = "/disabled", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult disabledBanner(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[BannerController][disabledBanner] 禁用用户:");
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "参数为空", "");
			}
			int result = bannerService.disabledBanner(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "禁用成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "禁用失败", "");
		} catch (Exception e) {
			logger.error("[SysUserController][login] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

	/**
	 * 启用
	 */
	@ResponseBody
	@RequestMapping(value = "/enabled", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult enabledBanner(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[SysUserController][enabledSysUser] 启用用户:");
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "参数为空", "");
			}
			int result = bannerService.enabledBanner(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "启用成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "启用失败", "");
		} catch (Exception e) {
			logger.error("[SysUserController][login] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult deleteBanner(HttpServletRequest request, HttpServletResponse response, Long id) {
		logger.info("[SysUserController][enabledSysUser] 启用用户:");
		try {
			if (null == id) {
				return new JsonResult(JsonResultCode.FAILURE, "参数为空", "");
			}
			int result = bannerService.delete(id);
			if (result > 0) {
				return new JsonResult(JsonResultCode.SUCCESS, "删除成功", "");
			}
			return new JsonResult(JsonResultCode.FAILURE, "删除失败", "");
		} catch (Exception e) {
			logger.error("[SysUserController][login] exception:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统故障，请联系管理员", "");
		}
	}

}
