package com.wondersgroup.showcase.server.user.service.imp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.server.entity.UserAdminInfo;
import com.wondersgroup.showcase.server.user.repository.mybatis.IUserAdminInfoDao;
import com.wondersgroup.showcase.server.user.service.IUserAdminInfoService;
@Service
public class UserAdminInfoService extends BaseService implements IUserAdminInfoService {

	@Autowired
	IUserAdminInfoDao userAdminInfoDao;
	@Override
	public void insertUserAdminInfo(Map map) {
		// TODO Auto-generated method stub
		UserAdminInfo userAdminInfo=new UserAdminInfo();
		userAdminInfo.setId(UUIDGenerator.getUUID());
		userAdminInfo.setEmail((String)map.get(UserAdminInfo.EMAIL));
		userAdminInfo.setUserAccount((String)map.get(UserAdminInfo.USER_ACCOUNT));
		userAdminInfo.setUserName((String)map.get(UserAdminInfo.USER_NAME));
		userAdminInfo.setFlag(UserAdminInfo.FLAG_NORMAL);
		if (userAdminInfoDao.selectUserAdminInfoByAccount(userAdminInfo.getUserAccount())==null)
			userAdminInfoDao.insertUserAdminInfo(userAdminInfo);
	}

	@Override
	public UserAdminInfo selectUserAdminInfoById(String id) {
		// TODO Auto-generated method stub
		return userAdminInfoDao.selectUserAdminInfoById(id);
	}

	@Override
	public UserAdminInfo selectUserAdminInfoByAccount(String account) {
		// TODO Auto-generated method stub
		return userAdminInfoDao.selectUserAdminInfoByAccount(account);
	}

	@Override
	public void updateUserAdminInfo(UserAdminInfo userAdminInfo) {
		// TODO Auto-generated method stub
		userAdminInfoDao.updateUserAdminInfo(userAdminInfo);
	}

}
