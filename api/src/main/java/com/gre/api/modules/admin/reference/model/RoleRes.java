package com.gre.api.modules.admin.reference.model;

import java.io.Serializable;

import com.gre.api.result.Result;


public class RoleRes extends Result implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long res_id;
	private Long role_id;
	
	
	public Long getRes_id() {
		return res_id;
	}
	public void setRes_id(Long res_id) {
		this.res_id = res_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	
	
}
