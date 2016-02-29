package com.wondersgroup.showcase.client.user.service.imp;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.entity.UserInfo;
import com.wondersgroup.showcase.client.user.repository.mybatis.IUserInfoDao;
import com.wondersgroup.showcase.client.user.service.IUserInfoService;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
@Service
public class UserInfoService extends BaseService implements IUserInfoService {

	@Autowired
	IUserInfoDao userInfoDao;
	
	@Override
	public void insertUserInfo(Map map) {
		// TODO Auto-generated method stub
		if (selectUserByAccount((String)map.get(UserInfo.USER_ACCOUNT))==null){
			UserInfo userInfo=new UserInfo();
			userInfo.setId(UUIDGenerator.getUUID());
			userInfo.setUserAccount((String)map.get(UserInfo.USER_ACCOUNT));
			userInfo.setUserName((String)map.get(UserInfo.USER_NAME));
			userInfo.setBirthday(new Date());
			userInfo.setFlag(UserInfo.FLAG_NORMAL);
			userInfo.setPersonalDes("");
			userInfo.setReserve("");
			userInfo.setSex(UserInfo.SEX_MALE);
			userInfo.setType(UserInfo.TYPE_NORMAL);
			userInfoDao.insertUserInfo(userInfo);
		}
	}

	@Override
	public UserInfo selectUserInfoById(String id) {
		// TODO Auto-generated method stub
		return userInfoDao.selectUserInfoById(id);
	}

	@Override
	public UserInfo selectUserByAccount(String account) {
		// TODO Auto-generated method stub
		return userInfoDao.selectUserByAccount(account);
	}

	@Override
	public void updateUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		if (selectUserInfoById(userInfo.getId())!=null)
			userInfoDao.updateUserInfo(userInfo);
	}

}
