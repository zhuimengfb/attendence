package com.wondersgroup.showcase.server.user.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.server.entity.UserAdmin;
import com.wondersgroup.showcase.server.entity.UserAdminInfo;
import com.wondersgroup.showcase.server.user.repository.mybatis.IUserConsoleDao;
import com.wondersgroup.showcase.server.user.service.IUserAdminInfoService;
import com.wondersgroup.showcase.server.user.service.IUserConsoleService;
@Service
public class UserConsoleService extends BaseService implements IUserConsoleService {
	
	public static final int REGISTER_OK=1;
	public static final int REGISTERED_ALREADY=2;
	
	@Autowired
	IUserConsoleDao userConsoleDao;
	
	@Autowired
	IUserAdminInfoService userAdminInfoService;

	@Override
	public void insertUserAdmin(Map map) {
		// TODO Auto-generated method stub
		UserAdmin userAdmin=new UserAdmin();
		userAdmin.setId(UUIDGenerator.getUUID());
		userAdmin.setEmail((String)map.get(UserAdmin.EMAIL));
		userAdmin.setFlag(UserAdmin.FLAG_NORMAL);
		userAdmin.setLevel(UserAdmin.LEVEL_NORMAL);
		userAdmin.setPassword((String)map.get(UserAdmin.PASSWORD));
		userAdmin.setRegisterDate(new Date());
		userAdmin.setUserAccount((String)map.get(UserAdmin.USER_ACCOUNT));
		userAdmin.setUserName((String)map.get(UserAdmin.USER_NAME));
		userConsoleDao.insertUserAdmin(userAdmin);
	}

	@Override
	public UserAdmin selectUserAdminById(String id) {
		// TODO Auto-generated method stub
		return userConsoleDao.selectUserAdminById(id);
	}

	@Override
	public UserAdmin selectUserAdminByUserAccount(String userAccount) {
		// TODO Auto-generated method stub
		return userConsoleDao.selectUserAdminByUserAccount(userAccount);
	}

	@Override
	public List<UserAdmin> selectUserAdmins() {
		// TODO Auto-generated method stub
		return userConsoleDao.selectUserAdmins();
	}

	@Override
	public void updateUserAdmin(Map map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserAdminInfo login(Map map) {
		// TODO Auto-generated method stub
		UserAdmin userAdmin=selectUserAdminByUserAccount((String)map.get(UserAdmin.USER_ACCOUNT));
		if (userAdmin==null) return null;
		if (StringUtils.equals((String)map.get(UserAdmin.PASSWORD), userAdmin.getPassword())){
			UserAdminInfo userAdminInfo=userAdminInfoService.selectUserAdminInfoByAccount(userAdmin.getUserAccount());
			return userAdminInfo;
		}
		return null;
	}

	@Override
	public int register(Map map) {
		// TODO Auto-generated method stub
		UserAdmin userAdmin=selectUserAdminByUserAccount((String)map.get(UserAdmin.USER_ACCOUNT));
		if (userAdmin!=null) return REGISTERED_ALREADY;
		insertUserAdmin(map);
		userAdminInfoService.insertUserAdminInfo(map);
		return REGISTER_OK;
	}

}
