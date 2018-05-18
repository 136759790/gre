package com.gre.sys.modules.admin.org.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gre.api.enums.TreeEnum;
import com.gre.api.modules.admin.org.model.Org;
import com.gre.api.modules.admin.org.service.IOrgService;
import com.gre.api.result.PageInfo;
import com.gre.api.result.Tree;
import com.gre.api.utils.UtilPage;
import com.gre.api.utils.UtilTree;
import com.gre.sys.modules.admin.org.dao.IOrgDao;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrgService implements IOrgService{
	@Autowired
	IOrgDao orgDao;
	
	@Transactional
	@Override
	public void insert(Org org) {
		org.setType_code(TreeEnum.ORGANIZATION.getCode());
		org.setType_value(TreeEnum.ORGANIZATION.getValue());
		orgDao.insert(org);
	}

	@Transactional
	@Override
	public void update(Org org) {
		orgDao.update(org);
	}

	@Override
	public Org findOne(Long id) {
		return orgDao.selectOne(id);
	}

	@Override
	public PageInfo<Org> findPage(Map map) {
		UtilPage.startPage(map);
		List<Org> list=orgDao.selectList(map);
		return new PageInfo<Org>(list);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		orgDao.delete(id);
	}
	
	@Transactional
	@Override
	public void delete(List<Long> id) {
		orgDao.deleteList(id);
	}

	@Override
	public Tree getOrgTree(List<Org> list) {
//		UtilTree.getfatherNode(tree)
		return null;
	}

	@Override
	public Tree getOrgTree(Map map) {
		List<Org> list=orgDao.selectList(map);
		List<Tree> list_tree=(List<Tree>) UtilTree.switchTree(list);
		Tree result=UtilTree.oneTree(list_tree);
		return result;
	}

	@Override
	public List<Tree> getOrgTrees(Map map) {
		List<Org> list=orgDao.selectList(map);
		List<Tree> list_tree=(List<Tree>) UtilTree.switchTree(list);
		return (List<Tree>) UtilTree.getfatherNode(list_tree);
	}

}
