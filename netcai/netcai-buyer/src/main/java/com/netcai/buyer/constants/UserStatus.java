package com.netcai.buyer.constants;

/**
 * 用户状态
 * @author administrator
 */
public class UserStatus {

	/**
	 * 表示买家强制,不可用
	 * @desc 可能买家由于违反了公司的规定,公司强制禁止掉买家
	 */
	public static final int FORBIDDEN=-1;
	/**
	 * 已注册，未完善资料
	 */
	public static final int REGISTERED=0;
	/**
	 * 已完善了资料，未审核
	 */
	public static final int INCOMPLETE=1;
	
	/**
	 * 已审核，审核未通过
	 */
	public static final int AUDITFAILED=2;
	
	/**
	 * 审核通过，可以用
	 */
	public static final int AUDITED=3;
}