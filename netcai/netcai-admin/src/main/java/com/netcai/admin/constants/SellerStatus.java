package com.netcai.admin.constants;

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
	
	/**
	 * 配送师傅点击缺货
	 */
	public static final int SHORTAGE = 3;
	/**
	 * 补货
	 */
	public static final int REPLENISHMENT = 4;
	/**
	 * 不补货
	 */
	public static final int NOT_REPLENISHMENT = 5;
}
