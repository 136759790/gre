package com.gre.gateway.auth;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gre.api.modules.admin.enums.SecurityEnum;
import com.gre.api.modules.admin.role.model.Role;
import com.gre.api.modules.admin.role.service.IRoleService;
import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.modules.admin.user.service.IUserInfoService;

@Component
public class AuthRealm extends AuthorizingRealm{
	@Reference(check=false)
	IUserInfoService userInfoService;
	@Reference(check=false)
	IRoleService roleService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String account=(String) principals.getPrimaryPrincipal();
		UserInfo user=userInfoService.findOne(account);
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		Set<String> roles=new HashSet<String>();
		Map m =new HashMap();
		m.put("user_id", user.getId());
		List<Role> list_role=roleService.queryRoles(m);
		for (Role role : list_role) {
			roles.add(role.getRole_code());
		}
		info.setRoles(roles);
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken u_token=(UsernamePasswordToken) token;
		String username=u_token.getUsername();
		String pwd="";
		if(u_token.getPassword()!=null){
			pwd=new String(u_token.getPassword());
		}
		UserInfo user=null;
		try {
			user=userInfoService.login(username, pwd);
		} catch (Exception e) {
			throw new AuthenticationException(e.getMessage());
		}
		SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(), pwd.toCharArray(),getName());
		SecurityUtils.getSubject().getSession().setAttribute(SecurityEnum.SESSION_KEY.getCode(), user);
		return info;
	}

}
