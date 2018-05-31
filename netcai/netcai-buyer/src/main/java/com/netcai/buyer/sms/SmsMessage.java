package com.netcai.buyer.sms;
/***
 * 短信消息对象
 * @author administrator
 */
public class SmsMessage 
{
	/**
	 * 账号，目前就是手机号码，采用的是手机号码登陆
	 */
	private String account;
	
	/*
	 * 产生的验证码 
	 */
	private String code;
	
	/**
	 * 对应的短信模板，目前短信验证码是401730
	 */
	private String template;
	
	public SmsMessage() {
		super();
	}

	public SmsMessage(String account, String code, String template) {
		super();
		this.account = account;
		this.code = code;
		this.template = template;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "{\"username\":\""+account+"\",\"code\":\""+code+"\"}";
	}
}