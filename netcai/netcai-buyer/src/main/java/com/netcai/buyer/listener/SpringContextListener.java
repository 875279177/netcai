package com.netcai.buyer.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.netcai.buyer.cache.AreaCache;

/**
 * @ClassName: SpringContextListener
 * @Description: ApplicationContext 设置到 SpringContextUtil
 */
public class SpringContextListener extends ContextLoaderListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		// 把 ApplicationContext 设置到 SpringContextUtil
		ServletContext context = event.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(context);
		SpringContextUtil.setContext(ctx);
		
		//加载
		AreaCache.load();
	}
}