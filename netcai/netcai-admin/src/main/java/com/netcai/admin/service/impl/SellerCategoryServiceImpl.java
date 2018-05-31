package com.netcai.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.SellerCategoryDao;
import com.netcai.admin.entity.SellerCategory;
import com.netcai.admin.service.SellerCategoryService;

/**
 * 商家分类信息serviceimpl
 * @author administrator
 */
@Service
public class SellerCategoryServiceImpl implements SellerCategoryService{
    
	@Autowired
	private SellerCategoryDao sellerCategoryDao;
	
	/**
	 * 取得商家的商品分类
	 */
	public List<SellerCategory> getSellerCategoryList(Long userId,Short level){
		return sellerCategoryDao.getSellerCategoryList(userId,level);
	}

	/**
	 * 批量新增商家分类
	 */
	public int batchInsertSellerCategory(Long userId,List<SellerCategory> scList){
		//清空商家分类
		sellerCategoryDao.deleteSellerCategory(userId);
		return sellerCategoryDao.batchInsertSellerCategory(scList);
	}
	
}
