package com.wondersgroup.showcase.client.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户的个人信息，在注册后自动生成默认的账号存储在数据库，后期用户可以修改自己的信息
 * 管理员注册后同样生成个人信息
 * @author bo
 *
 */
public class UserInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static final String ID="id";
	public static final String USER_NAME="userName";
	public static final String USER_ACCOUNT="userAccount";


	public static final int FLAG_NORMAL = 1;

	public static final int SEX_FEMALE = 0;
	public static final int SEX_MALE = 1;


	public static final int TYPE_NORMAL = 0;
	public static final int TYPE_ADMIN = 1;
	
	private String id;
	private String userName;//用户姓名
	private String userAccount;//用户学号/工号
	private int sex;//性别
	private Date birthday;//出生年月日
	private int type;//0为普通用户，1表示管理员
	private String personalDes;//个人描述
	private String reserve;//保留字段
	private int flag;//状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getPersonalDes() {
		return personalDes;
	}
	public void setPersonalDes(String personalDes) {
		this.personalDes = personalDes;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	
}
