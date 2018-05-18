package com.gre.api.modules.admin.reference.model;

import java.io.Serializable;

import com.gre.api.result.Result;

/**
 * 用户部门关联关系表
 * @author zxt
 *
 */
public class OrgUser extends Result implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Long user_id;
	private Long org_id;
	
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public Long getOrg_id() {
		return org_id;
	}
	public void setOrg_id(Long org_id) {
		this.org_id = org_id;
	}
	
	
	
	
}
