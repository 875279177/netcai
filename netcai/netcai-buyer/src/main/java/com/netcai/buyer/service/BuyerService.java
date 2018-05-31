package com.netcai.buyer.service;

import java.util.List;

import com.netcai.buyer.entity.Buyer;
import com.netcai.buyer.entity.Users;
import com.netcai.buyer.utils.PageUtil;
import com.netcai.buyer.vo.CommonListVo;
import com.netcai.buyer.vo.DeliveryCoordinateVo;
import com.netcai.buyer.vo.MyIndexVo;

public interface BuyerService {
	
	/**
	 * 通过Id查询单个
	 * @param 
	 * @return
	 */
	public Buyer getBuyerByUserId(Long userId);

	/**
	 * 通过Id查询单个
	 * @param 
	 * @return
	 */
	public Buyer getBuyerById(Long id);
	
	/**
	 * 添加
	 * @param Buyer
	 */
	public int insertBuyer(Buyer Buyer,Users users);
	
	/**
	 * 完善买家资料
	 * @param buyer
	 */
	public void updateBuyer(Buyer buyer);
	/**
	 * 通过条件查询 
	 * @param Buyer 
	 * @return
	 */
	public PageUtil getPageResult(Buyer Buyer, int currentPageNum, int currentPageSize);
	
    /**
     * 常用清单
     */
    public List<CommonListVo> getCommonList(Long userId);
    
    /**
     * 添加收藏
     */
    public int insertBuyerCollect(Long userId,Long goodsId);
    
    /**
     * 取消收藏
     */
    public int deleteBuyerCollect(Long bcId);
    
    /**
     * 取消收藏
     */
    public int cancelBuyerCollect(Long userId,Long goodsId);
    
    /**
     * 我的收藏列表
     */
    public List<CommonListVo> getCollectList(Long userId);
    
    /**
     * 我的常用清单
     */
    public List<CommonListVo> getMyCommonList(Long userId);
    
    /**
     * 添加买家常用清单
     */
    public int insertBuyerCommon(Long buyerId,Integer buyerType,Long areaId);
    
    /**
     * 删除常用清单
     */
    public int deleteBuyerCommon(Long userId,Long goodsId);
    
    /**
     * 获取配送人员最新坐标
     */
    public DeliveryCoordinateVo getNewDeliveryCoordinate(Long userId);
    
    /**
     * 变更业务员
     */
    public void modifySales();
    
    /**
     * 我的信息
     */
    public MyIndexVo getMyIndex(Long buyerId);
}
