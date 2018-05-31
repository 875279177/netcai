package com.netcai.admin.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.netcai.admin.entity.OrderItem;
import com.netcai.admin.entity.ReportDay;
import com.netcai.admin.vo.OrderItemQuery;
import com.netcai.admin.vo.OrderItemVo;
import com.netcai.admin.vo.PresentOrderDetailVo;
import com.netcai.admin.vo.SellerOrderVo;
import com.netcai.admin.vo.SellerTransactionDetail;

/**
 * 订单的子项目  DAO
 * @author administrator
 */
public interface OrderItemDao {

	/**
	 * 通过Id查询单个
	 */
	public OrderItem getOrderItemById(Long id);
	
	
	/**
	 * 通过条件查询 带分页
	 */
	public List<OrderItem> getAll( @Param("o") OrderItem orderItem ,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

	/**
	 * 通过条件查询 
	 */
	public List<OrderItem> getOrderItem( @Param("o") OrderItem orderItem );
	
	/**
	 * @return 查询总数
	 */
	public int getPageCount( @Param("o")OrderItem o);
	
	/**
	 * 查询缺货和退货的子订单
	 */
	public List<OrderItem> getRedressOrderItems( @Param("o") OrderItem orderItem,@Param("statusCode")Integer statusCode,@Param("pageNum")int currentPageNum,@Param("pageSize")int currentPageSize);
	
	/**
	 * 查询缺货和退货的子订单
	 */
	public int getRedressOrderItemCount( @Param("o") OrderItem orderItem,@Param("statusCode")Integer statusCode);
	
	/**
	 * 添加
	 */
	public int insertOrderItem(OrderItem orderItem);
	
	/**
	 * 查询一周内收入前十的卖家  
	 */
	public List<Map<String, Object>> getTonTenIncomes();
	
	/**
	 * 查询一周内收入前十的卖家  
	 */
	public List<Map<String, Object>> getTopTenGoods();
	
	/**
	 * 根据卖家id查询他的所有订单
	 */
	public List<OrderItemVo> getOrderItemBySellerId(OrderItem orderItem);
	
	/**
	 * 改变商品数量
	 */
	public Integer updateGoodsNumber(@Param("goodsNumber") Double goodsNumber ,@Param("goodsAmount") BigDecimal goodsAmount,@Param("itemId") Long itemId);
	
	/**
	 * 通过orderId查询所有订单项;
	 */
	public List<OrderItem> getByOrderId(Long orderId);
	
	/**
	 * @return 查询总数
	 */
	public int getCount( @Param("o")OrderItemQuery o);
	
	/**
	 * 查询所有  最终版 
	 */
	public List<OrderItemQuery> getList( @Param("o") OrderItemQuery o ,@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);
	
	/**
	 * 查询所有  最终版 
	 */
	public List<OrderItemQuery> getListAll( @Param("o") OrderItemQuery o );
	
	/**
	 * 查询所有买家所产生订单信息;
	 */
	public ArrayList<ReportDay> getCountByAreaByTime(@Param("map")Map<String,Object> map);
	
	/**
	 *  卖家当天订单总额;
	 */
	public ArrayList<SellerOrderVo> getAmountBySellerByDate(@Param("map")Map<String,Object> map,@Param("s") SellerOrderVo s);
	
	/**
	 * 批量修改订单状态
	 */
	public int batchUpdateStatus(@Param("ids")List<Long> ids,@Param("orderStatus")Integer orderStatus);
	
	/**
	 * 根据卖家id和时间查询卖家收益详情
	 * @param sellerId
	 * @param time
	 * @return
	 */
	public List<SellerTransactionDetail> selectSellerTransactionDetails(@Param(value="sellerId")Long sellerId,@Param(value="time")String time);
	
	/**
	 * 根据卖家id和时间查询卖家营业金额
	 * @param sellerId
	 * @param time
	 * @return
	 */
	public BigDecimal selectSellerTransactionAmount(@Param(value="sellerId")Long sellerId,@Param(value="time")String time);
	
	/**
	 * 根据卖家id和订单id查询订单明细
	 * @param orderId
	 * @param sellerId
	 * @return
	 */
	public List<PresentOrderDetailVo> selectPresentOrderDetails(@Param("orderId")Long orderId,@Param("sellerId")Long sellerId);
	/**	
	 * 取消订单
	 */
	public int cancelOrderItemById(Long itemId);

	/**
	 * 取消全部订单
	 */
	public void cancelAllOrderItem(Long orderId);
	
	/**
	 * 更新子订单状态为退货完成
	 * @param itemId
	 * @return
	 */
	public int returnFinish(Long itemId);
	
	/**
	 * 根据主订单id查询缺货和退货订单
	 * @param orderId
	 * @return
	 */
	public List<OrderItem> getImproperOrderItems(Long orderId);
	
}