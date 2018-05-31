package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司信息实体类
 * 
 * @author administrator
 *
 */
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	/**
	 * 公司名称
	 */
	private String name;
	/**
	 * 公司负责人
	 */
	private String contact;
	/**
	 * 负责人手机号
	 */
	private String phone;
	/**
	 * 公司地址
	 */
	private String address;
	/**
	 * 父节点id
	 */
	private Long parentId;
	/**
	 * 备注信息
	 */
	private String remarks;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 父公司
	 */
	private String parentCompany;

	public String getParentCompany() {
		return parentCompany;
	}

	public void setParentCompany(String parentCompany) {
		this.parentCompany = parentCompany;
	}
}
