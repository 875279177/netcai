package com.netcai.buyer.result;

/**
 *  Controller层的 json格式对象
 *  @author administrator
 */
public class JsonResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回的编码
	 */
	private String code;
	
	/**
	 * 返回的信息
	 */
	private String message;
	
	/***
	 * 返回的对象
	 */
	private Object object;

	public JsonResult() {
		super();
	}
	
	public JsonResult(String code, String message, Object object) {
		super();
		this.code = code;
		this.message = message;
		this.object = object;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
