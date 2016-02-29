package com.wondersgroup.showcase.server.entity;

import java.io.Serializable;
import java.util.Date;

public class UserAdmin implements Serializable{
	
	
	public static final int LEVEL_NORMAL=1;
	
	public static final int FLAG_NORMAL=1;
	
	public static final String PASSWORD="password";
	public static final String USER_ACCOUNT="userAccount";
	public static final Object USER_NAME = "userName";
	public static final Object EMAIL = "email";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private String id;
	private String userAccount;
	private String userName;
	private String password;
	private String email;//邮箱
	private Date registerDate;
	private int flag;//管理员状态,0表示删除，1表示未审核，2表示审核通过
	private int level;//级别
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
