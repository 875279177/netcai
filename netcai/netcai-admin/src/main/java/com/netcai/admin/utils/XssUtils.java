package com.netcai.admin.utils;

import org.apache.commons.lang.StringUtils;

/**
 * XSS工具类
 * @author administrator
 * 2015-6-2
 */
public class XssUtils {
	
	public static String getSafeStringXSS(String s)
	{
	       if (StringUtils.isBlank(s)) {  
	           return s;  
	       }  
	       StringBuilder sb = new StringBuilder(s.length() + 16);  
	       for (int i = 0; i < s.length(); i++) {  
	           char c = s.charAt(i);  
	           switch (c) {  
	           case '<':  
	               sb.append("&lt;");  
	               break; 
	           case '>':  
	               sb.append("&gt;");  
	               break;  
	           case '\'':  
	               sb.append("&prime;"); 
	               break;  
	           case '′':  
	               sb.append("&prime;"); 
	               break;  
	           case '\"':  
	               sb.append("&quot;");  
	               break;  
	           case '＂':  
	               sb.append("&quot;");  
	               break;  
	           case '&':  
	               sb.append("＆");  
	               break;  
	           case '#':  
	               sb.append("＃");  
	               break;  
	           case '\\':  
	               sb.append('￥');  
	               break; 
	           case '=':  
	               sb.append("=");  
	               break;
	           default:  
	               sb.append(c);  
	               break;  
	           }  
	       }  
	       return sb.toString(); 
	   }
}