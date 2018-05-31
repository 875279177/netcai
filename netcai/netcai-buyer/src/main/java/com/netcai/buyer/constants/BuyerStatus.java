package com.netcai.buyer.constants;

/**
 * 买家状态，0待收货，1为已收货，2为换货，3为退货
 * 
 * @author administrator
 *
 */
public class BuyerStatus {

	/**
	 * 0待收货
	 */
	public static final int BUYER_WAIT_TAKE = 0;
	
	/**
	 * 1为已收货
	 */
	public static final int DELIVERY_OK_TAKE = 1;
	
	/**
	 * 2为换货
	 */
	public static final int DELIVERY_EXCHANGE = 2;
	
	/**
	 * 3为退货
	 */
	public static final int DELIVERY_QUIT = 3;
}
