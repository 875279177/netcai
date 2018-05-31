package com.netcai.admin.entity;

import java.util.Date;

/**
 * 项目升级
 * @author administrator
 */
public class Upgrade implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	/**
	 * IOS/ANDROID
	 */
	private String name;
	
	/**
	 * 下载地址
	 */
	private String url;
	
	/**
	 * 1为强制升级，0为推荐升级，默认为1
	 */
	private String tips;
	
	/**
	 * 版本
	 */
	private String version;
	
	/**
	 * 所属类型：buyer or seller
	 */
	private String type;
	
	/**
	 * 升级说明
	 */
	private String remarks;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}