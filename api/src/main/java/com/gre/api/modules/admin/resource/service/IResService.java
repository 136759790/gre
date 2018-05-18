package com.gre.api.modules.admin.resource.service;

import java.util.List;
import java.util.Map;

import com.gre.api.modules.admin.resource.model.Resource;
import com.gre.api.result.PageInfo;
import com.gre.api.result.Tree;


public interface IResService {
	void insert (Resource res);
	void update (Resource res);
	Resource findOne(Long id);
	PageInfo<Resource> findPage(Map map);
	void delete(Long id);
	void delete(List<Long> id);
	List<Tree> getResTrees(Map map);
	List<Resource> queryRess(Map map);
}
