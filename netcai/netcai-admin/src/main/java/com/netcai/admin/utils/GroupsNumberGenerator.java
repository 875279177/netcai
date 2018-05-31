package com.netcai.admin.utils;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 生成团购标号
 * @return
 */
public class GroupsNumberGenerator {
	/**
	 * 生成团购标号
	 * @return
	 */
	public static String getGroupsNumber() {
		StringBuilder sb = new StringBuilder("HWTG");
		String time = DateUtil.dateToString(new Date(), "yyyyMMddHHmmss");
		sb.append(time);
		String randomString = RandomStringUtils.randomNumeric(4);
		sb.append(randomString);
		return sb.toString();
	}

}
