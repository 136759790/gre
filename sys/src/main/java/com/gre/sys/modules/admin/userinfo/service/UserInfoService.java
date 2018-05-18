package com.gre.sys.modules.admin.userinfo.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;






import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.gre.api.modules.admin.reference.model.RoleUser;
import com.gre.api.modules.admin.reference.service.IReferenceService;
import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.modules.admin.user.model.UserInfoParam;
import com.gre.api.modules.admin.user.service.IUserInfoService;
import com.gre.api.result.PageInfo;
import com.gre.api.utils.UtilPage;
import com.gre.sys.modules.admin.userinfo.dao.IUserInfoDao;
@Component
@Service
public class UserInfoService implements IUserInfoService{
	@Autowired
	IUserInfoDao userInfoDao;
//	@Autowired
//	IReferenceService referenceService;
	
	
	@Override
	@Transactional
	public void insert(UserInfo userinfo) {
		if(userinfo.getCreate_time() == null){
			userinfo.setCreate_time(new Date());
		}
		userinfo.setPassword(new Md5Hash(userinfo.getPassword()).toString());
		userinfo.setU_order(1);
		userInfoDao.insert(userinfo);
	}
	@Transactional
	@Override
	public void update(UserInfo userinfo) {
		userInfoDao.update(userinfo);
	}

	@Override
	public UserInfo findOne(Long id) {
		return userInfoDao.selectOne(id);
	}

	@Override
	public PageInfo<UserInfo> findPage(UserInfoParam param) {
		UtilPage.startPage(param);
		List<UserInfo> list=userInfoDao.selectList(param);
		return new PageInfo<UserInfo>(list);
	}
	@Override
	@Transactional
	public void delete(Long id) {
		userInfoDao.delete(id);
	}
	@Transactional
	@Override
	public void delete(List<Long> id) {
		userInfoDao.deleteList(id);
	}
	@Override
	public UserInfo findOne(String username) {
		return userInfoDao.selectOneByName(username);
	}
	@Override
	public UserInfo login(String account, String pwd) {
		String encryptPwd = new Md5Hash(pwd).toString();
		UserInfo result = null;
		UserInfo user = findOne(account);
		if (user == null) {
			throw new RuntimeException("没有此账号！");
		} else {
			result = user;
		}
		if (!encryptPwd.equals(result.getPassword())) {
			throw new RuntimeException("账号密码不匹配！");
		}
		/**
		 * 如果在其他地方登录则，将之前的踢出系统
		 */
//		Collection<Session> list=sessionDAO.getActiveSessions();
//		for (Session session : list) {
//			Object obj=session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
//			if(obj !=null && account.equals(obj.toString())){
//				session.stop();
//			}
//		}
		return result;

	}
	@Override
	@Transactional
	public void register(UserInfo userinfo) {
		UserInfo user=userInfoDao.selectOneByName(userinfo.getUsername());
		if(user != null){
			throw new RuntimeException("账号已经被占用");
		}
		userinfo.setPassword(new Md5Hash(userinfo.getPassword()).toString());
		userInfoDao.insert(userinfo);
		RoleUser ru=new RoleUser();
//		ru.setUser_id(userinfo.getId());
//		ru.setRole_id(7l);
//		referenceService.insertRoleUser(ru);
	}

}
