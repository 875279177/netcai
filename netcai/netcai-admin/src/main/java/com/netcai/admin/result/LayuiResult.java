package com.netcai.admin.result;

/**
 *  Controller层的 json格式对象
 */
public class LayuiResult implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 返回的编码
	 */
	private Integer code;
	
	/**
	 * 返回的信息
	 */
	private String msg;
	
	/***
	 * 返回的对象
	 */
	private Data data;

	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Data getData() {
		return data;
	}


	public void setData(Data data) {
		this.data = data;
	}

	public LayuiResult(Integer code, String msg, Data data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
}
