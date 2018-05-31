package com.netcai.buyer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.buyer.dao.SellerDao;
import com.netcai.buyer.service.SellerService;
import com.netcai.buyer.vo.SellerVo;

@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDao sellerDao;
	
	@Override
	public List<SellerVo> getTop10Seller(Long regionId) {
		return sellerDao.getTop10Seller(regionId);
	}
	
 	/**
 	 * APP全文搜索
 	 * @return
 	 */
	@Override
    public List<SellerVo> searchSeller(Long regionId,String keyword){
    	return sellerDao.searchSeller(regionId,keyword);
    }

	@Override
	public List<SellerVo> getCommonSeller(Long userId) {
		return sellerDao.getCommonSeller(userId);
	}
	
    /**
     * 根据分类查找商家
     */
	@Override
    public List<SellerVo> searchSellerByCategory(String categoryCode){
    	return sellerDao.searchSellerByCategory(categoryCode);
    }

	@Override
	public SellerVo getBySellerId(Long sellerId) {
		return sellerDao.getBySellerId(sellerId);
	}
}