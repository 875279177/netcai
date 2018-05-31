package com.netcai.buyer.vo;

import java.io.Serializable;

/**
 * 商品加工方式显示类
 * @author administrator
 */
public class GoodsMethodVo implements Serializable {
	 
	private static final long serialVersionUID = 1L;
		
	private Long gmId;
	/**
	 * 加工方式ID
	 */
	private Integer methodId;
	/**
	 * 创建时间
	 */
	private String methodName;
	
	public Long getGmId() {
		return gmId;
	}
	public void setGmId(Long gmId) {
		this.gmId = gmId;
	}
	public Integer getMethodId() {
		return methodId;
	}
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
}
