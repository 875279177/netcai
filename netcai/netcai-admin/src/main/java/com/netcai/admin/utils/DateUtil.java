package com.netcai.admin.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类,包括日期类型与字符串的转换，时间的计算等
 */
public class DateUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

	public final static int WEEKCOUNT = 7;
	/**
	 * 日期时间格式 yyyy-MM-dd HH:mm:ss
	 */
	public final static String FMT_DATETIME = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 日期时间格式 yyyy-MM-dd HH:mm
	 */
	public final static String FMT_YMD_HM = "yyyy-MM-dd HH:mm";

	/**
	 * 日期时间格式yyyyMMddHHmmss
	 */
	public static String FMT_DATETIME_COMPACT = "yyyyMMddHHmmss";

	/**
	 * 日期时间格式 yyyy-MM-dd HH:mm
	 */
	public final static String FMT_YMD_HM_COMPACT = "yyyyMMddHHmm";

	/**
	 * 日期格式yyyy-MM-dd
	 */
	public static String FMT_DATE = "yyyy-MM-dd";

	/**
	 * 日期格式yyyyMMdd
	 */
	public static String FMT_DATE_COMPACT = "yyyyMMdd";

	/**
	 * 时间格式 HH:mm:ss
	 */
	public static String FMT_TIME = "HH:mm:ss";

	/**
	 * 时间格式HHmmss
	 */
	public static String FMT_TIME_COMPACT = "HHmmss";

	/**
	 * 毫秒级时间格式HH:mm:ss:SSS
	 */
	public static String FMT_MILLITIME = "HH:mm:ss:SSS";

	/**
	 * 毫秒级时间格式HHmmssSSS
	 */
	public static String FMT_MILLITIME_COMPACT = "HHmmssSS";

	/**
	 * 毫秒级日期时间格式yyyy-MM-dd HH:mm:ss:SSS
	 */
	public static String FMT_MILLITDATETIME = "yyyy-MM-dd HH:mm:ss:SSS";

	/**
	 * 毫秒级日期时间格式yyyyMMddHHmmssSS
	 */
	public static String FMT_MILLITDATETIME_COMPACT = "yyyyMMddHHmmssSSS";

	/**
	 * 订单统计开始时间
	 */
	public static final String TRADING_START = " 10:00:00";
	/**
	 * 订单统计结束时间
	 */
	public static final String TRADING_END = " 06:00:00";
	/**
	 * 一天的开始时间
	 */
	public static final String NOMAL_START = " 00:00:00";
	/**
	 * 一天的结束时间
	 */
	public static final String NOMAL_END = " 24:00:00";
	/**
	 * 时间类型(天）
	 */
	public static final int DATE_TYPE_DAY = 0;
	/**
	 * 时间类型(月）
	 */
	public static final int DATE_TYPE_MONTH = 1;
	/**
	 * 正常时间类型
	 */
	public static final String NORMAL_TIME_TYPE = "normal";
	/**
	 * 交易时间类型
	 */
	public static final String TRADE_TIME_TYPE = "trade";

	/**
	 * 获取当前日期
	 * 
	 * @return Date类型
	 */
	public static Date getCurrentDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 获取格式化的当前日期时间。
	 * 
	 * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD HH:MM:SS
	 */
	public static String getCurrentDateTimeStr() {
		return getCurrentDateTimeStr(FMT_DATETIME);
	}

	/**
	 * 获取格式化的一个月前的日期时间。
	 * 
	 * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD
	 */
	public static String getOneMonthDateTimeStr() {
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1); // 得到前一个月

		return adf.format(calendar.getTime());
	}

	/**
	 * 获取格式化的n天前的日期时间。
	 * 
	 * @return 格式化后的当前日期时间，日期时间格式为：YYYY-MM-DD
	 */
	public static String getNDayDateTimeStr(int n) {
		SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -n); // 得到前N天的日期
		return adf.format(calendar.getTime());
	}

	/**
	 * 格式化当前日期时间。
	 * 
	 * @param pattern
	 *            日期格式
	 * @return 格式化后的当前日期时间
	 */
	public static String getCurrentDateTimeStr(String pattern) {
		return dateToString(Calendar.getInstance().getTime(), pattern);
	}

	/**
	 * 获取两个时间的时间差
	 * 
	 * @param pattern
	 */
	public static long getMillisecondDifference(Date start, Date end) {
		SimpleDateFormat sdf = new SimpleDateFormat(FMT_DATETIME_COMPACT);
		// 得到毫秒数
		long timeStart = 0;
		long timeEnd = 0;
		try {
			timeStart = sdf.parse(dateToString(start, FMT_DATETIME_COMPACT)).getTime();
			timeEnd = sdf.parse(dateToString(end, FMT_DATETIME_COMPACT)).getTime();
		} catch (ParseException e) {
			logger.error(e.getMessage());
		}
		return (timeEnd - timeStart);

	}

	/**
	 * 获取两个时间的天数之差，《=n天算n天
	 */
	public static int getDateDaysInterval(Date start, Date end) {
		long interval = getMillisecondDifference(start, end);
		return (int) (interval / (1000 * 60 * 60 * 24));
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param parttern
	 *            日期格式
	 * @return 日期字符串 yyyy-MM-dd HH:mm:ss
	 */
	public static String dateToString(Date date) {
		return dateToString(date, FMT_DATETIME);
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param parttern
	 *            日期格式
	 * @return 日期字符串
	 */
	public static String dateToString(Date date, String parttern) {
		String dateString = null;
		if (date != null && StringUtils.isNotBlank(parttern)) {
			try {
				dateString = getDateFormat(parttern).format(date);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return dateString;
	}

	/**
	 * 将日期字符串(yyyy-MM-dd HH:mm:ss)转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期
	 */
	public static Date stringToDate(String date) {
		return stringToDate(date, FMT_DATETIME);
	}

	/**
	 * 将字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param parttern
	 *            日期格式
	 * @return 日期
	 */
	public static Date stringToDate(String date, String parttern) {
		Date myDate = null;
		if (date != null && StringUtils.isNotBlank(parttern)) {
			try {
				myDate = getDateFormat(parttern).parse(date);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return myDate;
	}

	/**
	 * 将GMT时间格式字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param parttern
	 *            日期格式
	 * @return 日期
	 */
	public static Date stringToDateByGMT(String date) {
		Date myDate = null;
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
				myDate = sdf.parse(date);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return myDate;
	}

	/**
	 * 增加日期的年份。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负数
	 * @return 增加年份后的日期
	 */
	public static Date addYear(Date date, int yearAmount) {
		return addDate(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * 判断两个时间是否是同一天
	 */
	public static boolean isSameDay(Date date1, Date date2) {
		return DateUtils.isSameDay(date1, date2);
	}

	/**
	 * 获取两个时间段内的每一天
	 * 
	 * @param startTime="yyyy-mm-dd"
	 * @return List<Date>
	 */
	public static List<Date> getEveryDayBetweenStartAndEnd(String startTime, String endTime) {
		List<Date> dateList = new ArrayList<Date>();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date start = sdf.parse(startTime);
			Date end = sdf.parse(endTime);
			if (start.after(end)) {
				return dateList;
			}
			dateList.add(start);
			Calendar calBegin = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calBegin.setTime(start);
			Calendar calEnd = Calendar.getInstance();
			// 使用给定的 Date 设置此 Calendar 的时间
			calEnd.setTime(end);
			// 测试此日期是否在指定日期之后
			while (end.after(calBegin.getTime())) {
				// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
				calBegin.add(Calendar.DAY_OF_MONTH, 1);
				dateList.add(calBegin.getTime());
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}

		return dateList;
	}

	/**
	 * 获取两个时间段内的每一天
	 * 
	 * @param startTime="yyyy-mm-dd"
	 * @return List<String> 返回的日期格式为 01.01
	 */
	public static List<String> getEveryDayStrBetweenStartAndEnd(String startTime, String endTime) {
		List<String> dateStrList = new ArrayList<String>();
		List<Date> dateList = getEveryDayBetweenStartAndEnd(startTime, endTime);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 返回的日期格式为 01.01
		for (Date date : dateList) {
			dateStrList.add(sdf.format(date).substring(5, 7) + "." + sdf.format(date).substring(8, 10));
		}
		return dateStrList;
	}

	/**
	 * 增加日期的月份。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param yearAmount
	 *            增加数量。可为负数
	 * @return 增加月份后的日期
	 */
	public static Date addMonth(Date date, int yearAmount) {
		return addDate(date, Calendar.MONTH, yearAmount);
	}

	/**
	 * 增加日期的天数。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加天数后的日期
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addDate(date, Calendar.DATE, dayAmount);
	}

	/**
	 * 增加日期的小时。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加小时后的日期
	 */
	public static Date addHour(Date date, int hourAmount) {
		return addDate(date, Calendar.HOUR_OF_DAY, hourAmount);
	}

	/**
	 * 增加日期的分钟。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加分钟后的日期
	 */
	public static Date addMinute(Date date, int hourAmount) {
		return addDate(date, Calendar.MINUTE, hourAmount);
	}

	/**
	 * 增加日期的秒钟。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加秒钟后的日期
	 */
	public static Date addSecond(Date date, int hourAmount) {
		return addDate(date, Calendar.SECOND, hourAmount);
	}

	/**
	 * 获取日期的年份。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 年份
	 */
	public static int getYear(Date date) {
		return getInteger(date, Calendar.YEAR);
	}

	/**
	 * 获取日期的月份。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 月份
	 */
	public static int getMonth(Date date) {
		return getInteger(date, Calendar.MONTH) + 1;
	}

	/**
	 * 获取日期的天数。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 天
	 */
	public static int getDay(Date date) {
		return getInteger(date, Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取日期的小时。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 小时数 (24小时制)
	 */
	public static int getHour(Date date) {
		return getInteger(date, Calendar.HOUR_OF_DAY);
	}

	/**
	 * 获取日期的分钟。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 分钟
	 */
	public static int getMinute(Date date) {
		return getInteger(date, Calendar.MINUTE);
	}

	/**
	 * 获取日期的秒钟。失败返回0。
	 * 
	 * @param date
	 *            日期
	 * @return 秒钟
	 */
	public static int getSecond(Date date) {
		return getInteger(date, Calendar.SECOND);
	}

	/**
	 * 获取日期的星期,星期天返回0
	 * 
	 * @param date
	 *            日期
	 * @return 星期
	 */
	public static int getWeek(Date date) {
		return getInteger(date, Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 获取星期的中文表示
	 * 
	 * @param date
	 *            日期
	 * @return 星期
	 */
	public static String getWeekCn(Date date) {
		String weekString = "";
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		int dayOfWeek = getInteger(date, Calendar.DAY_OF_WEEK);
		weekString = dayNames[dayOfWeek - 1];
		return weekString;
	}

	/**
	 * 根据年月日得到日期
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param date
	 *            日
	 * @return 日期
	 */
	public static Date getDate(int year, int month, int day) {
		return getDate(year, month, day, 0, 0, 0);
	}

	/**
	 * 
	 * @param year
	 *            年
	 * @param month
	 *            月
	 * @param day
	 *            日
	 * @param hourOfDay
	 *            时 (24小时制)
	 * @param minute
	 *            分
	 * @param second
	 *            秒
	 * @return 日期
	 */
	public static Date getDate(int year, int month, int day, int hourOfDay, int minute, int second) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month + 1, day, hourOfDay, minute, second);
		return calendar.getTime();
	}

	/**
	 * 比较两个日期大小
	 * 
	 * @param time1
	 *            日期
	 * @param time2
	 *            日期
	 * @return 整数 正数：time1 > time2 ， 负数:time1 < time2, 0: time1 = time2
	 */
	public static int compareDate(Date time1, Date time2) {
		if (time1 == null) {
			if (time2 == null) {
				return 0;
			} else {
				return -1;
			}
		} else if (time2 == null) {
			return 1;
		} else {
			return new Long(time1.getTime() - time2.getTime()).intValue();
		}
	}

	/**
	 * 比较两个日期大小
	 * 
	 * @param time1
	 *            日期
	 * @param time2
	 *            日期
	 * @param pattern
	 *            比较日期格式，例如:比较年月日 yyyy-MM-dd， 比较时间 HH:mm:ss
	 * @return 整数 正数：time1 > time2 ， 负数:time1 < time2, 0: time1 = time2
	 */
	public static int compareDate(Date time1, Date time2, String pattern) {
		// 有效性检查
		if (time1 == null) {
			if (time2 == null) {
				return 0;
			} else {
				return -1;
			}
		} else if (time2 == null) {
			return 1;
		} else {
			String time1Str = dateToString(time1, pattern);
			String time2Str = dateToString(time2, pattern);
			if (StringUtils.isBlank(pattern) || time1Str == null || time2Str == null) {
				return new Long(time1.getTime() - time2.getTime()).intValue();
			}
			return compareDate(stringToDate(time1Str, pattern), stringToDate(time2Str, pattern));
		}
	}

	/**
	 * 判断日期是否在开始时间与结束时间之间
	 * 
	 * @param date
	 *            时间
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return boolean
	 */
	public static boolean isWithinRange(Date date, Date start, Date end) {
		if (date != null && start != null && end != null && compareDate(date, start) >= 0
				&& compareDate(date, end) <= 0) {
			return true;
		}
		return false;
	}

	/**
	 * @function 判断两个时间戳是否属于同一天 boolean
	 */
	public static boolean isTheSameDate(long time1, long time2) {
		Timestamp timestamp1 = new Timestamp(time1);
		Timestamp timestamp2 = new Timestamp(time2);
		if (timestamp1 != null && timestamp2 != null) {
			Calendar c1 = Calendar.getInstance();
			c1.setTime(timestamp1);
			int y1 = c1.get(Calendar.YEAR);
			int m1 = c1.get(Calendar.MONTH);
			int d1 = c1.get(Calendar.DATE);
			Calendar c2 = Calendar.getInstance();
			c2.setTime(timestamp2);
			int y2 = c2.get(Calendar.YEAR);
			int m2 = c2.get(Calendar.MONTH);
			int d2 = c2.get(Calendar.DATE);
			if (y1 == y2 && m1 == m2 && d1 == d2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private static SimpleDateFormat getDateFormat(String parttern) {
		return new SimpleDateFormat(parttern);
	}

	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数值
	 * @return 计算后日期
	 */
	private static Date addDate(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/**
	 * 获取日期中的某数值。如获取月份
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            日期格式
	 * @return 数值
	 */
	private static int getInteger(Date date, int dateType) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(dateType);
	}

	/**
	 * 获取格式化的n天前订单统计开始时间和结束时间
	 * 
	 * @return
	 */
	public static Map<String, Object> getTradeTime(int n) {
		Map<String, Object> map = new HashMap<String, Object>();
		String startTimeStr = getNDayDateTimeStr(n + 1) + TRADING_START;
		Date startTime = stringToDate(startTimeStr);
		String endTimeStr = getNDayDateTimeStr(n) + TRADING_END;
		Date endTime = stringToDate(endTimeStr);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return map;
	}

	/**
	 * 获取格式化的n天开始时间和结束时间
	 * 
	 * @return
	 */
	public static Map<String, Object> getNormalTime(int n) {
		Map<String, Object> map = new HashMap<String, Object>();
		String startTimeStr = getNDayDateTimeStr(n) + NOMAL_START;
		Date startTime = stringToDate(startTimeStr);
		String endTimeStr = getNDayDateTimeStr(n) + NOMAL_END;
		Date endTime = stringToDate(endTimeStr);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return map;
	}

	/**
	 * 获取指定时间当天的开始时间和结束时间 格式为 yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static Map<String, Object> getOneDayTime(Date time) {
		Map<String, Object> map = new HashMap<String, Object>();
		String timeStr = dateToString(time, FMT_DATE);
		String startTimeStr = timeStr + NOMAL_START;
		Date startTime = stringToDate(startTimeStr);
		String endTimeStr = timeStr + NOMAL_END;
		Date endTime = stringToDate(endTimeStr);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return map;
	}

	/**
	 * 获取格式化的n天前订单统计开始时间和结束时间
	 * 
	 * @return
	 */
	public static Map<String, Object> getMonthTime(int n, String type) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String firstday, lastday;
		// 获取上个月的最后一天
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, -n);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		firstday = format.format(cale.getTime());
		// 获取前月的最后一天
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, -n + 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		lastday = format.format(cale.getTime());

		Map<String, Object> map = new HashMap<String, Object>();
		String startTime = null;
		String endTime = null;
		if (type.equalsIgnoreCase(NORMAL_TIME_TYPE)) {
			startTime = firstday + NOMAL_START;
			endTime = lastday + NOMAL_END;
		} else if (type.equalsIgnoreCase(TRADE_TIME_TYPE)) {
			startTime = firstday + TRADING_START;
			endTime = lastday + TRADING_END;
		}
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		return map;
	}

}