package com.gre.sys.modules.admin.resource.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gre.api.modules.admin.resource.model.Resource;


@Mapper
public interface IResDao {
	void insert(Resource res);
	void update(Resource role);
	void delete(Long id);
	void deleteList(List<Long> id);
	Resource selectOne(Long id);
	List<Resource> selectList(Map map);
}
