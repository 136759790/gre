package com.gre.api.modules.admin.org.model;

import java.io.Serializable;
import java.util.List;

import com.gre.api.annotation.Tree;
import com.gre.api.enums.TreeSwitchEnum;
import com.gre.api.result.Result;


public class Org extends Result implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Tree
	private Long id;
	@Tree(TreeSwitchEnum.TEXT)
	private String org_name;
	private String org_remark;
	@Tree(TreeSwitchEnum.PID)
	private String parent_id;
	private String type_code;
	private String type_value;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getOrg_remark() {
		return org_remark;
	}
	public void setOrg_remark(String org_remark) {
		this.org_remark = org_remark;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public String getType_value() {
		return type_value;
	}
	public void setType_value(String type_value) {
		this.type_value = type_value;
	}
}
