package com.wondersgroup.showcase.server.activity.repository.mybatis;

import java.util.List;

import com.wondersgroup.showcase.client.entity.ActivityInfo;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface IActivityInfoAdminDao {
	
	public void insertActivityInfo(ActivityInfo activityInfo);
	public ActivityInfo selectActivityInfoById(String id);
	public List<ActivityInfo> selectActivityInfosByPublisherId(String id);
	public void updateActivityInfo(ActivityInfo activityInfo);
	
}
