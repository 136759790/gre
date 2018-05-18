package com.gre.api.modules.admin.reference.service;

import java.util.Map;

import com.gre.api.modules.admin.reference.model.OrgUser;
import com.gre.api.modules.admin.reference.model.RoleRes;
import com.gre.api.modules.admin.reference.model.RoleUser;
import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.result.PageInfo;


public interface IReferenceService {
	void insertOrgUser(OrgUser orgUser);
	void insertRoleUser(RoleUser roleUser);
	void insertRoleRes(RoleRes roleRes);
	
	void deleteOrgUser(OrgUser orgUser);
	void deleteRoleUser(RoleUser roleUser);
	void deleteRoleRes(RoleRes roleRes);
	
	void updateOrgUser(OrgUser orgUser);
	void updateRoleUser(RoleUser roleUser);
	
	PageInfo<UserInfo> findUserPage(Map map);
}
