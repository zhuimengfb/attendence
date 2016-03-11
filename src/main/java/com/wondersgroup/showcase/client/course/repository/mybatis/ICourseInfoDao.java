package com.wondersgroup.showcase.client.course.repository.mybatis;

import java.util.List;
import java.util.Map;

import com.wondersgroup.showcase.client.entity.CourseInfo;
import com.wondersgroup.showcase.core.repository.mybatis.IMyBatisRepository;

@IMyBatisRepository
public interface ICourseInfoDao {

	
	public CourseInfo selectCourseByTitle(String title);
	
	public CourseInfo selectCourseById(String id);
	
	public List<CourseInfo> selectCourseByPage(Map map);
}
