package com.gre.api.modules.admin.user.model;


import java.util.Date;

import com.gre.api.result.Param;


public class UserInfoParam extends Param{
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getPay_time() {
		return pay_time;
	}
	public void setPay_time(Date pay_time) {
		this.pay_time = pay_time;
	}
	private String name;
	private Integer user_id;
	private Date create_time;
	private Integer order_status;
	private Integer price;
	private Date pay_time;
	
	/** 主键ID **/
	private Long id;
	/** 账号 */
	private String username;
	/** 密码 */
	private String password;
	/** 昵称  */
	private String nickname;
	/** 邮箱地址  */
	private String email;
	/** 年龄  */
	private Integer age;
	/** 手机号码  */
	private String phonenumber;
	/** 座机 **/
	private String telephone;
	/** 地址 */
	private String address;
	/** 创建时间开始 */
	private Date create_time_start;
	/** 创建时间结束 */
	private Date create_time_end;
	/** 角色ID **/
	private Long role_id;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreate_time_start() {
		return create_time_start;
	}
	public void setCreate_time_start(Date create_time_start) {
		this.create_time_start = create_time_start;
	}
	public Date getCreate_time_end() {
		return create_time_end;
	}
	public void setCreate_time_end(Date create_time_end) {
		this.create_time_end = create_time_end;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
