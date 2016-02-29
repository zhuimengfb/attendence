package com.wondersgroup.showcase.client.user.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.entity.UserInfo;
import com.wondersgroup.showcase.client.entity.UserLogin;
import com.wondersgroup.showcase.client.user.repository.mybatis.IUserInfoDao;
import com.wondersgroup.showcase.client.user.repository.mybatis.IUserLoginDao;
import com.wondersgroup.showcase.client.user.service.IUserInfoService;
import com.wondersgroup.showcase.client.user.service.IUserLoginService;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.SessionCommons;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
@Service
public class UserLoginService extends BaseService implements IUserLoginService{

	public static final int REGISTER_OK=1;
	public static final int REGISTER_ALREADY=2;
	@Autowired
	IUserLoginDao userLoginDao;
	@Autowired
	IUserInfoService userInfoService;
	@Override
	public int userRegister(Map map) {
		// TODO Auto-generated method stub
		//如果用户不存在才进行注册
		UserLogin userLogin=new UserLogin();
		userLogin.setEmail((String)map.get(UserLogin.EMAIL));
		userLogin.setUserAccount((String)map.get(UserLogin.USER_ACCOUNT));
		userLogin.setId(UUIDGenerator.getUUID());
		userLogin.setPassword((String)map.get(UserLogin.PASSWORD));
		userLogin.setRegisterDate(new Date());
		userLogin.setOrigin(UserLogin.USER_FROM_OWN_WEB);
		userLogin.setFlag(UserLogin.FLAG_NORMAL);
		if (selectUserLoginByAccount(userLogin.getUserAccount())==null){
			userLoginDao.insertUserLogin(userLogin);
			userInfoService.insertUserInfo(map);
			return REGISTER_OK;
		}
		else {
			return REGISTER_ALREADY;
		}
	}

	@Override
	public List<UserLogin> selectUserLogin() {
		// TODO Auto-generated method stub
		return userLoginDao.selectUserLogin();
	}

	@Override
	public UserLogin selectUserLoginById(String id) {
		// TODO Auto-generated method stub
		return userLoginDao.selectUserLoginById(id);
	}

	@Override
	public UserLogin selectUserLoginByAccount(String userAccount) {
		// TODO Auto-generated method stub
		return userLoginDao.selectUserLoginByAccount(userAccount);
	}

	@Override
	public UserInfo userLogin(Map map) {
		// TODO Auto-generated method stub
		UserLogin userLogin=selectUserLoginByAccount((String)map.get(UserLogin.USER_ACCOUNT));
		if (userLogin!=null){
			//登录成功，进行个人信息查询
			if (StringUtils.equals((String)map.get(UserLogin.PASSWORD), userLogin.getPassword())){
				UserInfo userInfo=userInfoService.selectUserByAccount((String)map.get(UserLogin.USER_ACCOUNT));
				return userInfo;
			}
		}
		return null;
	}

}
