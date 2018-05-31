package com.netcai.admin.dao;

import java.math.BigDecimal;

/**
 * 卖家配送费Dao
 * @author administrator
 *
 */
public interface SellerOrderDeliveryDao {
	
	/**
	 * 根据卖家id查询今日总配送费
	 * @return
	 */
	public BigDecimal getDeliveryAmountBySellerId(Long sellerId);
	
}
