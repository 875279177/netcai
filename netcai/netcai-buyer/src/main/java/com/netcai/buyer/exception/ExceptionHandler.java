package com.netcai.buyer.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.netcai.buyer.result.JsonResult;
import com.netcai.buyer.result.JsonResultCode;

import net.sf.json.JSONObject;

/**
 * 全局异常处理类.对后台直接抛往前台页面的异常进行封装处理.
 * @administrator
 */
public class ExceptionHandler extends SimpleMappingExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		ModelAndView mv = super.doResolveException(request, response, handler, ex);

		String url = WebUtils.getPathWithinApplication(request);

		logger.error("controller error.url=" + url, ex);

		/* 使用response返回 */
		response.setStatus(HttpStatus.OK.value()); // 设置状态码
		response.setContentType(MediaType.APPLICATION_JSON_VALUE); // 设置ContentType
		response.setCharacterEncoding("UTF-8"); // 避免乱码
		response.setHeader("Cache-Control", "no-cache, must-revalidate");
		
		JsonResult jsonResult=new JsonResult(JsonResultCode.FAILURE,"系统错误,请联系管理员","");
		
		if(ex instanceof ServiceException)
		{
			ServiceException serviceException=(ServiceException)ex;
			String code=serviceException.getCode();
			String message=serviceException.getMessage();
			jsonResult=new JsonResult(code,message,"");
		}
		try 
		{
			PrintWriter printWriter = response.getWriter();
			printWriter.write(JSONObject.fromObject(jsonResult).toString());
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) 
		{
			logger.error("与客户端通讯异常:" + e.getMessage(), e);
		}
		logger.error("异常:" + ex.getMessage(), ex);
		return mv;
	}
}