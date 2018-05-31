package com.netcai.admin.jdpush;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
/**
 * 激光推送
 */
public class Jdpush {

	private static final Logger log = LoggerFactory.getLogger(Jdpush.class);
	
	// 设置好账号的app_key和masterSecret 
	public static final String APPKEY = "720eeb91269c5a9de3bcbe0d";
	
	public static final String MASTERSECRET = "b25351ba83bd0b559ee47214";
	   
	    /**
	     * 推送所有
	     */
	    public static PushPayload buildPushObjectAndroidIosAllAlert(String message){
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.all())//推送所有;
	                .setNotification(Notification.newBuilder()
	                        .addPlatformNotification(AndroidNotification.newBuilder()
	                                .addExtra("type", "infomation")
	                                .setAlert(message)
	                                .build())
	                        .addPlatformNotification(IosNotification.newBuilder().setSound("callu")
	                                .addExtra("type", "infomation")
	                                .setAlert(message)
	                                .build())
	                        .build())
	                .setOptions(Options.newBuilder()
	                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
	                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
	                        .build())
	                .build();
	    }
	    
	    
	    /**
	     * 推送 指定用户集合;
	     */
	    public static PushPayload buildPushObjectAndroidIosAliasAlert(List<String> userIds,String message){
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.alias(userIds))//推送多个;
	                .setNotification(Notification.newBuilder()
	                        .addPlatformNotification(AndroidNotification.newBuilder()
	                                .addExtra("type", "infomation")
	                                .setAlert(message)
	                                .build())
	                        .addPlatformNotification(IosNotification.newBuilder().setSound("callu")
	                                .addExtra("type", "infomation")
	                                .setAlert(message)
	                                .build())
	                        .build())
	                .setOptions(Options.newBuilder()
	                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
	                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
	                        .build())
	                .build();
	    }
	    
	    /**
	     * 推送单个人;
	     */
	    public static PushPayload buildPushObjectAndroidIosAliasAlert(String userId,String message){
	        return PushPayload.newBuilder()
	                .setPlatform(Platform.android_ios())
	                .setAudience(Audience.alias(userId))//推送单个;
	                .setNotification(Notification.newBuilder()
	                        .addPlatformNotification(AndroidNotification.newBuilder()
	                                .addExtra("type", "infomation")
	                                .setAlert(message)
	                                .build())
	                        .addPlatformNotification(IosNotification.newBuilder().setSound("callu")
	                                .addExtra("type", "infomation")
	                                .setAlert(message)
	                                .build())
	                        .build())
	                .setOptions(Options.newBuilder()
	                        .setApnsProduction(false)//true-推送生产环境 false-推送开发环境（测试使用参数）
	                        .setTimeToLive(90)//消息在JPush服务器的失效时间（测试使用参数）
	                        .build())
	                .build();
	    }
	    
	    /**
	     * 推送所有
	     */
	    public static PushResult pushAlias(String alert){
	        ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(MASTERSECRET, APPKEY, null, clientConfig);
	        PushPayload payload = buildPushObjectAndroidIosAllAlert(alert);
	        try {
	            return jpushClient.sendPush(payload);
	        } catch (APIConnectionException e) {
	            log.error("Connection error. Should retry later. ", e);
	            return null;
	        } catch (APIRequestException e) {
	            log.error("Error response from JPush server. Should review and fix it. ", e);
	            log.info("HTTP Status: " + e.getStatus());
	            log.info("Error Code: " + e.getErrorCode());
	            log.info("Error Message: " + e.getErrorMessage());
	            log.info("Msg ID: " + e.getMsgId());
	            return null;
	        }    
	    }
	    
	    /**
	     * 推送 指定用户集合;
	     */
	    public static PushResult pushAlias(List<String> userIds,String alert){
	        ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(MASTERSECRET, APPKEY, null, clientConfig);
	        PushPayload payload = buildPushObjectAndroidIosAliasAlert(userIds,alert);
	        try {
	            return jpushClient.sendPush(payload);
	        } catch (APIConnectionException e) {
	            log.error("Connection error. Should retry later. ", e);
	            return null;
	        } catch (APIRequestException e) {
	            log.error("Error response from JPush server. Should review and fix it. ", e);
	            log.info("HTTP Status: " + e.getStatus());
	            log.info("Error Code: " + e.getErrorCode());
	            log.info("Error Message: " + e.getErrorMessage());
	            log.info("Msg ID: " + e.getMsgId());
	            return null;
	        }    
	    }
	    
	    /**
	     * 推送单个人;
	     */
	    public static PushResult pushAlias(String userId,String alert){
	        ClientConfig clientConfig = ClientConfig.getInstance();
	        JPushClient jpushClient = new JPushClient(MASTERSECRET, APPKEY, null, clientConfig);
	        PushPayload payload = buildPushObjectAndroidIosAliasAlert(userId,alert);
	        try {
	            return jpushClient.sendPush(payload);
	        } catch (APIConnectionException e) {
	            log.error("Connection error. Should retry later. ", e);
	            return null;
	        } catch (APIRequestException e) {
	            log.error("Error response from JPush server. Should review and fix it. ", e);
	            log.info("HTTP Status: " + e.getStatus());
	            log.info("Error Code: " + e.getErrorCode());
	            log.info("Error Message: " + e.getErrorMessage());
	            log.info("Msg ID: " + e.getMsgId());
	            return null;
	        }    
	    }
	    
	    
}