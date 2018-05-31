package com.netcai.buyer.sms;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.netcai.buyer.utils.HttpClientUtil;

import net.sf.json.JSONObject;

/**
 * 短信工具
 * @author administrator
 */
@Component
public class SmsUtil {
	
	private static final Logger logger=LoggerFactory.getLogger(SmsUtil.class);
	
	@Value("#{applicationProperties['environment']}")
	private String environment;
	
	/**
	 * 默认编码的格式
	 */
	private static final String CHARSET="GBK";
	
	/**
	 * 请求的网关接口
	 */
	private static final String URL = "http://api.sms.cn/sms/";
	
	public boolean sendSms(SmsMessage smsMessage)
	{
		boolean result=true;
		
		logger.debug("[SmsUtil]当前的运行环境为："+environment);

		//开发环境就直接返回成功
		if("dev".equalsIgnoreCase(environment))
		{
			return result;
		}
		
		Map<String, String> map=new HashMap<String,String>();
		
		map.put("ac","send");
		map.put("uid","zrkj2016");
		map.put("pwd","90589c3f829ed59e905c6cf694c644cd");
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