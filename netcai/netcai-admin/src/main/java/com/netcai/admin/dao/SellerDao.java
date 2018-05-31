package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Seller;
import com.netcai.admin.vo.SellerAmountTodayVo;
import com.netcai.admin.vo.SellerVo;

/**
 * 商家信息DAO
 * 
 * @author administrator
 */
public interface SellerDao {

	/**
	 * 通过Id查询单个
	 */
	public List<Seller> getSellerByKey(Long id);
	
	/**
	 * 通过条件查询
	 */
	public List<Seller> getSeller(@Param(value = "s") Seller s, @Param("pageNum") int pageNum,
			@Param("pageSize") int pageSize);

	/**
	 * @return 查询总数
	 */
	public int getPageCount(@Param(value = "s") Seller s);

	/**
	 * 查询所有卖家信息
	 */
	public List<Seller> getSellers(@Param("status")int status);

	/**
	 * 根据buyerID所在区域 查询卖家信息
	 */
	public List<Seller> getSellerByBuyerId(@Param(value = "buyerId")Long buyerId,@Param(value = "sellerType")Integer sellerType);

	/**
	 * 判断新增用户是否存在
	 */
	public Integer getByAccount(String account);

	/**
	 * 添加
	 */
	public int insertSeller(Seller seller);

	/**
	 * 更新
	 */
	public int update(Seller seller);

	/**
	 * 物理删除 根据Id删除
	 */
	public int deleteSeller(Long id);

	/**
	 * 查询可用的商家 (促销活动选择商家时使用)
	 */
	public List<SellerVo> searchSeller(@Param(value = "sellerVo") SellerVo sellerVo);

	/**
	 * 查询当日入驻的卖家
	 */
	public List<Seller> getSellerByDate(Map<String, Object> map);

	/**
	 * 查询卖家每天的营业额
	 */
	public List<Map<String, Object>> getAmountByDate(Map<String, Object> map);

	/**
	 * 根据id查询卖家每天营业额明细
	 */
	public List<Map<String, Object>> getAmountDetail(Map<String, Object> map);

	/**
	 * 根据区id查询区域下所有的卖家
	 */
	public List<SellerVo> getSellerByRegionId(Long regionId);

	/**
	 * 分页查询查询卖家今日收益、今日订单数量、可用余额、可提现金额
	 * 
	 * @param seller
	 * @return
	 */
	public List<SellerAmountTodayVo> getSellerAmountByToday(
			@Param(value = "seller") SellerAmountTodayVo seller, @Param(value = "offset") int offset,
			@Param(value = "pageSize") int pageSize);
	
	/**
	 * 查询卖家今日收益、今日订单数量、可用余额、可提现金额记录数
	 * @param seller
	 * @return
	 */
	public int getSellerAmountCount(@Param(value = "seller") SellerAmountTodayVo seller);
	/**
	 * 通过ID查询余额
	 */
	public BigDecimal getById(Long sellerId);

	/**
	 * 通过ID查询余额
	 */
	public BigDecimal getBillMoneyById(Long sellerId);

	/**
	 * 改变余额;
	 */
	public Integer updateBalanceMoney(@Param("sellerId") Long sellerId, @Param("balanceMoney") BigDecimal balanceMoney);

	/**
	 * 改变余额和可提现金额;
	 */
	public int updateBalanceMoneyAndBillMoney(@Param("sellerId") Long sellerId,
			@Param("balanceMoney") BigDecimal balanceMoney, @Param("billMoney") BigDecimal billMoney);
}