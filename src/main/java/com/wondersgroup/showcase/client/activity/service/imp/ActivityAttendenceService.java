package com.wondersgroup.showcase.client.activity.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.activity.repository.mybatis.IActivityAttendenceDao;
import com.wondersgroup.showcase.client.activity.service.IActivityAttendenceService;
import com.wondersgroup.showcase.client.entity.ActivityAttendence;
@Service
public class ActivityAttendenceService implements IActivityAttendenceService {

	@Autowired
	IActivityAttendenceDao activityAttendenceDao;
	@Override
	public void insertActivityAttendence(ActivityAttendence activityAttendence) {
		// TODO Auto-generated method stub
		activityAttendenceDao.insertActivityAttendence(activityAttendence);
	}

	@Override
	public List<ActivityAttendence> selectActivityAttendencesByActivityId(
			String activityId) {
		// TODO Auto-generated method stub
		return activityAttendenceDao.selectActivityAttendencesByActivityId(activityId);
	}

	@Override
	public List<ActivityAttendence> selectActivityAttendencesByUserId(
			String userId) {
		// TODO Auto-generated method stub
		return activityAttendenceDao.selectActivityAttendencesByUserId(userId);
	}

	@Override
	public ActivityAttendence selectActivityAttendenceByActivityIdAndUserId(
			String activityId, String userId) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String,String>();
		map.put("activityId", activityId);
		map.put("userId", userId);
		return activityAttendenceDao.selectActivityAttendenceByActivityIdAndUserId(map);
	}

}
