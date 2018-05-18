package com.gre.sys.modules.admin.reference.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gre.api.modules.admin.reference.model.OrgUser;
import com.gre.api.modules.admin.reference.model.RoleRes;
import com.gre.api.modules.admin.reference.model.RoleUser;
import com.gre.api.modules.admin.user.model.UserInfo;


/**
 * 配置后台关系的接口
 * @author zxt
 *
 */
@Mapper
public interface IReferenceDao {
	void insertOrgUser(OrgUser orgUser);
	void insertRoleUser(RoleUser roleUser);
	void insertRoleRes(RoleRes roleRes);
	
	void deleteOrgUser(OrgUser orgUser);
	void deleteRoleUser(RoleUser roleUser);
	void deleteRoleRes(RoleRes roleRes);
	
	void updateOrgUser(OrgUser orgUser);
	void updateRoleUser(RoleUser roleUser);
	/**
	 * 只能增删不能修改
	 */
//	void updateRoleRes(RoleRes roleRes);
	
	List<UserInfo> selectUserList(Map map);
	
	
	
}
