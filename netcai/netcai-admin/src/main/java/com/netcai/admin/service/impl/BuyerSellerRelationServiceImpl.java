package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerSellerRelationDao;
import com.netcai.admin.entity.BuyerSellerRelation;
import com.netcai.admin.service.BuyerSellerRelationService;
import com.netcai.admin.utils.PageUtil;

/**
 */
@Service
public class BuyerSellerRelationServiceImpl implements BuyerSellerRelationService{

	@Autowired
	private BuyerSellerRelationDao buyerSellerRelationDao;

	@Override
	public int deleteById(Long id) {
		return buyerSellerRelationDao.deleteById(id);
	}

	@Override
	public int insert(BuyerSellerRelation record) {
		return buyerSellerRelationDao.insert(record);
	}

	@Override
	public BuyerSellerRelation selectByBuyerId(Long id) {
		return buyerSellerRelationDao.selectByBuyerId(id);
	}

	@Override
	public PageUtil findList(BuyerSellerRelation buyerSellerRelation, Integer pageNum, Integer pageSize) {
		int size = buyerSellerRelationDao.findCount(buyerSellerRelation);
		int offset = 0;
		if (pageNum > 1) {
			offset = (pageNum - 1) * pageSize;
		}
		if (size < offset) {
			offset = 0;
		}
		List<BuyerSellerRelation> result = buyerSellerRelationDao.findList(buyerSellerRelation, offset, pageSize);
		PageUtil paginator = new PageUtil(pageSize, size, pageNum);
		paginator.setObject(result);
		return paginator;
	}

	@Override
	public int updateById(BuyerSellerRelation buyerSellerRelation) {
		return buyerSellerRelationDao.updateById(buyerSellerRelation);
	}
}
