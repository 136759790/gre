package com.gre.api.modules.admin.role.service;

import java.util.List;
import java.util.Map;

import com.gre.api.modules.admin.role.model.Role;
import com.gre.api.result.PageInfo;


public interface IRoleService {
	void insert (Role role);
	void update (Role role);
	Role findOne(Long id);
	PageInfo<Role> findPage(Map map);
	void delete(Long id);
	void delete(List<Long> id);
	List<Role> queryRoles(Map map);
	
	List<String> queryRoleKeysByResId(Integer res_id);
}
