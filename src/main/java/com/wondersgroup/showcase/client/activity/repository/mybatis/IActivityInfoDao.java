package com.wondersgroup.showcase.client.activity.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.ActivityInfo;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface IActivityInfoDao {

	public List<ActivityInfo> selectActivityInfosByPage(Map map);
	
	public ActivityInfo selectActivityInfoById(String id);
}
