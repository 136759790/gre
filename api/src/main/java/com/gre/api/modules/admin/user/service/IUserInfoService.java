package com.gre.api.modules.admin.user.service;

import java.util.List;

import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.modules.admin.user.model.UserInfoParam;
import com.gre.api.result.PageInfo;


public interface IUserInfoService {
	void insert (UserInfo userinfo);
	void update (UserInfo userinfo);
	UserInfo findOne(Long id);
	UserInfo findOne(String username);
	PageInfo<UserInfo> findPage(UserInfoParam param);
	void delete(Long id);
	void delete(List<Long> id);
	
	UserInfo login(String account,String pwd);
	void register (UserInfo userinfo);
}
