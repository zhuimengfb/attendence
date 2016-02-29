package com.wondersgroup.showcase.server.activity.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.entity.ActivityInfo;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.DateUtils;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.server.activity.repository.mybatis.IActivityInfoAdminDao;
import com.wondersgroup.showcase.server.activity.service.IActivityInfoAdminService;
@Service
public class ActivityInfoAdminService extends BaseService implements IActivityInfoAdminService {

	@Autowired
	IActivityInfoAdminDao activityInfoAdminDao;
	@Override
	public void insertActivityInfo(Map map) {
		// TODO Auto-generated method stub
		ActivityInfo activityInfo=new ActivityInfo();
		Date date=new Date();
		activityInfo.setActivityDes((String)map.get(ActivityInfo.ACTIVITY_DES));
		activityInfo.setActivityPicAddress((String)map.get(ActivityInfo.ACTIVITY_PIC_ADDRESS));
		activityInfo.setActivityType((String)map.get(ActivityInfo.ACTIVITY_TYPE));
		activityInfo.setEndDate(DateUtils.getDateWithoutSecond((String)map.get(ActivityInfo.END_DATE)));
		activityInfo.setFlag(ActivityInfo.FLAG_NORMAL);
		activityInfo.setGenerateDate(date);
		activityInfo.setId((String)map.get(ActivityInfo.ID));
		activityInfo.setLatitude(Double.valueOf((String)map.get(ActivityInfo.LATITUDE)));
		activityInfo.setLongitude(Double.valueOf((String)map.get(ActivityInfo.LONGITUDE)));
		activityInfo.setModifyDate(date);
		activityInfo.setPlace((String)map.get(ActivityInfo.PLACE));
		activityInfo.setPublisherId((String)map.get(ActivityInfo.PUBLISHER_ID));
		activityInfo.setReserve((String)map.get(ActivityInfo.RESERVE));
		activityInfo.setStartDate(DateUtils.getDateWithoutSecond((String)map.get(ActivityInfo.START_DATE)));
		activityInfo.setStatus(ActivityInfo.STATUS_NORMAL);
		activityInfo.setTitle((String)map.get(ActivityInfo.TITLE));
		activityInfoAdminDao.insertActivityInfo(activityInfo);
	}

	@Override
	public ActivityInfo selectActivityInfoById(String id) {
		// TODO Auto-generated method stub
		return activityInfoAdminDao.selectActivityInfoById(id);
	}

	@Override
	public List<ActivityInfo> selectActivityInfosByPublisherId(String publisherId) {
		// TODO Auto-generated method stub
		return activityInfoAdminDao.selectActivityInfosByPublisherId(publisherId);
	}

	@Override
	public void updateActivityInfo(Map map) {
		// TODO Auto-generated method stub
		ActivityInfo activityInfo=new ActivityInfo();
		Date date=new Date();
		activityInfo.setActivityDes((String)map.get(ActivityInfo.ACTIVITY_DES));
		activityInfo.setActivityPicAddress((String)map.get(ActivityInfo.ACTIVITY_PIC_ADDRESS));
		activityInfo.setActivityType((String)map.get(ActivityInfo.ACTIVITY_TYPE));
		activityInfo.setEndDate(new Date((String)map.get(ActivityInfo.END_DATE)));
		activityInfo.setFlag((Integer)map.get(ActivityInfo.FLAG));
		activityInfo.setId((String)map.get(ActivityInfo.ID));
		activityInfo.setLatitude((Double)map.get(ActivityInfo.LATITUDE));
		activityInfo.setLongitude((Double)map.get(ActivityInfo.LONGITUDE));
		activityInfo.setModifyDate(date);
		activityInfo.setPlace((String)map.get(ActivityInfo.PLACE));
		activityInfo.setPublisherId((String)map.get(ActivityInfo.PUBLISHER_ID));
		activityInfo.setReserve((String)map.get(ActivityInfo.RESERVE));
		activityInfo.setStartDate(new Date((String)map.get(ActivityInfo.START_DATE)));
		activityInfo.setStatus((Integer)map.get(ActivityInfo.STATUS));
		activityInfo.setTitle((String)map.get(ActivityInfo.TITLE));
		activityInfoAdminDao.updateActivityInfo(activityInfo);
	}

}
