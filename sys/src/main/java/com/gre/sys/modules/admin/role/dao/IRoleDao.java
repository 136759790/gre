package com.gre.sys.modules.admin.role.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gre.api.modules.admin.role.model.Role;


@Mapper
public interface IRoleDao {
	void insert(Role role);
	void update(Role role);
	void delete(Long id);
	void deleteList(List<Long> id);
	Role selectOne(Long id);
	List<Role> selectList(Map map);
}
