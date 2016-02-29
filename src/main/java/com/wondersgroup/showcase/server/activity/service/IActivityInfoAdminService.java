package com.wondersgroup.showcase.server.activity.service;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.ActivityInfo;

public interface IActivityInfoAdminService {

	public void insertActivityInfo(Map map);
	public ActivityInfo selectActivityInfoById(String id);
	public List<ActivityInfo> selectActivityInfosByPublisherId(String publisherId);
	public void updateActivityInfo(Map map);
	
}
