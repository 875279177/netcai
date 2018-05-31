package com.netcai.buyer.listener;

import org.springframework.context.ApplicationContext;

/**
 * @ClassName: SpringContextUtil
 * @Description: SpringContextUtil 工具类
 */
public class SpringContextUtil {

	private static ApplicationContext context = null;

	public static ApplicationContext getContext() {
		return context;
	}

	public static void setContext(ApplicationContext context) {
		SpringContextUtil.context = context;
	}

	/**
	 * 根据beanId获得对象
	 * 
	 * @param beanId
	 *            beanID
	 * @return 返回配置的对象
	 */
	public static Object getBean(String beanId) {
		return context.getBean(beanId);
	}
}
