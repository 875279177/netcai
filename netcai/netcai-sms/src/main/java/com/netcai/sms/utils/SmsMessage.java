package com.netcai.sms.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/***
 * 短信消息对象
 * 
 * @author administrator
 */
public class SmsMessage {
	/**
	 * 账号，目前就是手机号码，采用的是手机号码登陆
	 */
	private String account;

	/*
	 * 产生的验证码
	 */
	private String code;

	/**
	 * 对应的短信模板
	 */
	private String template;

	/**
	 * 用户姓名(卖家或者买家)
	 */
	private String name;

	/**
	 * 添加短信内容
	 */
	private String content;

	/**
	 * 今日订单数量
	 */
	private Integer count;

	/**
	 * 今日订单金额
	 */
	private BigDecimal amount;

	public SmsMessage() {
		super();
	}

	public SmsMessage(String account, String code, String template, String name, String content, Integer count,
			BigDecimal amount) {
		super();
		this.account = account;
		this.code = code;
		this.template = template;
		this.name = name;
		this.content = content;
		this.count = count;
		this.amount = amount.setScale(2, RoundingMode.DOWN);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount.setScale(2,RoundingMode.DOWN);
	}

	@Override
	public String toString() {
		return "{\"name\":\""+name+"\",\"code\":\""+code+"\",\"count\":\""+count+"\",\"amount\":\""+amount+"\",\"content\":\""+content+"\"}";
	}
	
}