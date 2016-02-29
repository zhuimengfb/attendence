package com.wondersgroup.showcase.client.user.repository.mybatis;

import com.wondersgroup.showcase.client.entity.UserInfo;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface IUserInfoDao {

	
	public void insertUserInfo(UserInfo userInfo);
	public UserInfo selectUserInfoById(String id);
	public UserInfo selectUserByAccount(String account);
	public void updateUserInfo(UserInfo userInfo);
}
