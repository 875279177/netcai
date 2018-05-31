package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.Buyer;
import com.netcai.admin.entity.ReportDay;
import com.netcai.admin.vo.BuyerVo;

/**
 * 商家Dao
 * @author mengj
 *
 */
public interface BuyerDao {
	
	/**
	 * 分页查询买家信息
	 * 
	 * @param buyer
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<BuyerVo> getAllBuyer(@Param("buyer") BuyerVo buyer, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @param buyer
	 * @return
	 */
	public int getPageCount(@Param("buyer") BuyerVo buyer);
	
	/**
	 * 查询所有的卖家信息(不分页)
	 * @return
	 */
	public List<BuyerVo> getAll(@Param("buyer") BuyerVo buyer);
	
	/**
	 * 根据id查询买家信息
	 * @param id
	 * @return
	 */
    public BuyerVo getBuyerById(Long id);
    
    /**
     * 新增数据
     * @param buyer
     * @return
     */
    public int insertBuyer(Buyer buyer);
    
    /**
     * 更新数据
     * @param buyer
     * @return
     */
    public int updateBuyer(Buyer buyer);
    
    /**
     * 查询今日入驻买家
     * @param map
     * @return
     */
    public List<BuyerVo> getBuyerByDate(@Param("map")Map<String,Object> map,@Param("buyer")Buyer buyer);
    
    /**
     * 查询销售业绩
     */
    public List<BuyerVo> getBuyerBySalesIdAndTime(@Param("buyer")Buyer buyer);
    
    /**
     * 查询订单项最多的前十位买家
     * @return
     */
    public List<Map<String, Object>> getTopTenWidelyBuyer();
    
    /**
	 * 通过ID查询余额
	 */
	public BigDecimal getById(Long buyerId);
	
	/**
     * 更新买家余额
     * @param buyerId
     * @param balanceMoney
     * @return
     */
	public Integer updateBalanceMoney(@Param("buyerId")Long buyerId,@Param("balanceMoney")BigDecimal balanceMoney);
	
	/**
     * 查询某天入驻买家数量;分区域
     */
    public ArrayList<ReportDay> getCountByThatDay(Integer time);
    
    /**
     * 更新买家类别 注册时间超过7天并下单
     */
    public int updateBuyerLevel(@Param("buyerLevel")Integer buyerLevel);
    
    /**
     * 更新买家类别为4 注册时间超过7天并未下单
     */
    public int updateBuyerLevel0();

	/**
     * 更新余额;
     */
    public int updateBuyerBalance(@Param("buyerId")Long buyerId,@Param("balanceMoney")BigDecimal balanceMoney);
}
