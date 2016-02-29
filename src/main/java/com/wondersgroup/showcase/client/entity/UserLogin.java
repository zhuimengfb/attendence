package com.wondersgroup.showcase.client.entity;

import java.io.Serializable;
import java.util.Date;

public class UserLogin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String PASSWORD="password";
	public static final String USER_ACCOUNT="userAccount";
	public static final String EMAIL="email";
	public static final String USER_FROM_OWN_WEB="USER_FROM_OWN_WEB";
	public static final int FLAG_NORMAL = 1;
	
	private String id;
	private String userAccount;
	private String password;
	private String origin;//用户来源
	private String email;//邮箱
	private int flag;//用户状态,0表示删除，1表示正常
	private Date registerDate;//用户注册时间
	private String token;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
