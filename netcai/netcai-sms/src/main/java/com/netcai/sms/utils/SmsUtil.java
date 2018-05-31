package com.netcai.sms.utils;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.json.JSONObject;

/**
 * 短信工具
 * @author administrator
 */
public class SmsUtil {
	
	private static final Logger logger=LoggerFactory.getLogger(SmsUtil.class);
	/**
	 * 默认编码的格式
	 */
	private static final String CHARSET="GBK";
	
	/**
	 * 请求的网关接口
	 */
	private static final String URL = "http://api.sms.cn/sms/";
	
	private static SmsUtil smsUtil=new SmsUtil();
	
	private SmsUtil()
	{
		
	}
	
	public static SmsUtil getInstance()
	{
		if(smsUtil==null)
		{
			smsUtil=new SmsUtil();
		}
		return smsUtil;
	}
	
	/*
	 * 返回发送的结果
	 */
	public boolean sendSms(SmsMessage smsMessage,String environment)
	{
		boolean result=true;
		
		//测试环境就直接返回success
		if(!"product".equalsIgnoreCase(environment))
		{
			return result;
		}
		
		Map<String, String> map=new HashMap<String,String>();
		
		map.put("ac","send");
		map.put("uid","");
		map.put("pwd","");
		map.put("template",smsMessage.getTemplate());
		map.put("mobile",smsMessage.getAccount());
		map.put("content",smsMessage.toString());
		
		try
		{
			String responseContent=HttpClientUtil.getInstance().sendHttpPost(URL, map,CHARSET);
			
			logger.info("SmsUtil.sendSms.responseContent:" + responseContent);
			
			JSONObject json = JSONObject.fromObject(responseContent);
			
			logger.info("SmsUtil.sendSms.json:" + json);
			
			String stat=json.getString("stat");
			
			if(!"100".equalsIgnoreCase(stat))
			{
				result=false;
			}
			
		}catch(Exception ex)
		{
			result=false;
			logger.error("[SmsUtil][sendSms] exception:",ex);
		}
		return result;
	}
}