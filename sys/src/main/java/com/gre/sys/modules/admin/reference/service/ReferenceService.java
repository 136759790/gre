package com.gre.sys.modules.admin.reference.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gre.api.modules.admin.reference.model.OrgUser;
import com.gre.api.modules.admin.reference.model.RoleRes;
import com.gre.api.modules.admin.reference.model.RoleUser;
import com.gre.api.modules.admin.reference.service.IReferenceService;
import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.result.PageInfo;
import com.gre.api.utils.UtilPage;
import com.gre.sys.modules.admin.reference.dao.IReferenceDao;

@Service
@com.alibaba.dubbo.config.annotation.Service(interfaceName="com.gre.api.modules.admin.reference.service.IReferenceService")
public class ReferenceService implements IReferenceService{
	@Autowired
	IReferenceDao referenceDao;
	
	@Override
	public void insertOrgUser(OrgUser orgUser) {
		referenceDao.insertOrgUser(orgUser);
	}

	@Override
	public void insertRoleUser(RoleUser roleUser) {
		referenceDao.insertRoleUser(roleUser);
	}
	
	@Transactional
	@Override
	public void insertRoleRes(RoleRes roleRes) {
		referenceDao.insertRoleRes(roleRes);
	}

	@Override
	public void deleteOrgUser(OrgUser orgUser) {
		referenceDao.deleteOrgUser(orgUser);
	}

	@Override
	public void deleteRoleUser(RoleUser roleUser) {
		referenceDao.deleteRoleUser(roleUser);
	}

	@Override
	public void deleteRoleRes(RoleRes roleRes) {
		referenceDao.deleteRoleRes(roleRes);
	}

	@Override
	public void updateOrgUser(OrgUser orgUser) {
		referenceDao.updateOrgUser(orgUser);
	}

	@Override
	public void updateRoleUser(RoleUser roleUser) {
		referenceDao.updateRoleUser(roleUser);
	}

	@Override
	public PageInfo<UserInfo> findUserPage(Map map) {
		UtilPage.startPage(map);
		List<UserInfo> list = referenceDao.selectUserList(map);
		return new PageInfo<UserInfo>(list);
	}

}
