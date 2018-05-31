package com.netcai.buyer.constants;

/**
 * 卖家备货状态，0为备货中，1为备货完成,2为取消备货
 * @author administrator
 *
 */
public class SellerStatus {

	/**
	 * 0为备货中
	 */
	public static final int SELLER_PLAN = 0;
	
	/**
	 * 1为备货完成
	 */
	public static final int SELLER_PLAN_OVER = 1;
	
	/**
	 * 2为取消备货
	 */
	public static final int SELLER_PLAN_CANCEL = 2;
}
