package com.netcai.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netcai.admin.dao.CouponDao;
import com.netcai.admin.entity.Coupon;
import com.netcai.admin.service.CouponService;
import com.netcai.admin.utils.PageUtil;

/**
 * 优惠券基础配置表service实现
 */
@Service
public class CouponServiceImpl implements CouponService{
	
	@Autowired 
	private CouponDao couponDao;

	@Override
	public int delete(Long id) {
		return couponDao.delete(id);
	}

	@Override
	public int insert(Coupon coupon) {
		return couponDao.insert(coupon);
	}

	@Override
	public PageUtil getPageResult(Coupon coupon, Integer currentPageNum, Integer currentPageSize) {
		Integer size = couponDao.getPageCount(coupon);
		Integer offset = 0;
		if (currentPageNum > 1) {
			offset = (currentPageNum - 1) * currentPageSize;
		}
		if(size<offset){
			offset = 0;
		}
		List<Coupon> result = couponDao.getAll(coupon, offset, currentPageSize);
		PageUtil paginator = new PageUtil(currentPageSize, size, currentPageNum);
		paginator.setObject(result);
		return paginator;
	}

	@Override
	public int update(Coupon coupon) {
		return couponDao.update(coupon);
	}

	@Override
	public int updateStatus(Integer status,Integer id) {
		return couponDao.updateStatus(status,id);
	}

	@Override
	public int batchInsert(List<Coupon> coupons) {
		return couponDao.batchInsert(coupons);
	}
}
