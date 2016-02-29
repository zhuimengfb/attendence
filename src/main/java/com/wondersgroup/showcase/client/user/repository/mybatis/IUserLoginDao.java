package com.wondersgroup.showcase.client.user.repository.mybatis;

import java.util.List;

import com.wondersgroup.showcase.client.entity.UserLogin;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface IUserLoginDao {

	public void insertUserLogin(UserLogin userLogin);
	public List<UserLogin> selectUserLogin();
	public UserLogin selectUserLoginById(String id);
	public UserLogin selectUserLoginByAccount(String userAccount);
}
