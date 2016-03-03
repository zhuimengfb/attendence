package com.wondersgroup.showcase.server.course.service.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.entity.CourseInfo;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.DateUtils;
import com.wondersgroup.showcase.core.utils.PageUtils;
import com.wondersgroup.showcase.core.utils.UUIDGenerator;
import com.wondersgroup.showcase.server.course.repository.mybatis.ICourseInfoServerDao;
import com.wondersgroup.showcase.server.course.service.ICourseInfoServerService;
@Service
public class CourseInfoServerService extends BaseService implements ICourseInfoServerService{

	private static final long DEFAULT_COURSE_DURATION=7200000;
	@Autowired
	ICourseInfoServerDao courseInfoServerDao;
	@Override
	public void insertCourseInfo(Map map) {
		// TODO Auto-generated method stub
		if (courseInfoServerDao.selectCourseByTitle((String)map.get(CourseInfo.TITLE))!=null)
			return;
		CourseInfo courseInfo=new CourseInfo();
		Date date=new Date();
		if (StringUtils.isEmpty((String)map.get(CourseInfo.START_DATE))){
			courseInfo.setStartDate(date);
			courseInfo.setEndDate(new Date(date.getTime()+DEFAULT_COURSE_DURATION));
		}
		else{
			Date startDate=DateUtils.getDateWithoutSecond((String)map.get(CourseInfo.START_DATE));
			courseInfo.setStartDate(startDate);
			if (StringUtils.isEmpty((String)map.get(CourseInfo.END_DATE))){
				courseInfo.setEndDate(new Date(startDate.getTime()+DEFAULT_COURSE_DURATION));
			}
			else{
				courseInfo.setEndDate(DateUtils.getDateWithoutSecond((String)map.get(CourseInfo.END_DATE)));
			}
		}
		courseInfo.setDepartment((String)map.get(CourseInfo.DEPARTMENT));
		courseInfo.setFlag(Integer.parseInt((String)map.get(CourseInfo.FLAG)));
		courseInfo.setPublisherId((String)map.get(CourseInfo.PUBLISHER_ID));
		courseInfo.setGenerateDate(date);
		courseInfo.setId(UUIDGenerator.getUUID());
		courseInfo.setModifyDate(date);
		courseInfo.setPicAddress((String)map.get(CourseInfo.PIC_ADDRESS));
		courseInfo.setPlace((String)map.get(CourseInfo.PLACE));
		courseInfo.setReserve((String)map.get(CourseInfo.RESERVE));
		courseInfo.setTitle((String)map.get(CourseInfo.TITLE));
		courseInfo.setDescription((String)map.get(CourseInfo.DESCRIPTION));
		courseInfo.setCredit(Integer.parseInt((String)map.get(CourseInfo.CREDIT)));
		courseInfoServerDao.insertCourseInfo(courseInfo);
	}

	@Override
	public CourseInfo selectCourseByTitle(String title) {
		// TODO Auto-generated method stub
		return courseInfoServerDao.selectCourseByTitle(title);
	}

	@Override
	public List<CourseInfo> selectCourseByPage(int pageNum) {
		// TODO Auto-generated method stub
		PageUtils pageUtils=new PageUtils(pageNum);
		Map<String,Integer> map= new HashMap<String, Integer>();
		map.put("start", pageUtils.getStart());
		map.put("end", pageUtils.getEnd());
		map.put("pageSize", pageUtils.getPageSize());
		return courseInfoServerDao.selectCourseByPage(map);
	}

	@Override
	public void updateCOurseInfo(Map map) {
		// TODO Auto-generated method stub
		CourseInfo courseInfoOld=courseInfoServerDao.selectCourseByTitle((String)map.get(CourseInfo.TITLE));
		if (courseInfoOld==null)
			return;
		CourseInfo courseInfo=new CourseInfo();
		Date date=new Date();
		if (StringUtils.isEmpty((String)map.get(CourseInfo.START_DATE))){
			courseInfo.setStartDate(date);
			courseInfo.setEndDate(new Date(date.getTime()+DEFAULT_COURSE_DURATION));
		}
		else{
			Date startDate=DateUtils.getDateWithoutSecond((String)map.get(CourseInfo.START_DATE));
			courseInfo.setStartDate(startDate);
			if (StringUtils.isEmpty((String)map.get(CourseInfo.END_DATE))){
				courseInfo.setEndDate(new Date(startDate.getTime()+DEFAULT_COURSE_DURATION));
			}
			else{
				courseInfo.setEndDate(DateUtils.getDateWithoutSecond((String)map.get(CourseInfo.END_DATE)));
			}
		}
		courseInfo.setDepartment((String)map.get(CourseInfo.DEPARTMENT));
		courseInfo.setFlag(Integer.parseInt((String)map.get(CourseInfo.FLAG)));
		courseInfo.setPublisherId((String)map.get(CourseInfo.PUBLISHER_ID));
		courseInfo.setGenerateDate(courseInfo.getGenerateDate());
		courseInfo.setId(courseInfoOld.getId());
		courseInfo.setModifyDate(date);
		if (StringUtils.isEmpty((String)map.get(CourseInfo.PIC_ADDRESS)))
			courseInfo.setPicAddress(courseInfoOld.getPicAddress());
		else courseInfo.setPicAddress((String)map.get(CourseInfo.PIC_ADDRESS));
		courseInfo.setPlace((String)map.get(CourseInfo.PLACE));
		courseInfo.setReserve((String)map.get(CourseInfo.RESERVE));
		courseInfo.setTitle((String)map.get(CourseInfo.TITLE));
		courseInfo.setDescription((String)map.get(CourseInfo.DESCRIPTION));
		courseInfo.setCredit(Integer.parseInt((String)map.get(CourseInfo.CREDIT)));
		courseInfoServerDao.updateCourseInfo(courseInfo);
	}

}
