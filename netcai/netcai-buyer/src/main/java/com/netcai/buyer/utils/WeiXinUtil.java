package com.netcai.buyer.utils;

/**
 * 微信配置
 * @author administrator
 */
public class WeiXinUtil {

	// 微信应用ID
	public static final String APPID = "wx36c371f03dc43b57";
	
	// 微信商户号
	public static final String MCHID = "1481726022";
	
	//微信设备号
	public static final String DEVICE_INFO="WEB";

	// 微信请求回调地址
	public static final String URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	
	// 微信回调地址
	public static final String NOTIFYURL = "http://buyer.haowai77.com/buyer/weixin/notify";
	
	// 微信交易类型
	public static final String TRADETYPE = "APP";
	
	// 微信APIKEY
	public static final String APIKEY = "haoweiewqie767e6uweuk87687878721";
	
	//微信签名类型
	public static final String SIGN_TYPE="MD5";
}