package com.netcai.sms.utils;

/**
 * 短信发送结果
 * @author administrator
 */
public class SmsResult implements java.io.Serializable{

	private static final long serialVersionUID = 1L;

	private boolean success=false;
	
	private String message;
	
	public SmsResult() {
		super();
	}
	
	public SmsResult(String message) 
	{
		super();
		this.success=false;
		this.message=message;
	}
	
	public SmsResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsResult [success=");
		builder.append(success);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
}