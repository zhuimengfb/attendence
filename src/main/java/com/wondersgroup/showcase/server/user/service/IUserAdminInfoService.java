package com.wondersgroup.showcase.server.user.service;

import java.util.Map;

import com.wondersgroup.showcase.server.entity.UserAdminInfo;

public interface IUserAdminInfoService {

	public void insertUserAdminInfo(Map map);
	public UserAdminInfo selectUserAdminInfoById(String id);
	public UserAdminInfo selectUserAdminInfoByAccount(String account);
	public void updateUserAdminInfo(UserAdminInfo userAdminInfo);
	
}
