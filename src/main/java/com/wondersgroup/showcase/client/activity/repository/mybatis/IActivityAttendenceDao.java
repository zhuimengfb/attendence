package com.wondersgroup.showcase.client.activity.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.ActivityAttendence;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;
@IMyBatisRepository
public interface IActivityAttendenceDao {

	public void insertActivityAttendence(ActivityAttendence activityAttendence);
	
	public List<ActivityAttendence> selectActivityAttendencesByActivityId(String activityId);
	
	public List<ActivityAttendence> selectActivityAttendencesByUserId(String userId);
	
	public ActivityAttendence selectActivityAttendenceByActivityIdAndUserId(Map map);
}
