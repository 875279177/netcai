package com.netcai.sms.utils;

import net.sf.json.JSONObject;


/***
 * 短信工厂
 * @author administrator
 */

public class SmsFactory {

	private static SmsFactory smsFactory=new SmsFactory();
	
	private SmsFactory()
	{
		super();
	}
	
	public static SmsFactory getInstance()
	{
		if(smsFactory==null)
		{
			smsFactory=new SmsFactory();
		}
		return smsFactory;
	}
	/**
	 * 转化称为JSON字符串
	 * @return
	 */
	public String createSmsJson(SmsMessage smsMessage)
	{
		if(smsMessage==null) return null;
		
		return JSONObject.fromObject(smsMessage).toString();
	}
}