package com.wondersgroup.showcase.client.course.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.showcase.client.course.repository.mybatis.ICourseInfoDao;
import com.wondersgroup.showcase.client.course.service.ICourseInfoService;
import com.wondersgroup.showcase.client.entity.CourseInfo;
import com.wondersgroup.showcase.core.service.BaseService;
import com.wondersgroup.showcase.core.utils.PageUtils;

@Service
public class CourseInfoService extends BaseService implements ICourseInfoService{

	@Autowired
	ICourseInfoDao courseInfoDao;
	@Override
	public CourseInfo selectCourseById(String id) {
		// TODO Auto-generated method stub
		return courseInfoDao.selectCourseById(id);
	}
	@Override
	public CourseInfo selectCourseByTitle(String title) {
		// TODO Auto-generated method stub
		return courseInfoDao.selectCourseByTitle(title);
	}

	@Override
	public List<CourseInfo> selectCourseByPage(int pageNum) {
		// TODO Auto-generated method stub
		PageUtils pageUtils=new PageUtils(pageNum);
		Map<String,Integer> map= new HashMap<String, Integer>();
		map.put("start", pageUtils.getStart());
		map.put("end", pageUtils.getEnd());
		map.put("pageSize", pageUtils.getPageSize());
		return courseInfoDao.selectCourseByPage(map);
	}
}
