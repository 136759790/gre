package com.gre.sys.modules.admin.org.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gre.api.modules.admin.org.model.Org;


@Mapper
public interface IOrgDao {
	void insert(Org org);
	void update(Org org);
	void delete(Long id);
	void deleteList(List<Long> id);
	Org selectOne(Long id);
	List<Org> selectList(Map map);
}
