package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色实体类
 * 
 * @author administrator
 */
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String roleName; // 角色名称
	private String roleDesc; // 角色描述
	private String remarks; // 备注信息
	private int status; // 状态
	private Date createTime; // 创建时间
	
	public SysRole() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}