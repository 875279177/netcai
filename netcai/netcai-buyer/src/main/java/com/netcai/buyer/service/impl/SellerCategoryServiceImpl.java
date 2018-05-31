package com.netcai.buyer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.SellerCategoryDao;
import com.netcai.buyer.entity.SellerCategory;
import com.netcai.buyer.service.SellerCategoryService;

/**
 * 卖家商品分类serviceimpl
 * @author administrator
 */
@Service
public class SellerCategoryServiceImpl implements SellerCategoryService{

	@Autowired
	private SellerCategoryDao sellerCategoryDao;
	
	/**
	 * 获取卖家的商品分类
	 */
	@Override
	public List<SellerCategory> getSellerCategoryList(SellerCategory sellerCategory) {
		return sellerCategoryDao.getSellerCategoryList(sellerCategory);
	}
}
