package com.netcai.buyer.dao;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.netcai.buyer.entity.Buyer;
import com.netcai.buyer.vo.CommonListVo;
import com.netcai.buyer.vo.DeliveryCoordinateVo;
import com.netcai.buyer.vo.MyIndexVo;

/**
 * 商家Dao
 * @author mengj
 *
 */
public interface BuyerDao {
	
	/**
	 * 分页查询买家信息
	 * 
	 * @param sales
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public List<Buyer> getAllBuyer(@Param("buyer") Buyer buyer, @Param("offset") int offset,
			@Param("pageSize") int pageSize);

	/**
	 * 查询总记录数
	 * 
	 * @param saleso
	 * @return
	 */
	public int getPageCount(@Param("buyer") Buyer buyer);
	
	/**
	 * 通过userId查询单个
	 * @param 
	 * @return
	 */
	public Buyer getBuyerByUserId(Long userId);
	/**
	 * 根据id查询买家信息
	 * @param id
	 * @return
	 */
    public Buyer getBuyerById(Long id);
    
    /**
     * 新增数据
     * @param sales
     * @return
     */
    public int insertBuyer(Buyer buyer);
    
    /**
     * 更新数据
     * @param sales
     * @return
     */
    public int updateBuyer(Buyer buyer);
    
    /**
     * 常用清单
     */
    public List<CommonListVo> getCommonList(@Param("userId") Long userId);
    
    /**
     * 更新买家的余额为0
     * @param userId
     * @return
     */
    public int updateBuyerBalanceToZero(Long userId);
    
    /**
     * 更新余额;
     */
    public int updateBuyerBalance(@Param("buyerId")Long buyerId,@Param("balanceMoney")BigDecimal balanceMoney);
    
    /**
     * 添加收藏
     */
    public int insertBuyerCollect(@Param("userId") Long userId,@Param("goodsId") Long goodsId);
    
    /**
     * 取消收藏
     */
    public int deleteBuyerCollect(@Param("bcId") Long bcId);
    
    /**
     * 取消收藏
     */
    public int cancelBuyerCollect(@Param("userId") Long userId,@Param("goodsId") Long goodsId);
    
    /**
     * 我的收藏列表
     */
    public List<CommonListVo> getCollectList(@Param("userId") Long userId);
    
    /**
     * 我的常用清单
     */
    public List<CommonListVo> getMyCommonList(@Param("userId") Long userId);
    
    /**
     * 添加买家常用清单
     */
    public int insertBuyerCommon(@Param("buyerId") Long buyerId,@Param("buyerType") Integer buyerType,@Param("areaId") Long areaId);
    
    /**
     * 删除常用清单
     */
    public int deleteBuyerCommon(@Param("userId") Long userId,@Param("goodsId") Long goodsId);
    
    /**
     * 获取配送人员最新坐标
     */
    public DeliveryCoordinateVo getNewDeliveryCoordinate(@Param("userId") Long userId);
    
    /**
     * 变更业务员
     */
    public List<Buyer> modifySales();
    
    /**
     * 我的信息
     */
    public MyIndexVo getMyIndex(@Param("buyerId") Long buyerId);
}
