package com.netcai.buyer.exception;

/**
 * service异常，业务异常继续于当前接口
 * 
 * @author administrator
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4875141928739446984L;

	/**
	 * 错误码
	 */
	protected String code;

	/**
	 * 错误信息
	 */
	protected String message;

	public ServiceException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ServiceException(String code, String message, Throwable t) {
		super();
		this.code = code;
		this.message = message;
	}

	public ServiceException(String message) {
		super(message);
		this.message = message;
	}

	public ServiceException(String message, Throwable t) {
		super(message, t);
		this.message = message;
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

	@Override
	public String toString() {
		return "ServiceException [code=" + code + ", message=" + message + "]";
	}
}
