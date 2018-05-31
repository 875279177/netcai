package com.netcai.sms.gateway;

import com.netcai.sms.utils.SmsMessage;

/**
 * 短信服务接口
 * @author administrator
 */
public interface SmsMessageService {
	
	/**
	 * 注册时发送验证码
	 * 场景： 短信验证码/注册以及找回密码
	 * @param smsMessage
	 * @return
	 */
	public boolean sendSms(SmsMessage smsMessage,String environment);
	
	/**
	 * 提醒卖家备货信息
	 * 场景：早上6点推送短信给卖家配货。
	 * @param smsMessage
	 * @return
	 */
	public boolean stockGoods(SmsMessage smsMessage,String environment);
	
	/**
	 * 今日订单数量和金额信息
	 * 场景：晚上6点推送给卖家金额与订单数
	 * @param smsMessage
	 * @return
	 */
	public boolean orderCountAndAmount(SmsMessage smsMessage,String environment);
	
	/**
	 * 修改密码信息
	 * 场景：修改密码
	 * @param smsMessage
	 * @return
	 */
	public boolean updatePassword(SmsMessage smsMessage,String environment);
	
	/**
	 * 新订单通知
	 * @param smsMessage
	 * @return
	 */
	public boolean newOrder(SmsMessage smsMessage,String environment);
	
	/**
	 * 提醒买家下单
	 * @param smsMessage
	 * @return
	 */
	public boolean remindOrder(SmsMessage smsMessage,String environment);
	
	/**
	 * 给用户发送祝福
	 * @param smsMessage
	 * @return
	 */
	public boolean getUsersBenediction(SmsMessage smsMessage,String environment);
	
	/**
	 * 提醒买家下单使用优惠券
	 * @param smsMessage
	 * @return
	 */
	public boolean remindUseCoupon(SmsMessage smsMessage,String environment);
	
	/**
	 * 缺货提醒买家
	 */
	public boolean sellerStockOut(SmsMessage smsMessage,String environment);
	
	/**
	 * 提醒付款
	 */
	public boolean remindPay(SmsMessage smsMessage,String environment);

	
	/**
	 * 买家退货
	 */
	public boolean buyerReturn(SmsMessage smsMessage,String environment);

	
	/**
	 * 下单提醒
	 */
	public boolean placeOrder(SmsMessage smsMessage,String environment);
	
	/**
	 * 订单送达提醒
	 */
	public boolean orderDelivered(SmsMessage smsMessage,String environment);
	
	/**
	 * 优惠活动提醒
	 */
	public boolean preferentialActivities(SmsMessage smsMessage,String environment);
	
	/**
	 * 申请提现提示
	 */
	public boolean applicationWithdrawal(SmsMessage smsMessage,String environment);
	
	/**
	 * 白沙洲直营店促销活动
	 */
	public boolean salesPromotion(SmsMessage smsMessage,String environment);
	
	/**
	 * 未绑定销售的新注册的买家通知销售处理
	 */
	public boolean disposeBuyerInfo(SmsMessage smsMessage,String environment);
	
	/**
	 * 更改买家绑定业务员
	 */
	public boolean modifySales(SmsMessage smsMessage,String environment);
	
	/**
	 * 团购
	 */
	public boolean groupsFinish(SmsMessage smsMessage,String environment);
}
