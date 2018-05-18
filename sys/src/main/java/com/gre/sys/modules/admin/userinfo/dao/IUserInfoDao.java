package com.gre.sys.modules.admin.userinfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.modules.admin.user.model.UserInfoParam;


@Mapper
public interface IUserInfoDao {
	void insert(UserInfo userinfo);
	void update(UserInfo userinfo);
	void delete(Long id);
	void deleteList(List<Long> id);
	UserInfo selectOne(Long id);
	UserInfo selectOneByName(String name);
	List<UserInfo> selectList(UserInfoParam param);
	
}
