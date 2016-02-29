package com.wondersgroup.showcase.server.entity;

import java.io.Serializable;

public class UserAdminInfo implements Serializable{

	public static final String USER_ACCOUNT="userAccount";
	public static final String USER_NAME="userName";
	public static final String EMAIL="email";
	
	public static final int FLAG_NORMAL = 1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userAccount;
	private String userName;
	private String email;//邮箱
	private String department;
	private int flag;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
