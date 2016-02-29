package com.wondersgroup.showcase.client.user.service;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.UserInfo;
import com.wondersgroup.showcase.client.entity.UserLogin;

public interface IUserLoginService {

	public int userRegister(Map map);
	public List<UserLogin> selectUserLogin();
	public UserLogin selectUserLoginById(String id);
	public UserLogin selectUserLoginByAccount(String userAccount);
	
	//根据传入的账号密码进行登录，成功则返回个人信息，失败返回null
	public UserInfo userLogin(Map map);
}
