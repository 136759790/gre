package com.gre.sys.modules.admin.resource.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.gre.api.modules.admin.resource.model.Resource;
import com.gre.api.modules.admin.resource.service.IResService;
import com.gre.api.result.PageInfo;
import com.gre.api.result.Tree;
import com.gre.api.utils.UtilPage;
import com.gre.api.utils.UtilTree;
import com.gre.sys.modules.admin.resource.dao.IResDao;
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ResService implements IResService{
	@Autowired
	private IResDao resDao;
	@Override
	public void insert(Resource res) {
		resDao.insert(res);
	}

	@Override
	public void update(Resource res) {
		resDao.update(res);
		
	}

	@Override
	public Resource findOne(Long id) {
		return resDao.selectOne(id);
	}

	@Override
	public PageInfo<Resource> findPage(Map map) {
		UtilPage.startPage(map);
		List<Resource> list=resDao.selectList(map);
		return new PageInfo<Resource>(list);
	}

	@Override
	public void delete(Long id) {
		resDao.delete(id);
	}

	@Override
	public void delete(List<Long> id) {
		resDao.deleteList(id);
	}

	@Override
	public List<Tree> getResTrees(Map map) {
		List<Resource> list=resDao.selectList(map);
		List<Tree> list_tree=(List<Tree>) UtilTree.switchTree(list);
		return (List<Tree>) UtilTree.getfatherNode(list_tree);
	}

	@Override
	public List<Resource> queryRess(Map map) {
		return resDao.selectList(map);
	}
	
	

}
