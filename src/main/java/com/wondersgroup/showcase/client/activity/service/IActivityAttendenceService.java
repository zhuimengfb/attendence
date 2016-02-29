package com.wondersgroup.showcase.client.activity.service;

import java.util.List;

import com.wondersgroup.showcase.client.entity.ActivityAttendence;

public interface IActivityAttendenceService {

public void insertActivityAttendence(ActivityAttendence activityAttendence);
	
	public List<ActivityAttendence> selectActivityAttendencesByActivityId(String activityId);
	
	public List<ActivityAttendence> selectActivityAttendencesByUserId(String userId);
	
	public ActivityAttendence selectActivityAttendenceByActivityIdAndUserId(String activityId,String userId);
}
