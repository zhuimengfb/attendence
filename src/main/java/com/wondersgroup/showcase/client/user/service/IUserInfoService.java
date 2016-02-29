package com.wondersgroup.showcase.client.user.service;

import java.util.Map;

import com.wondersgroup.showcase.client.entity.UserInfo;

public interface IUserInfoService {

	public void insertUserInfo(Map map);
	public UserInfo selectUserInfoById(String id);
	public UserInfo selectUserByAccount(String account);
	public void updateUserInfo(UserInfo userInfo);
}
