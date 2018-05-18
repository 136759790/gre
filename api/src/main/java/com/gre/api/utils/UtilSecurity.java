package com.gre.api.utils;

import org.apache.shiro.SecurityUtils;

import com.gre.api.modules.admin.enums.SecurityEnum;
import com.gre.api.modules.admin.user.model.UserInfo;



public class UtilSecurity {
	public static UserInfo getCurUser(){
		UserInfo user=null;
		try {
			user=(UserInfo) SecurityUtils.getSubject().getSession().getAttribute(SecurityEnum.SESSION_KEY.getCode());
		} catch (Exception e) {
		}
		return  user;
	}
}
