package com.gre.gateway.modules.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.gre.api.modules.admin.org.model.Org;
import com.gre.api.modules.admin.org.service.IOrgService;
import com.gre.api.modules.admin.reference.model.OrgUser;
import com.gre.api.modules.admin.reference.model.RoleRes;
import com.gre.api.modules.admin.reference.model.RoleUser;
import com.gre.api.modules.admin.reference.service.IReferenceService;
import com.gre.api.modules.admin.resource.model.Resource;
import com.gre.api.modules.admin.resource.service.IResService;
import com.gre.api.modules.admin.role.model.Role;
import com.gre.api.modules.admin.role.service.IRoleService;
import com.gre.api.modules.admin.user.model.UserInfo;
import com.gre.api.modules.admin.user.model.UserInfoParam;
import com.gre.api.modules.admin.user.service.IUserInfoService;
import com.gre.api.result.PageInfo;
import com.gre.api.result.Result;
import com.gre.api.result.ResultEnum;
import com.gre.api.result.Tree;
import com.gre.api.utils.UtilResult;
import com.gre.api.utils.UtilSecurity;


@Api(value="系统权限基本信息的增删改查",tags="系统权限基本信息的增删改查")
@RestController
@RequestMapping("/sys/")
public class SysController {
	@Reference(check=false)
	IUserInfoService userInfoService;
	@Reference(check=false)
	IOrgService orgService;
	@Reference(check=false)
	IRoleService roleService;
	@Reference(check=false)
	IResService resService;
	@Reference(check=false)
	IReferenceService referenceService;
	
	@ApiOperation(value="新增用户")
	@PostMapping("add/user")
	public Result add(UserInfo userinfo){
		userInfoService.insert(userinfo);
		return userinfo;
	}
	
	@ApiOperation("删除用户")
	@DeleteMapping("user/{id}")
	public Result delete(@PathVariable Long id){
		userInfoService.delete(id);
		return UtilResult.success("删除成功");
	}
	
	@ApiOperation("删除多个用户")
	@DeleteMapping("delete/users")
	public Result deleteList(List<Long> id){
		userInfoService.delete(id);
		return UtilResult.success("删除成功");
	}
	@ApiOperation("修改")
	@PostMapping("update/user")
	public Result update(UserInfo userinfo){
		userInfoService.update(userinfo);
		return UtilResult.success("修改成功");
	}
	@ApiOperation("查看单个用户")
	@GetMapping("user/{id}")
	public UserInfo findOne(@PathVariable Long id){
		UserInfo userinfo=userInfoService.findOne(id);
		return userinfo;
	}
	@ApiOperation(value="查看多个用户")
	@GetMapping("users")
	public PageInfo<UserInfo> findPage(UserInfoParam param){
		return userInfoService.findPage(param);
	}
	
	@ApiOperation("查看分页组织机构")
	@GetMapping("orgs")
	public PageInfo<Org> findOrgPage(@RequestParam Map map){
		return orgService.findPage(map);
	}
	@ApiOperation("查看树形组织机构")
	@GetMapping("org/tree")
	public List<Tree> findOrgTree(@RequestParam Map map){
		return orgService.getOrgTrees(new HashMap());
	}
	@ApiOperation("新增组织机构")
	@PostMapping("org/add")
	public List<Tree> addOrg(Org org){
		if(org.getId() !=null){
			orgService.update(org);
		}else{
			orgService.insert(org);
		}
		return orgService.getOrgTrees(new HashMap());
	}
	@ApiOperation("获取单个组织机构")
	@GetMapping("org/{id}")
	public Result getOrg(@PathVariable Long id){
		return orgService.findOne(id);
	}
	@ApiOperation("删除单个组织机构")
	@PostMapping("org/delete")
	public Result deleteOrg( Long id){
		orgService.delete(id);;
		return UtilResult.success("删除成功");
	}
	@ApiOperation("删除单个角色")
	@PostMapping("role/delete")
	public Result deleteRole( Long id){
		roleService.delete(id);
		return UtilResult.success("删除成功");
	}
	
	@ApiOperation("添加角色/修改角色")
	@PostMapping("role/add")
	public Result addRole(Role role){
		if(role !=null && role.getId() != null){
			roleService.update(role);
			return role;
		}
		roleService.insert(role);
		return role;
	}
	@ApiOperation("获取所有角色")
	@GetMapping("roles")
	public PageInfo<Role> roles(@RequestParam Map map){
		return roleService.findPage(map);
	}
	@ApiOperation("获取所有资源")
	@GetMapping("ress")
	public PageInfo<Resource> ress(@RequestParam Map map){
		return resService.findPage(map);
	}
	
