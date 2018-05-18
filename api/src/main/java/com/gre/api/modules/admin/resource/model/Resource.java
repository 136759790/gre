package com.gre.api.modules.admin.resource.model;

import java.io.Serializable;

import com.gre.api.annotation.Tree;
import com.gre.api.enums.TreeSwitchEnum;
import com.gre.api.result.Result;


public class Resource extends Result implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Tree
	private Long id;
	private String res_code;
	@Tree(TreeSwitchEnum.TEXT)
	private String res_name;
	private String res_remark;
	private String res_type;
	private String res_enable;
	private String res_url;
	@Tree(TreeSwitchEnum.PID)
	private String parent_id;
	private Integer res_order;
	private String icon;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRes_code() {
		return res_code;
	}
	public void setRes_code(String res_code) {
		this.res_code = res_code;
	}
	public String getRes_name() {
		return res_name;
	}
	public void setRes_name(String res_name) {
		this.res_name = res_name;
	}
	public String getRes_remark() {
		return res_remark;
	}
	public void setRes_remark(String res_remark) {
		this.res_remark = res_remark;
	}
	public String getRes_type() {
		return res_type;
	}
	public void setRes_type(String res_type) {
		this.res_type = res_type;
	}
	public String getRes_enable() {
		return res_enable;
	}
	public void setRes_enable(String res_enable) {
		this.res_enable = res_enable;
	}
	public String getRes_url() {
		return res_url;
	}
	public void setRes_url(String res_url) {
		this.res_url = res_url;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public Integer getRes_order() {
		return res_order;
	}
	public void setRes_order(Integer res_order) {
		this.res_order = res_order;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	@Override
	public String toString() {
		return "Resource [id=" + id + ", res_code=" + res_code + ", res_name="
				+ res_name + ", res_remark=" + res_remark + ", res_type="
				+ res_type + ", res_enable=" + res_enable + ", res_url="
				+ res_url + ", parent_id=" + parent_id + ", res_order="
				+ res_order + ", icon=" + icon + "]";
	}
	
	
	
	
	
	
	
	
}
