package com.netcai.admin.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统菜单
 * 
 * @author administrator
 */
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer menuId;
	/**
	 * 菜单编码
	 */
	private String menuCode;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 链接
	 */
	private String menuHref;
	/**
	 * 菜单图标
	 */
	private String menuIcon;
	/**
	 * 类型:1.菜单资源，2.数据资源3.按钮资源
	 */
	private Integer type;
	/**
	 * 资源标识符
	 */
	private String percode;
	/**
	 * 父类ID,0表示第一级
	 */
	private Integer parentId;
	/**
	 * 菜单顺序
	 */
	private Integer menuSeq;
	/**
	 * 层级
	 */
	private Short menuLevel;
	/**
	 * 是否末级 1表示是末级
	 */
	private Short isEnd;
	/**
	 * 状态(1为可用，-1为不可用)
	 */
	private Integer menuStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;

	private List<SysMenu> menuList;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuHref() {
		return menuHref;
	}

	public void setMenuHref(String menuHref) {
		this.menuHref = menuHref;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPercode() {
		return percode;
	}

	public void setPercode(String percode) {
		this.percode = percode;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getMenuSeq() {
		return menuSeq;
	}

	public void setMenuSeq(Integer menuSeq) {
		this.menuSeq = menuSeq;
	}

	public Short getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Short menuLevel) {
		this.menuLevel = menuLevel;
	}

	public Short getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(Short isEnd) {
		this.isEnd = isEnd;
	}

	public Integer getMenuStatus() {
		return menuStatus;
	}

	public void setMenuStatus(Integer menuStatus) {
		this.menuStatus = menuStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public List<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

}
