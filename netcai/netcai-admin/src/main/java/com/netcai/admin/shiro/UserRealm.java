package com.netcai.admin.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.netcai.admin.constants.SysConstant;
import com.netcai.admin.entity.ActiveSysUser;
import com.netcai.admin.entity.SysMenu;
import com.netcai.admin.service.SysMenuService;
import com.netcai.admin.service.SysUserService;

public class UserRealm extends AuthorizingRealm {

	private static final String REALM_NAME = "userRealm";
	
	// 设置顶层父节点的id
	private static int TOP_PARENT_ID = 0;
	// 设置资源类型
	private static int PERMISSION_TYPE = 3;

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户名
		String userName = (String) token.getPrincipal();
		// 根据用户名查询用户信息
		ActiveSysUser user = sysUserService.getUserByUserName(userName);
		if (user == null) {
			return null;
		}
		List<SysMenu> menuList = user.getMenuList();
		if (CollectionUtils.isNotEmpty(menuList)) {
			// 将菜单按父子节点层级存入到集合
			menuList = sysMenuService.getMyMenu(menuList, TOP_PARENT_ID);
			user.setMenuList(menuList);
		}

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
				ByteSource.Util.bytes(user.getSalt()), this.getName());
		//将用户信息存入session
		Subject subject = SecurityUtils.getSubject(); 
		Session session = subject.getSession();
		session.removeAttribute(SysConstant.SESSION_SYS);
		session.setAttribute(SysConstant.SESSION_SYS,user);
		return authenticationInfo;
	}

	/**
	 * 用户授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ActiveSysUser user = (ActiveSysUser) principals.getPrimaryPrincipal();
		if (user.getId() == null) {
			return null;
		}
		// 查询用户的资源权限
		List<SysMenu> menus = sysMenuService.getAllMenuByUserId(user.getId(), PERMISSION_TYPE);
		if (CollectionUtils.isEmpty(menus)) {
			return null;
		}
		Set<String> permissions = new HashSet<String>();
		for (SysMenu menu : menus) {
			String percode = menu.getPercode();
			if (StringUtils.isNotBlank(percode)) {
				permissions.add(percode);
			}
		}
		// 将资源权限集合添加到SimpleAuthorizationInfo中
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setStringPermissions(permissions);
		return authorizationInfo;
	}

	/**
	 * 清除缓存
	 */
	public void clearCache() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}

	public void setName() {
		super.setName(REALM_NAME);
	}

}
