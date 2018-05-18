package com.gre.api.modules.admin.reference.model;

import java.io.Serializable;

import com.gre.api.result.Result;

/**
 * 
 * @author zxt
 * @category 用户角色关联关系表
 *
 */
public class RoleUser extends Result implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long role_id;
	private Long user_id;
	
	
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
	

}
