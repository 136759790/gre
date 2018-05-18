package com.gre.api.modules.admin.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gre.api.modules.admin.org.model.Org;
import com.gre.api.result.Result;
/**
 * 基本用户信息
 * @author zxt
 *
 */
public class UserInfo extends Result implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password = "111111";
	private String nickname;
	private String email;
	private Integer age;
	private String phonenumber;
	private String telephone;
	private String address;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date create_time = new Date();
	private Integer u_order;
	
	private List<Org> orgs;
	private String card_no;
	
	public UserInfo() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public List<Org> getOrgs() {
		return orgs;
	}
	public void setOrgs(List<Org> orgs) {
		this.orgs = orgs;
	}


	public Integer getU_order() {
		return u_order;
	}


	public void setU_order(Integer u_order) {
		this.u_order = u_order;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}

	
}
