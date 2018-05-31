package com.netcai.admin.sms;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 短信验证码
 * @author administrator
 */
public final  class SmsCode {

	/**
	 * 默认产生的验证码数目
	 */
	private static int DEFAULT_NUMBER=6;
	
	/**
	 * 产生的随机号码数目
	 * @param number
	 * @return
	 */
	public  static String createRandomCode(int number)
	{
		int num=number<=3?DEFAULT_NUMBER:number;
        return  RandomStringUtils.randomNumeric(num);
	}
}