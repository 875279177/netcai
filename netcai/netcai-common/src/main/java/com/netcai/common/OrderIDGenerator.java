package com.netcai.common;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 提现订单号生成
 * @author administrator
 */
public class OrderIDGenerator {

	/**
	 * 提现单号
	 */
	private static final String PREFIX="TW";
	
	/**
	 * 生成订单号
	 * @return
	 */
	public static String getOrderNumber() {
		String time = DateUtil.dateToString(new Date(), "yyyyMMddHHmmss");
		String randomString = RandomStringUtils.randomNumeric(8);
		return PREFIX+time + randomString;
	}
}