package com.wondersgroup.showcase.client.activity.service.imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.activity.repository.mybatis.IActivityInfoDao;
import com.wondersgroup.showcase.client.activity.service.IActivityInfoService;
import com.wondersgroup.showcase.client.entity.ActivityInfo;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.PageUtils;
@Service
public class ActivityInfoService extends BaseService implements IActivityInfoService {

	@Autowired
	IActivityInfoDao activityInfoDao;
	@Override
	public List<ActivityInfo> selectActivityInfosByPage(Map map) {
		// TODO Auto-generated method stub
		int currentPage=Integer.valueOf((Integer)(map.get("currentPage")));
		map.put("pageSize", 8);
		PageUtils pageUtils=new PageUtils(currentPage);
		map.put("start", pageUtils.getStart());
		map.put("end", pageUtils.getEnd());
		return activityInfoDao.selectActivityInfosByPage(map);
	}
	@Override
	public ActivityInfo selectActivityInfoById(String id) {
		// TODO Auto-generated method stub
		return activityInfoDao.selectActivityInfoById(id);
	}

}
