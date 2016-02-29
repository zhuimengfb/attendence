package com.wondersgroup.showcase.server.user.repository.mybatis;

import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;
import com.wondersgroup.showcase.server.entity.UserAdminInfo;

@IMyBatisRepository
public interface IUserAdminInfoDao {

	public void insertUserAdminInfo(UserAdminInfo userAdminInfo);
	public UserAdminInfo selectUserAdminInfoById(String id);
	public UserAdminInfo selectUserAdminInfoByAccount(String userAccount);
	public void updateUserAdminInfo(UserAdminInfo userAdminInfo);
}
