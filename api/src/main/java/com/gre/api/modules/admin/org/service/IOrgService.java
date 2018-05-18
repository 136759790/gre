package com.gre.api.modules.admin.org.service;

import java.util.List;
import java.util.Map;

import com.gre.api.modules.admin.org.model.Org;
import com.gre.api.result.PageInfo;
import com.gre.api.result.Tree;


public interface IOrgService {
	void insert (Org org);
	void update (Org org);
	Org findOne(Long id);
	PageInfo<Org> findPage(Map map);
	void delete(Long id);
	void delete(List<Long> id);
	Tree getOrgTree(List<Org> list);
	Tree getOrgTree(Map map);
	List<Tree> getOrgTrees(Map map);
	
}
