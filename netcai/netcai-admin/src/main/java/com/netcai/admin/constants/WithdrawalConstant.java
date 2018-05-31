package com.netcai.admin.constants;

/**
 * 提现常量
 * @author administrator
 */
public class WithdrawalConstant {
	
	//提现状态,1表示申请提现,2表示审批通过,提现进行中,3,交易完成,4为提交自动打款中,-1审批不通过.
	
	/*初始状态,申请提现*/
	public static final int APPLY_WITHDRAWAL=1;
	
	/*提现通过*/
	public static final int PASS_WITHDRAWAL=2;
	
	/*交易完成*/
	public static final int FINISH_WITHDRAWAL=3;
	
	/*提交自动打款中*/
	public static final int DURING_WITHDRAWAL=4;
	
	/*提现拒绝*/
	public static final int REJECT_WITHDRAWAL=-1;
}