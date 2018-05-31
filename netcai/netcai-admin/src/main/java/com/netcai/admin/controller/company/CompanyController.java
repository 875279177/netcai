package com.netcai.admin.controller.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
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
import com.netcai.admin.entity.Company;
import com.netcai.admin.result.JsonResult;
import com.netcai.admin.result.JsonResultCode;
import com.netcai.admin.service.CompanyService;

/**
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class CompanyController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	/**
	 * 修改或新增;
	 */
	@ResponseBody
	@RequestMapping(value = "/company/updateAndAdd", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult updateAndAdd(HttpServletRequest request, HttpServletResponse response, Company company) {

		try {
			if(company == null){
				return new JsonResult(JsonResultCode.FAILURE, "操作失败！", "");
			}
			
			Long result ;
			if (company.getId() == null ) {
				company.setCreateTime(new Date());
				company.setStatus(-1);
				 result = companyService.insert(company);
			} else {
				 result= (long) companyService.update(company);
			}
				if (result > 0) {
					return new JsonResult(JsonResultCode.SUCCESS, "更新成功", company);
				} 
					return new JsonResult(JsonResultCode.FAILURE, "更新失败", company);
		} catch (Exception e) {
			logger.error("[CompanyController][updateAndAdd] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping(value = "/company/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult delete(HttpServletRequest request, HttpServletResponse response, Long companyId) {

		try {
			if(companyId == null){
				return new JsonResult(JsonResultCode.FAILURE, "参数有误！", "");
			}
			
			int result = companyService.delete(companyId);
				if (result > 0) {
					return new JsonResult(JsonResultCode.SUCCESS, "删除成功", "");
				} 
					return new JsonResult(JsonResultCode.FAILURE, "删除失败", "");
		} catch (Exception e) {
			logger.error("[CompanyController][delete] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}
	
	/**
	 */
	@ResponseBody
	@RequestMapping(value = "/company/getById", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonResult getById(HttpServletRequest request, HttpServletResponse response, Long id) {

		try {
			if(id == null){
				return new JsonResult(JsonResultCode.FAILURE, "更新失败！", "");
			}
			
			Company company = companyService.getById(id);
			if (company == null) {
				return new JsonResult(JsonResultCode.FAILURE, "失败", "");
			} 
			return new JsonResult(JsonResultCode.SUCCESS, "成功", company);
		} catch (Exception e) {
			logger.error("[CompanyController][getById] id:", e);
			return new JsonResult(JsonResultCode.FAILURE, "系统异常，请稍后再试", "");
		}
	}

	/**
	 *  信息列表
	 */
	@RequestMapping(value = "/company/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("company:query")
	public String List(HttpServletRequest request, HttpServletResponse response) 
	{
		return "company/companyList";
	}
	
	/**
	 */
	@ResponseBody
	@RequestMapping(value = "/company/getList", method = { RequestMethod.GET, RequestMethod.POST })
	public Object getList(HttpServletRequest request, HttpServletResponse response) 
	{
		List<Company> all = companyService.getList();
		if (CollectionUtils.isNotEmpty(all)) {
			return new JsonResult(JsonResultCode.SUCCESS, "查询数据成功", all);
		} else {
			return new JsonResult(JsonResultCode.FAILURE, "查询数据失败", "");
		}
	}
	
	/**
	 * 商户列表 list
	 */
	@ResponseBody
	@RequestMapping(value = "/company/getJson", method = { RequestMethod.GET, RequestMethod.POST },produces={"application/json;","text/html;charset=UTF-8;"})
	public Object CompanyList(HttpServletRequest request, HttpServletResponse response,Long parentId, Model model) {
			logger.info("CompanyController.getJson");
			String list;
			try{
			List<Company> all = companyService.getList();
			list = getList(parentId,all);
			}catch(Exception e){
				logger.error("[CompanyController][getJson]:", e);
				return new JsonResult(JsonResultCode.FAILURE, "查询失败", "");
			}
			return new JsonResult(JsonResultCode.SUCCESS, "查询成功", list);
	}
	
	/**
	 * 递归查询树节点；
	 */
	public String getList(Long parentId,List<Company> list){
		
		List<Company> companys = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Long parentId2 = list.get(i).getParentId();
			if (parentId2 == parentId) {
				companys.add(list.get(i));
			}
		}
		StringBuilder nodes=new StringBuilder();
		for(Company company : companys){
			nodes.append("{ text: '");
			nodes.append(company.getName());
			nodes.append("', id: '");
			nodes.append(company.getId());
			nodes.append("'");
            if(!getList(company.getId(),list).isEmpty()){
            	nodes.append(", nodes: [");
            	nodes.append(getList(company.getId(),list));
            	nodes.append("] ");
            }
            nodes.append("},");
        }
		return nodes.toString();
	}
}