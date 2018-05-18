package com.gre.sys.modules.admin.role.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.gre.api.modules.admin.role.model.Role;
import com.gre.api.modules.admin.role.service.IRoleService;
import com.gre.api.result.PageInfo;
import com.gre.api.utils.UtilPage;
import com.gre.sys.modules.admin.role.dao.IRoleDao;


@Component
@Service
public class RoleService implements IRoleService{
	
	@Autowired
	IRoleDao roleDao;
	@Override
	public void insert(Role role) {
		roleDao.insert(role);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role findOne(Long id) {
		return roleDao.selectOne(id);
	}

	@Override
	public PageInfo<Role> findPage(Map map) {
		UtilPage.startPage(map);
		List<Role> list=roleDao.selectList(map);
		return new PageInfo<Role>(list);
	}

	@Override
	public void delete(Long id) {
		roleDao.delete(id);
		
	}

	@Override
	public void delete(List<Long> id) {
		roleDao.deleteList(id);
	}

	@Override
	public List<Role> queryRoles(Map map) {
		return roleDao.selectList(map);
	}

	@Override
	public List<String> queryRoleKeysByResId(Integer res_id) {
		Map m=new HashMap();
		m.put("res_id", res_id);
		List<Role> roles= roleDao.selectList(m);
		return null;
	}

}
