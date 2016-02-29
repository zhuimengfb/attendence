package com.wondersgroup.showcase.client.activity.service;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.ActivityInfo;

public interface IActivityInfoService {

	public List<ActivityInfo> selectActivityInfosByPage(Map map);
	
	public ActivityInfo selectActivityInfoById(String id);
}
