package com.netcai.buyer.entity;

import java.util.Date;

/**
 * 短信实体对象
 * @author administrator
 */
public class Sms implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 自动增加ID
	 */
	private Long id;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 内容
	 */
	private String message;
	
	/**
	 * 备注短信的作用或者说明
	 */
	private String remark;
	
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public Sms() {
		super();
	}

	public Sms(Long id, String phone, String message, String remark, Date createTime) {
		super();
		this.id = id;
		this.phone = phone;
		this.message = message;
		this.remark = remark;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sms [id=");
		builder.append(id);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", message=");
		builder.append(message);
		builder.append(", remark=");
		builder.append(remark);
		builder.append(", createTime=");
		builder.append(createTime);
		builder.append("]");
		return builder.toString();
	}
}