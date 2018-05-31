package com.netcai.admin.controller.category;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.netcai.admin.controller.base.BaseController;
import com.netcai.admin.entity.Category;
import com.netcai.admin.service.CategoryService;

/**
 * 商品分类Controller
 * @author administrator
 */
@Controller
@RequestMapping("/admin")
public class CategoryController extends BaseController{

	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 商品分类列表
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/category/list", method = { RequestMethod.GET, RequestMethod.POST })
	@RequiresPermissions("category:query")
	public String categoryList(HttpServletRequest request, HttpServletResponse response,Model model) {
		return "category/categoryList";
	}
	
	/**
	 * 商品分类树
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/category/tree", method = { RequestMethod.GET, RequestMethod.POST })
	public Object categoryTree(HttpServletRequest request, HttpServletResponse response,Model model) {
		List<Category> categoryList = categoryService.getAllCategory();
		return categoryService.categoryTree(categoryList, 0);
	}
	
	/*
	 *添加、修改商品分类
	 */
	@RequestMapping(value = "/category/saveOrUpdate", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Category saveOrUpUnit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute Category category) {
		try {
			if(null == category.getCategoryId()){
				//新增
				categoryService.insertCategory(category);
			} else {
				//修改
				categoryService.updateCategory(category);
			}
			return category;
		} catch (Exception e) {
			return null;
		}
	}
	
	/*
	 * 根据id查找商品分类
	 */
	@RequestMapping(value = "/category/getCategoryById", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Category getCategory(HttpServletRequest request, HttpServletResponse response,int categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return category;
	}
}
