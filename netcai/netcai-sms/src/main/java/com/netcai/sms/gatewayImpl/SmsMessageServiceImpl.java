package com.netcai.sms.gatewayImpl;

import com.netcai.sms.gateway.SmsMessageService;
import com.netcai.sms.utils.SmsMessage;
import com.netcai.sms.utils.SmsModelIds;
import com.netcai.sms.utils.SmsUtil;

/**
 * 短信功能的实现类
 * @author administrator
 */
public class SmsMessageServiceImpl implements SmsMessageService 
{
	/**
	 * 注册时发送验证码
	 */
	@Override
	public boolean sendSms(SmsMessage smsMessage,String environment) 
	{
		smsMessage.setTemplate(SmsModelIds.IDENTIFYING_CODE_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	/**
	 * 提醒卖家备货信息
	 */
	@Override
	public boolean stockGoods(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.STOCK_GOODS_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 今日订单数量和金额信息
	 */
	@Override
	public boolean orderCountAndAmount(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.ORDER_COUNTANDAMOUNT_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 修改密码信息
	 */
	@Override
	public boolean updatePassword(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.UPDATE_PASSWORD_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 新订单提醒信息
	 */
	@Override
	public boolean newOrder(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.NEW_ORDER_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 提醒买家下单
	 */
	@Override
	public boolean remindOrder(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.REMIN_DORDER_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 给用户发送祝福
	 */
	@Override
	public boolean getUsersBenediction(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.BENEDICTION_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 *  提醒买家下单使用优惠券
	 */
	@Override
	public boolean remindUseCoupon(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.USE_COUPON_ID);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}

	/**
	 * 提醒买家缺货
	 */
	@Override
	public boolean sellerStockOut(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.SELLER_STOCK_OUT);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 提醒付款
	 */
	@Override
	public boolean remindPay(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.REMIND_PAYMENT_OUT);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}


	/**
	 *买家退货 
	 */
	@Override
	public boolean buyerReturn(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.BUYER_RETURNS);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}

	
	/**
	 * 下单提醒
	 */
	@Override
	public boolean placeOrder(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.PLACE_ORDER);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 订单送达提醒
	 */
	@Override
	public boolean orderDelivered(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.ORDER_DELIVERED);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 优惠活动提醒
	 */
	@Override
	public boolean preferentialActivities(SmsMessage smsMessage,String environment) {
		smsMessage.setTemplate(SmsModelIds.PREFERENTIAL_ACTIVITIES);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 申请提现提示
	 */
	@Override
	public boolean applicationWithdrawal(SmsMessage smsMessage, String environment) {
		smsMessage.setTemplate(SmsModelIds.APPLICATION_WITHDRAWAL);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 白沙洲直营店促销活动
	 */
	@Override
	public boolean salesPromotion(SmsMessage smsMessage, String environment) {
		smsMessage.setTemplate(SmsModelIds.SALES_PROMOTION);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 未绑定销售的新注册的买家通知销售处理
	 */
	@Override
	public boolean disposeBuyerInfo(SmsMessage smsMessage, String environment) {
		smsMessage.setTemplate(SmsModelIds.DISPOSE_BUYERINFO);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 更改买家绑定业务员
	 */
	@Override
	public boolean modifySales(SmsMessage smsMessage, String environment) {
		smsMessage.setTemplate(SmsModelIds.MODIFY_SALES);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
	/**
	 * 团购
	 */
	@Override
	public boolean groupsFinish(SmsMessage smsMessage, String environment) {
		smsMessage.setTemplate(SmsModelIds.GROUPS_FINISH);
		return SmsUtil.getInstance().sendSms(smsMessage,environment);
	}
	
}