package com.wondersgroup.showcase.server.user.service;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.server.entity.UserAdmin;
import com.wondersgroup.showcase.server.entity.UserAdminInfo;


public interface IUserConsoleService {

	public void insertUserAdmin(Map map);

	// 根据id进行查询
	public UserAdmin selectUserAdminById(String id);

	// 根据学号/工号进行查询
	public UserAdmin selectUserAdminByUserAccount(String userAccount);

	// 查询所有的管理者账号
	public List<UserAdmin> selectUserAdmins();

	public void updateUserAdmin(Map map);

	
	public UserAdminInfo login(Map map);
	
	public int register(Map map);
}
