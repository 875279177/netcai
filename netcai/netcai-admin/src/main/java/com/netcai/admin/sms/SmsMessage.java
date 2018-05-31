package com.netcai.admin.sms;

/***
 * 短信消息对象
 * @author administrator
 */

public class SmsMessage {

	private String message;
	
	private String code;
	
	private String product;
	
	public SmsMessage() {
		super();
	}

	public SmsMessage(String message, String code, String product) {
		super();
		this.message = message;
		this.code = code;
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SmsMessage [message=");
		builder.append(message);
		builder.append(", code=");
		builder.append(code);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}
}