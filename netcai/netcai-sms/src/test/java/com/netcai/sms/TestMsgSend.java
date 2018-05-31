package com.netcai.sms;

import com.netcai.sms.gateway.SmsMessageService;
import com.netcai.sms.gatewayImpl.SmsMessageServiceImpl;
import com.netcai.sms.utils.SmsMessage;

public class TestMsgSend {
	
	public static void main(String[] args) {
		
		SmsMessage smsMessage = new SmsMessage();
		smsMessage.setAccount("18986208424");
		smsMessage.setName("troy");
		SmsMessageService smsService=new SmsMessageServiceImpl();
		
		//模拟生产环境
		String environment="product";
		boolean sendResult = smsService.modifySales(smsMessage, environment);
		if (!sendResult) {
			System.out.println("短信发送有误,请重试");
		} else {
			System.out.println("短信发送成功");
		}
	}
}