package com.netcai.admin.exception;

/**
 * service异常，业务异常继续于当前接口
 * @author administrator
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 4875141928739446984L;

	/**
	 * 错误码
	 */
	protected int code;

	/**
	 * 错误信息
	 */
	protected String info;

	public ServiceException(int code, String info) {
		super();
		this.code = code;
		this.info = info;
	}

	public ServiceException(int code, String info, Throwable t) {
		super();
		this.code = code;
		this.info = info;
	}

	public ServiceException(String message) {
		super(message);
		this.info = message;
	}

	public ServiceException(String message, Throwable t) {
		super(message, t);
		this.info = message;
	}

	public ServiceException() {
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "ServiceException [code=" + code + ", info=" + info + "]";
	}
}
