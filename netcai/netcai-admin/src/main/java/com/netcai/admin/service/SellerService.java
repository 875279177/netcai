package com.netcai.admin.service;

import java.math.BigDecimal;
import java.util.List;

import com.netcai.admin.entity.Seller;
import com.netcai.admin.entity.Users;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.SellerAmountTodayVo;
import com.netcai.admin.vo.SellerVo;

public interface SellerService {

	/**
	 * 通过Id查询单个
	 */
	public List<Seller> getSellerByKey(Long id);
	
	/**
	 * 添加
	 */
	public Integer insertSeller(Seller seller, Users users);

	/**
	 * 更新
	 */
	public Integer updateSeller(Seller seller, Users users);
	
	/**
	 * 更改状态;
	 */
	public Integer updateStatus( Users users);

	/**
	 * 物理删除 根据Id删除
	 */
	public int deleteSeller(Long id);
	
	/**
	 * 判断新增用户是否存在
	 */
	public Integer getByAccount(String account);

	/**
	 * 通过条件查询
	 */
	public PageUtil getPageResult(Seller seller, int currentPageNum, int currentPageSize);

	/**
	 * 通过条件查询
	 */
	public List<Seller> getResult(Seller seller, int currentPageNum, int currentPageSize);
	
	/**
	 * 查询可用的商家 (促销活动选择商家时使用)
	 */
	public List<SellerVo> searchSeller(SellerVo sellerVo);
	
	/**
	 * 根据区id查询区域下所有的卖家
	 */
	public List<SellerVo> getSellerByRegionId(Long regionId);

	/**
	 * 统计当日卖家数量
	 */
	public int getDailySellerCount();
	
	/**
	 * 查询当日入驻的卖家
	 */
	public List<Seller> getSellerByDate();
	
	/**
	 * 查询所有卖家信息
	 */
	public List<Seller> getSellers(int status);
	
	/**
	 * 根据buyerID所在区域  查询卖家信息
	 */
	public List<Seller> getSellerByBuyerId(Long buyerId,Integer sellerType);
	
	/**
	 * 根据账单更新余额
	 */
	public int updateBalanceByBill();
	
	/**
	 * 通过ID查询余额
	 */
	public BigDecimal getById(Long sellerId);
	
	/**
	 * 更新余额;
	 */
	public Integer updateBalanceMoney(Long sellerId,BigDecimal balanceMoney);
	
	/**
	 * 核对卖家余额
	 */
	public void verifySellerBalance();
	
	/**
	 * 分页查询卖家今日收益、今日订单数量、可用余额、可提现金额 
	 * @param seller
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getSellerAmountByToday(SellerAmountTodayVo seller,int pageNum,int pageSize);
}
