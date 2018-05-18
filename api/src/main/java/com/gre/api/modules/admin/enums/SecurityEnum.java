package com.gre.api.modules.admin.enums;

public enum SecurityEnum {
	SESSION_KEY(1,"session_key","存储在session中的用户信息");
	
	private Integer id;
	private String code;
	private String desc;
	
	
	
	private SecurityEnum(Integer id, String code, String desc) {
		this.id = id;
		this.code = code;
		this.desc = desc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
