package com.gre.api.modules.admin.role.model;

import java.io.Serializable;

import com.gre.api.result.Result;


public class Role extends Result implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String role_code;
	private String role_name;
	private String role_remark;
	private String role_enable;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole_code() {
		return role_code;
	}
	public void setRole_code(String role_code) {
		this.role_code = role_code;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_remark() {
		return role_remark;
	}
	public void setRole_remark(String role_remark) {
		this.role_remark = role_remark;
	}
	public String getRole_enable() {
		return role_enable;
	}
	public void setRole_enable(String role_enable) {
		this.role_enable = role_enable;
	}
	
	
	
	
	
}
