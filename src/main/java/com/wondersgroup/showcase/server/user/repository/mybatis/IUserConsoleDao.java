package com.wondersgroup.showcase.server.user.repository.mybatis;


import java.util.List;

import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;
import com.wondersgroup.showcase.server.entity.UserAdmin;
@IMyBatisRepository
public interface IUserConsoleDao {
	
	public void insertUserAdmin(UserAdmin userAdmin);
	
	//根据id进行查询
	public UserAdmin selectUserAdminById(String id);
	
	//根据学号/工号进行查询
	public UserAdmin selectUserAdminByUserAccount(String userAccount);
	
	//查询所有的管理者账号
	public List<UserAdmin> selectUserAdmins();
	
	public void updateUserAdmin(UserAdmin userAdmin);

}
