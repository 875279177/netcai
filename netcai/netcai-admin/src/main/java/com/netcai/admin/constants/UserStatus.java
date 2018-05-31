package com.netcai.admin.constants;

/**
 * 用户状态
 * @author administrator
 */
public class UserStatus {
	/**
	 * 审核通过，可以用
	 */
	public static final int All=-2;

	/**
	 * 表示强制下架,不可用
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
