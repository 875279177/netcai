package com.netcai.admin.service;

import java.util.List;
import java.util.Map;

import com.netcai.admin.entity.Buyer;
import com.netcai.admin.utils.PageUtil;
import com.netcai.admin.vo.BuyerVo;

public interface BuyerService {
	/**
	 * 分页查询买家信息
	 * 
	 * @param sales
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageUtil getAllBuyer(BuyerVo buyer,int pageNum,int pageSize);
	
	/**
	 * 查询所有的卖家信息(不分页)
	 * @return
	 */
	public List<BuyerVo> getAll(BuyerVo buyer);

	/**
	 * 根据id查询买家信息
	 * @param id
	 * @return
	 */
    public BuyerVo getBuyerById(Long id);
    
    /**
     * 新增和更新数据
     * @param sales
     * @return
     */
    public int insertAndUpdate(Buyer buyer);
    
    /**
     * 启用买家
     * @param id
     * @return
     */
    public int enabledBuyer(Long id);
    
    /**
     * 禁用买家
     * @param id
     * @return
     */
    public int disabledBuyer(Long id);
    
    /**
     * 买家审核通过
     * @param id
     * @return
     */
    public int auditThrough(Long id);
    
    /**
     * 买家审核不通过
     * @param id
     * @return
     */
    public int auditNotThrough(Long id);
    
    /**
	 * 根据区域统计买家数量
	 * @return
	 */
	public int getBuyerCount(Long regionId);
	
	/**
	 * 统计买家数量
	 * @return
	 */
	public int getDailyBuyerCount();
	
	/**
     * 查询今日入驻买家
     * @param map
     * @return
     */
    public List<BuyerVo> getBuyerByDate(Buyer buyer);
    
    /**
     * 查询销售业绩
     */
    public List<BuyerVo> getBuyerBySalesIdAndTime(Buyer buyer);
    
    /**
     * 查询昨天入驻买家
     * @param map
     * @return
     */
    public List<BuyerVo> getBuyerByDateYesterday(Buyer buyer);
    
    /**
	 * 根据时间类型（按天或者按月）统计一个周期内的的注册买家数量
	 * 
	 * @return
	 */
	public Map<String, List<Integer>> getBuyerCountByTimeType(Integer timeType);
	
	/**
     * 查询订单项最多的前十位买家
     * @return
     */
    public List<Map<String, Object>> getTopTenWidelyBuyer();
    
    /**
     * 更新买家类别 注册时间超过7天并下单
     */
    public int updateBuyerLevel(Integer buyerLevel);
    
    /**
     * 更新买家类别为4 注册时间超过7天并未下单
     */
    public int updateBuyerLevel0();
}
