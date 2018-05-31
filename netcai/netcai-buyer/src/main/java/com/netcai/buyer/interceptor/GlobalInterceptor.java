package com.netcai.buyer.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.netcai.buyer.constants.UserStatus;
import com.netcai.buyer.entity.Users;
import com.netcai.buyer.exception.ServiceException;
import com.netcai.buyer.result.JsonResultCode;
import com.netcai.buyer.service.UsersService;

/**
 * 全局拦截器,实现对数据的全局拦截.
 * @author administrator
 */
public class GlobalInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger=LoggerFactory.getLogger(GlobalInterceptor.class);
	
	@Autowired
	private UsersService usersService;
	
	@Override
	// 实现用户访问页面时的登录验证功能
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String url = request.getContextPath()+request.getRequestURI();
		
		logger.info("GlobalInterceptor.preHandle.url= " +url);
		
		if(url.indexOf("error_404")!=-1 || url.indexOf("error_500")!=-1 || url.indexOf("/webser/storage/image")!=-1)
		{
			return true;
		}
		
		String userId=request.getParameter("userId");
		
		if(StringUtils.isBlank(userId))
		{
			logger.info("GlobalInterceptor.preHandle.userId.is null");
			throw new ServiceException(JsonResultCode.FAILURE,"请求参数有误,请稍后重试");
		}
		
		logger.info("GlobalInterceptor.userId=" +userId);
		
		//判断当前用户是否可用
		Users users=usersService.getUsersById(NumberUtils.toLong(userId));
		
		if(users==null)
		{
			logger.info("GlobalInterceptor.preHandle.userId " +userId);
			throw new ServiceException(JsonResultCode.FAILURE,"账号不存在,请重新输入");
		}
		
		logger.info("[GlobalInterceptor][userId的基本信息为]：" + users.toString());
		
		//买家状态
		int status=users.getStatus();
		
		if(UserStatus.FORBIDDEN==status)
		{
			throw new ServiceException(JsonResultCode.FAILURE,"你的账号已经被禁用了,请联系公司客服");
		}
		return true;
	}
}