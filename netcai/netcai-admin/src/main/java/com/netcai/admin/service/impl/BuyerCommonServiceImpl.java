package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.BuyerCommonDao;
import com.netcai.admin.entity.BuyerCommon;
import com.netcai.admin.entity.BuyerCommon.GoodId;
import com.netcai.admin.service.BuyerCommonService;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerCommonVo;

@Service
public class BuyerCommonServiceImpl implements BuyerCommonService {

	@Autowired
	private BuyerCommonDao buyerCommonDao;

	@Override
	public PageUtil getBuyerCommon(BuyerCommonVo buyerCommonVo, Integer currentPageNum, Integer currentPageSize) {
		
		Integer size = buyerCommonDao.getCount(buyerCommonVo);
		
		Integer offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<BuyerCommonVo> result = buyerCommonDao.getBuyerCommon(buyerCommonVo, offset, currentPageSize);
		
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);

		paginator.setObject(result);

		return paginator;
	}

	@Override
	public int deleteAllByBuyerId(Long buyerId) {
		return buyerCommonDao.deleteAllByBuyerId(buyerId);
	}

	@Override
	public int batchSave(List<BuyerCommon> list) {
		return buyerCommonDao.batchSave(list);
	}

	@Override
	public int delete(List<Long> bcIds) {
		return buyerCommonDao.delete(bcIds);
	}

	@Override
	public List<BuyerCommonVo> getAllByBuyerId(Long buyerId) {
		return buyerCommonDao.getAllByBuyerId(buyerId);
	}

	@Override
	public int updateGoodsId(BuyerCommon buyerCommon) {
		return buyerCommonDao.updateGoodsId(buyerCommon);
	}

	@Override
	public List<GoodId> getGoodsIdAndGoodsIdOld(Long sellerId, Long sellerIdOld) {
		return buyerCommonDao.getGoodsIdAndGoodsIdOld(sellerId, sellerIdOld);
	}
}