	@ApiOperation("添加资源/修改资源")
	@PostMapping("res/add")
	public Result addRes(Resource res){
		if(res !=null && res.getId() != null){
			resService.update(res);
			return res;
		}
		resService.insert(res);
		return res;
	}
	@ApiOperation("添加资源/修改资源")
	@PostMapping("res/delete")
	public Result deleteRes(Long id){
		resService.delete(id);
		return UtilResult.success("删除成功");
	}
	@ApiOperation("查看树形资源")
	@GetMapping("res/tree")
	public List<Tree> findResTree(@RequestParam Map map){
		return resService.getResTrees(map);
	}
	@ApiOperation("查看树形资源")
	@GetMapping("res/mytree")
	public List<Tree> findMyResTree(@RequestParam Map map){
		UserInfo userinfo= UtilSecurity.getCurUser();
		map.put("user_id", userinfo.getId());
		return resService.getResTrees(map);
	}
	
	@ApiOperation("保存用户和部门关系")
	@PostMapping("org/user")
	public Result saveOrgUser(@RequestParam Long[] org_id,Long user_id){
		OrgUser oud=new OrgUser();
		oud.setUser_id(user_id);
		referenceService.deleteOrgUser(oud);
		for (Long oid : org_id) {
			OrgUser ou=new OrgUser();
			ou.setOrg_id(oid);
			ou.setUser_id(user_id);
			referenceService.insertOrgUser(ou);
		}
		return UtilResult.success("添加成功。");
	}
	@ApiOperation("保存用户和角色关系")
	@PostMapping("role/user")
	public Result saveRoleUser(RoleUser roleUser){
		try {
			referenceService.insertRoleUser(roleUser);
			roleUser.setResult_msg("添加关系成功！");
		} catch (Exception e) {
			if(e instanceof DuplicateKeyException){
				roleUser.setResult_msg("此 角色-用户 关系已存在！");
				roleUser.setResult_code("500");
				roleUser.setResult_status(ResultEnum.ERROR.getValue());
			}else{
				throw e;
			}
		}
		return roleUser;
	}
	@ApiOperation("删除用户和角色关系")
	@PostMapping("role/user/delete")
	public Result deleteRoleUser(RoleUser roleUser){
		referenceService.deleteRoleUser(roleUser);
		roleUser.setResult_msg("删除关系成功！");
		return roleUser;
	}
	@ApiOperation("保存资源和角色关系")
	@PostMapping("role/res")
	public Result saveRoleRes(RoleRes roleRes){
		try {
			referenceService.insertRoleRes(roleRes);
			roleRes.setResult_msg("保存成功");
		} catch (DuplicateKeyException e) {
			roleRes.setResult_status(ResultEnum.ERROR.getValue());
			roleRes.setResult_msg("关系已经存在。");
			e.printStackTrace();
		}catch(Exception e){
			roleRes.setResult_status(ResultEnum.ERROR.getValue());
			roleRes.setResult_msg("保存失败");
			e.printStackTrace();
		}
		return roleRes;
	}
	@ApiOperation("删除资源和角色关系")
	@PostMapping("role/res/delete")
	public Result deleteRoleRes(RoleRes roleRes){
		try {
			referenceService.deleteRoleRes(roleRes);
			roleRes.setResult_msg("删除成功");
		}catch(Exception e){
			roleRes.setResult_status(ResultEnum.ERROR.getValue());
			roleRes.setResult_msg("删除失败");
			e.printStackTrace();
		}
		return roleRes;
	}
	@ApiOperation("获取机构下的所有用户，带分页")
	@GetMapping("org/users")
	public PageInfo<UserInfo> findUserPage(@RequestParam Map map){
		return referenceService.findUserPage(map);
	}
	@ApiOperation("删除部门下的某个用户")
	@PostMapping("org/delete/user")
	public Result deleteOrgUser(OrgUser orgUser){
		referenceService.deleteOrgUser(orgUser);
		return UtilResult.success("删除成功");
	}
	@ApiOperation("获取当前登陆用户")
	@GetMapping("user/login")
	public Result getCurrentUser(){
		if(SecurityUtils.getSubject().isAuthenticated()){
			return UtilSecurity.getCurUser();
		}else{
			return UtilResult.error("用户未登录");
		}
	}
	@ApiOperation("用户登出")
	@PostMapping("user/logout")
	public Result logout(){
		SecurityUtils.getSubject().logout();
		return UtilResult.success("用户登出");
	}
	@ApiOperation("是否属于某角色")
	@GetMapping("role/{role_code}")
	public Boolean isRoleAdmin(@PathVariable String role_code){
		if(StringUtils.isEmpty(role_code)){
			return false;
		}
		return SecurityUtils.getSubject().hasRole(role_code);
	}
	
}
