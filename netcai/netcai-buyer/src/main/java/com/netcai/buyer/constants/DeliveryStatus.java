package com.netcai.buyer.constants;

/**
 * 配送状态，0 表示未取货，1表示已收货,送货中，2表示已收货，已送货
 * @author administrator
 *
 */
public class DeliveryStatus {

	/**
	 * 0 表示未收货
	 */
	public static final int DELIVERY_NO_TAKE = 0;
	
	/**
	 * 1表示已收货,送货中
	 */
	public static final int DELIVERY_TAKE = 1;
	
	/**
	 * 2表示已收货，已送货
	 */
	public static final int DELIVERY_TAKE_OVER = 2;
}
